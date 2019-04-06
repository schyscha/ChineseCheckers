package ChineseCheckers.ChineseCheckers;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Player extends JFrame
{
	 private static int PORT = 9070;
	 private BufferedReader in;
	 private PrintWriter out;
	 private String serverAddress;
	 private int playerID = -1;
	 private int playerNo = 0;
	 private GamePanel gamePanel;
	 private JPanel panel;
	 private GridBagConstraints c;
	 private int playerNumber;
	 JButton skip;
	 JButton move;
	 JTextArea messageArea;
	 JLabel messages;
	 
	 public Player() throws Exception
	 { 
		 setSize(750, 600);
		 setTitle("Chinese Checkers");

		 messageArea = new JTextArea(8, 20);
		 messageArea.setEditable(false);
		 skip = new JButton("Pomiń ruch");
		 move = new JButton("Wykonaj ruch");

		 messageArea.setEditable(false);
		 
		 move.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
		     if(gamePanel.getChecked()==2)
		     {
		    	 out.println(gamePanel.getMove());
		    	 gamePanel.reset();
		    	 messageArea.setText("");
		     }
		   }
		 });
		 
		 
		 skip.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
			   out.println("SKIP");
			   gamePanel.reset();
			   messageArea.setText("Promień nr " + playerID + "\n");
		   }
		 });
		 
		 panel = new JPanel(new GridBagLayout());
		 
		 add(panel, "East");
		 
		 c = new GridBagConstraints();
		 c.insets = new Insets(10, 10, 90, 10);
		 c.gridx = 0;
		 c.gridy = 1;
		 panel.add(messageArea, c);
		 c.gridx = 0;
		 c.gridy = 2;
		 
		 setVisible(true);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setResizable(true);
     }
	 
     
	 public void play() throws IOException
	 {
		 Socket socket = new Socket(serverAddress, 8000);
		 in = new BufferedReader(new InputStreamReader(
		            socket.getInputStream()));
		 out = new PrintWriter(socket.getOutputStream(), true);
		 
		 
		 while (true)
		 {
			 String line = in.readLine();
			 
			 String input="";
			 //W przypadku gdy żadna gra nie jest rozpoczeta użytkownik może stwworzyc nowa
			 if(line.startsWith("CREATEGAME"))
			 {
				 int response = JOptionPane.showConfirmDialog(null, "Czy chcesz stworzyc nowa rozgrywke?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				 
				 if (response == JOptionPane.NO_OPTION || response == JOptionPane.CLOSED_OPTION)
				 {
				     out.println("NO");
				     System.exit(0);	
				 }
				 
				 else if(response == JOptionPane.YES_OPTION)
				 {
					 String[] choices = {"2", "3", "4", "6"};
					 input = (String) JOptionPane.showInputDialog(null, "Wybierz liczbe graczy", "Nowa rozgrywka",
							 JOptionPane.QUESTION_MESSAGE, null, choices,choices[1]);
					 if(input!=null)
					 {
						 playerNumber = Integer.parseInt(input);
						 out.println(input);
					 }
					 
					 else
						 System.exit(0);
				 }
			 }
			 
			 else if(line.startsWith("BOT"))
			 {
				 int response = JOptionPane.showConfirmDialog(null, "Czy chcesz stworzyc graczy boty?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				 
				 if (response == JOptionPane.NO_OPTION || response == JOptionPane.CLOSED_OPTION)
				     out.println("NO");
				 
				 else if(response == JOptionPane.YES_OPTION)
				 {
					 String[] choices = new String[playerNumber-1];
					 
					 for(int i=1; i<playerNumber; i++)
					 {
						 choices[i-1] = "" + i; 
					 }
					 
					 
					 input = (String) JOptionPane.showInputDialog(null, "Wybierz liczbe botów", "Bot",
							 JOptionPane.QUESTION_MESSAGE, null, choices,choices[0]);
					 out.println(input);
				 }
			 }
			 
			 //pytanie o dolaczenie do gry
			 else if (line.startsWith("JOINGAME")) 
			 {
				 JDialog.setDefaultLookAndFeelDecorated(true);
				 int response = JOptionPane.showConfirmDialog(null, "Czy chcesz dolaczyc do rozgywki?", "",
				 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    
				 if (response == JOptionPane.NO_OPTION || response == JOptionPane.CLOSED_OPTION)
				     out.println("NO");
				 else if (response == JOptionPane.YES_OPTION)
					 out.println("YES");
			 }
			 
			 
			 //gdy wszyscy gracze uczestnicza juz w rozgrywce nie można już dolaczyc
			 else if(line.startsWith("GAMEFULL"))
			 {
				 playerNo = Character.getNumericValue(line.charAt(8));
				 gamePanel = new GamePanel(playerNo, playerID);
				 add(gamePanel);
				 validate();
				 JOptionPane.showMessageDialog(null, "Nie można dolaczyc. Wszyscy gracze sa juz w grze.");
				 messageArea.setText("Obserwujesz.\n");
			 }	
			 
			 else if(line.startsWith("JOINED"))
			 {
				 playerID = Character.getNumericValue(line.charAt(6));
				 playerNo = Character.getNumericValue(line.charAt(7));
				 gamePanel = new GamePanel(playerNo, playerID);
				 panel.add(move, c);
				 c.gridx = 0;
				 c.gridy = 3;
				 panel.add(skip, c);
				 add(gamePanel);
				 validate();
				 messageArea.setText("Dolaczono\nPromień nr " + playerID + "\n");
			 }
			 
			 //gracz nie moze rozpoczac rozgrywki dopoki wszyscy gracze nie sa w grze
			 else if(line.startsWith("NOTFULL"))
			 {
				 JOptionPane.showMessageDialog(null, "Gra nie jest rozpoczeta.");
				 gamePanel.reset();
			 } 	 
			 
			 //gracz nie moze wykonac ruchu jesli nie nastapila jego tura
			 else if(line.startsWith("NOTURN"))
			 {
				 messageArea.setText("Promień nr " + playerID + "\n" + "Nie twoja kolej.\n");
				 gamePanel.reset();
			 }
			 
			 //dolaczenie do rozgrywki jako obserwujacy
			 else if(line.startsWith("OBSERVER"))
			 {
				 playerNo = Character.getNumericValue(line.charAt(8));
				 gamePanel = new GamePanel(playerNo, playerID);
				 add(gamePanel);
				 validate();
				 messageArea.setText("Obserwujesz\n");
			 }
			 
			 //tura gracza
			 else if(line.startsWith("MOVE"))
				 messageArea.setText("Promień nr " + playerID + "\n" + "Twój ruch.\n");
			 
			 else if(line.startsWith("VICTORY"))
			 {
				 
				 if(line.charAt(7) == '1')
					 messageArea.setText("Wygrales!");
				 else
					 messageArea.setText(line.charAt(7) + " miejsce.");
				 
				 JOptionPane.showMessageDialog(null, "Wygrales!");
			 }
			 
			 else if(line.startsWith("WRONG"))
				 JOptionPane.showMessageDialog(null, "Niedozwolony ruch.\n");
			 
			 else if(line.startsWith("GOOD"))
			 {
				 if(playerID > 0)
					 messageArea.setText("Promień nr " + playerID + "\n" + "Poprawny ruch.\n");

				 int xOF = Integer.parseInt(line.substring(4, 6));
 				 int yOF = Integer.parseInt(line.substring(6, 8));
     			 int xNF = Integer.parseInt(line.substring(8, 10));
     			 int yNF = Integer.parseInt(line.substring(10, 12));
				 
				 //w przypaku wiadomosci o poprawnym ruchu plansza jest odswiezana
				 gamePanel.reDraw(xOF, yOF, xNF, yNF);
			 }
			 
			 //koniec gry na skutek odlaczenia sie jednego z graczy
			 else if(line.startsWith("GAMEOVER"))
			 {
				 JOptionPane.showMessageDialog(null, "Koniec gry.");
				 System.exit(0);			 
			 }
		 }
	 }
	 
	 public static void main(String[] args) throws Exception
	 {
		 Player player = new Player();
		 
	     player.play();
	 }
}