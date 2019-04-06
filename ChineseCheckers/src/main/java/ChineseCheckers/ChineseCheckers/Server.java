package ChineseCheckers.ChineseCheckers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;

public class Server
{
	private static final int PORT = 8000;
	private static ArrayList<Game> games = new ArrayList<Game>();
	private static Game currentGame;
	
	public static void main(String[] args) throws Exception
	{
		System.out.println("The game server is running.");
		ServerSocket listener = new ServerSocket(PORT);
	
		try
		{
        	while(true)
            {
        		new PlayerHandler(listener.accept()).start();
            }
        }
		finally
		{
			listener.close();
		}
	}
		
	public void addNewGame(Game game)
	{
		this.games.add(game);
	}
	
	public static class PlayerHandler extends Thread
	{
		//domyslne ID gracza to -1 by rozróżnic że nie należy od do rozgrywki
		private int playerID = -1;
		private static int PORT = 8901;
		private Socket socket;
		private BufferedReader in;
	    private PrintWriter out;
	    private String response;
	    private int jumper = -3;
	    private int result = -2;
	    private boolean victory = false;
	    private boolean turn = false;
	    private Rules rules;
	    private Bot [] bots;
	    
	    public PlayerHandler(Socket socket)
	    {
            this.socket = socket;
	    }
		
		public void run()
		{
			try
			{				
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            out = new PrintWriter(socket.getOutputStream(), true);
	            
	            while(true)
	            {
	            	//gdy gra nie jest zainicjalizowana tworzymy nowa
	            	if(currentGame==null)
	            	{
	            		synchronized(games)
		            	{
		            		out.println("CREATEGAME");
		            		response = in.readLine();
		            		
		            		
		            		if(response.equals("2"))
		            			games.add(new Game(2));
	                    	else if(response.equals("3"))
	                    		games.add(new Game(3));
	                    	else if(response.equals("4"))
	                    		games.add(new Game(4));
	                    	else if(response.equals("6"))
	                    		games.add(new Game(6));
	                    	
	                    	else
	                    		break;
	                    	
	                    	currentGame = games.get(0);
	                    	playerID=currentGame.getID();
	                    	out.println("JOINED" + playerID + currentGame.getPlayerNo());
	                    	currentGame.addPlayer(this);

	                    	
	                    	out.println("BOT");
	                    	response = in.readLine();
	                    	
	                    	if(!(response.startsWith("NO")))
	                    	{
	                    		int number = Integer.parseInt(response);
	                    		
	                    		for(int i=0; i<number; i++)
	                    			currentGame.addBot(new Bot(currentGame.getID(), currentGame));
	                    	}
	                    	
	                    	else if(response.startsWith("NO"))
	                    	{
	                    		break;
	                    	}
	          
	                    	
	                    	else
	                    		break;
	                    	
	                    	break;
		            	}
	            	}
		            
	            	else
		            {
	            		//dodawanie gracza
	            		out.println("JOINGAME");
	            		response = in.readLine();
                    
	            			if(response.equals("YES"))
	            			{
	            				if(!currentGame.getIsGame())
	            				{
	            					playerID=currentGame.getID();
	            					out.println("JOINED" + playerID + currentGame.getPlayerNo());
	            					currentGame.addPlayer(this);
	            				}
	            				
	            				else if(currentGame.getIsGame())
	            				{
		                    		out.println("GAMEFULL" + currentGame.getPlayerNo());
		                    		currentGame.addObserver(this);
	            				}
	            				
	            				break;
	            			}
	            			
	            			else if(response.equals("NO"))
	            			{
	            				out.println("OBSERVER" + currentGame.getPlayerNo());
            					currentGame.addObserver(this);
            					break;
	            			}
	            			
	            			else
	            				break;
	            	}
	            }
	            
	            rules = new Rules();
	            
	            if(currentGame!=null)
	            {
	            	while (true)
		            {
		            	//wysylanie wiadomosci do gracza do ktorego należy aktualna tura
		            	if(currentGame.getIsGame())
			            {
		            		for(Bot b : currentGame.getBots())
		            		{
		            			if(b.getID() == currentGame.getID() && !(b.getVictory()))
		            			{
		            				if(!b.isLocked(currentGame))
		            				{
		            					b.moveBot(currentGame, 122);
			            				
			            				for(PlayerHandler p : currentGame.getPlayers())
			            					p.out.println("GOOD" + b.getMove());
				            			
			            				for(PlayerHandler o : currentGame.getObservers())
			            					o.out.println("GOOD" + b.getMove());
			            				
			            				if(b.getVictory())
			            					currentGame.nextWinner();
		            				}
		            				
		            				currentGame.iterate();
		            				currentGame.getBoard().resetJumpers();
		            				try {
		            				    Thread.sleep(1000);
		            				} catch(InterruptedException ex) {
		            				    Thread.currentThread().interrupt();
		            				}
		            			}
		            		}
		            		
			            	for(PlayerHandler p : currentGame.getPlayers())
			            	{
			            		if(p.playerID == currentGame.getID() && p.victory == true)
			            			currentGame.iterate();
			            		
			            		if(p.playerID == currentGame.getID() && p.victory == false)
		            			{
			            			p.turn = true;
			            			p.out.println("MOVE");
		            			}
			            		
			            		else
			            			p.turn=false;
			            	}
			            }
		            	
		            	response = in.readLine();	
		
		            	if(turn)
		            	{
		            		
		            		if(!response.startsWith("SKIP"))	
		            		{
		            			//znajdywanie odpowiedniej pary pol, zeby sprawdzic poprawnosc proponowanego ruchu
	
		            			int xOF = Integer.parseInt(response.substring(0, 2));
		            			int yOF = Integer.parseInt(response.substring(2, 4));
		            			int xNF = Integer.parseInt(response.substring(4, 6));
		            			int yNF = Integer.parseInt(response.substring(6, 8));
		            			
		            		
		            			result = rules.makeMove(currentGame.findChecker(xOF, yOF), currentGame.findField(xNF, yNF), currentGame.getBoard());
		            			
		            			//gdy ruch nie jest poprawny
	            				if(result == -2)
		            			{
		            				out.println("WRONG");
		            			}
		            			
		            			//gdy ruch jest poprawny - zwykly ruch
	            				else if(result == -1 && !currentGame.isRow())
		            			{
	            					
	        						for(PlayerHandler p : currentGame.getPlayers())
	        							p.out.println("GOOD" + response);
		            			
	        						for(PlayerHandler o : currentGame.getObservers())
	        							o.out.println("GOOD" + response);
	        						
	        						if(rules.isFinished())
	        						{
	            						victory = true;
	            						currentGame.nextWinner();
	            						out.println("VICTORY"+currentGame.getWinner());
	            						
	            						if(currentGame.getWinner() == currentGame.getPlayerNo()-1)
	            						{
	            							if(currentGame!=null)
	            							{
	            								for(PlayerHandler ph : currentGame.getPlayers())
	            									ph.out.println("GAMEOVER");
	            							
	            								for(PlayerHandler o : currentGame.getObservers())
	            									o.out.println("GAMEOVER");
	            							}
	            							
	            							break;
	            						}
	        						}
	
	        						// iteracja tury
	            						currentGame.iterate();
	            						turn = false;
		            						
		            			}
		            	
	            				
		            			//gdy ruch jest poprawny - poczatek skoku
	            				else if(result > -1 && result < 122 && !currentGame.isRow())
		            			{
		            				
	            					
	        						for(PlayerHandler p : currentGame.getPlayers())
	        							p.out.println("GOOD" + response);
			            			
		            				for(PlayerHandler o : currentGame.getObservers())
		            					o.out.println("GOOD" + response);
			            			
		            				if(rules.isFinished())
	        						{
		            					victory = true;
		            					currentGame.nextWinner();
		            					out.println("VICTORY"+currentGame.getWinner());
		            					
		            					if(currentGame.getWinner() == currentGame.getPlayerNo()-1)
	            						{
	            							if(currentGame!=null)
	            							{
	            								for(PlayerHandler ph : currentGame.getPlayers())
	            									ph.out.println("GAMEOVER");
	            							
	            								for(PlayerHandler o : currentGame.getObservers())
	            									o.out.println("GAMEOVER");
	            							}
	            							
	            							break;
	            						}
	        						}
		            				
		            				turn = false;
		            				
		            				currentGame.goRow();
		            				
		            				jumper = result;
	
		            				
		            			}
		            			
		            			
		            			//gdy ruch nie jest poprawny - kontynuacja skoku
	            				else if(result !=jumper && currentGame.isRow())
	            				{
		            				out.println("WRONG");
	
	    						}
	            						
		            				
		            		
		            			//gdy ruch jest poprawny - kontynuacja skoku
	            				else if(result == jumper && currentGame.isRow())
		            			{
	
			            			
		            				for(PlayerHandler p : currentGame.getPlayers())
		            					p.out.println("GOOD" + response);
			            			
		            				for(PlayerHandler o : currentGame.getObservers())
		            					o.out.println("GOOD" + response);
			            				
		            				
		            				if(rules.isFinished())
	        						{
			            				victory = true;
			            				currentGame.nextWinner();
			            				out.println("VICTORY"+currentGame.getWinner());

			            				if(currentGame.getWinner() == currentGame.getPlayerNo()-1)
	            						{
	            							if(currentGame!=null)
	            							{
	            								for(PlayerHandler ph : currentGame.getPlayers())
	            									ph.out.println("GAMEOVER");
	            							
	            								for(PlayerHandler o : currentGame.getObservers())
	            									o.out.println("GAMEOVER");
	            							}
	            							
	            							break;
	            						}
	        						
	        						}
		            				
		            				turn = false;
	            					
		            				
			            		}
	            				
	            				
		            		}
		            		
		            		//pomijanie ruchu
		            		else
	            			{
		            			currentGame.getBoard().resetJumpers();
		            			currentGame.iterate();
		            			jumper = -3;
		            			
	            			}
	            					
		            	}
		            	
		            	else if(!currentGame.getIsGame())
		            		out.println("NOTFULL");
		            	else
		            		out.println("NOTURN");
		            	
	            		}
	            ///////////
	            	currentGame=null;
	            }
			}
			
	        catch (IOException e)
	        {
				System.out.println(e);
	        }
			
			catch (Exception e)
			{
				e.printStackTrace();
			}
	                
			finally
			{
				if (out != null && playerID != -1)
				{
					if(currentGame!=null)
					{
						for(PlayerHandler ph : currentGame.getPlayers())
							ph.out.println("GAMEOVER");
					
						for(PlayerHandler o : currentGame.getObservers())
							o.out.println("GAMEOVER");
					}
					
					games.remove(currentGame);
					currentGame=null;
				}
				
				try
				{
					socket.close();
				}
	             
				catch (IOException e)
				{
				}
	    
			}
		}
	}
}
