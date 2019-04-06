package ChineseCheckers.ChineseCheckers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements MouseListener
{
	
	Ellipse2D.Float temp;
	Graphics2D g2d;
	Graphics g;
	private Area [] areas = new Area [121];
	private int fieldNo;
	private int checked = 0;
	private int playerID;
	private String response;
	
	public void paint(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		fieldNo=0;
		//1
		 for (int i=0; i<1; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(190, 5, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			 
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }
		
		 //2
		 for (int i=0; i<2; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(175+i*30, 35, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }

		 //3
		 for (int i=0; i<3; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(160+i*30, 65, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			 
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }

		//4
		 for (int i=0; i<4; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(145+i*30, 95, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			 
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }

		 //5
		 for (int i=0; i<13; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(10+i*30, 125, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			 
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }

		 //6
		 for (int i=0; i<12; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(25+i*30, 155, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			 
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }

		 //7
		 for (int i=0; i<11; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(40+i*30, 185, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			 
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }

		 //8
		 for (int i=0; i<10; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(55+i*30, 215, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			 
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }

		 //9
		 for (int i=0; i<9; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(70+i*30, 245, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			 
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }

		 
		 //10
		 for (int i=0; i<10; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(55+i*30, 275, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			 
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }

		 
		 //11
		 for (int i=0; i<11; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(40+i*30, 305, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			 
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }

		 //12
		 for (int i=0; i<12; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(25+i*30, 335, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			 
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }

		 
		 //13
		 for (int i=0; i<13; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(10+i*30, 365, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			 
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }

		 
		 //14
		 for (int i=0; i<4; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(145+i*30, 395, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			 
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }

		 
		 //15
		 for (int i=0; i<3; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(160+i*30, 425, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			 
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }
		 
		 //16
		 for (int i=0; i<2; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(175+i*30, 455, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			 
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }

		 
		 //17
		 for (int i=0; i<1; i++)
		 {
			 areas[fieldNo].ellipse = new Ellipse2D.Double(190, 485, 30, 30);
			 g2d.setColor(changeColor(areas[fieldNo].status));
			 
			 if(areas[fieldNo].marked)
				 g2d.setColor(Color.RED);
			 
			 g2d.fill(areas[fieldNo].ellipse);
			 fieldNo++;
		 }
	}
	
	
	public GamePanel(int playerNo, int playerID)
	{ 
		int areaNo = 0;
		this.playerID = playerID;
		this.addMouseListener(this);
		
				//1
				for (int i=0; i<1; i++)
				{
					areas[areaNo] = new Area(12+i*2, 0);
					if(playerNo!=3 && playerNo!=4)
						areas[areaNo].status = 1;
					areaNo++;
				}
				//2
				for (int i=0; i<2; i++)
				{
					areas[areaNo] = new Area(11+i*2, 1);
					if(playerNo!=3 && playerNo!=4)
						areas[areaNo].status = 1;
					areaNo++;
				}
				//3
				for (int i=0; i<3; i++)
				{
					areas[areaNo] = new Area(10+i*2, 2);
					if(playerNo!=3 && playerNo!=4)
						areas[areaNo].status = 1;
					areaNo++;
				}
				//4
				for (int i=0; i<4; i++)
				{
					areas[areaNo] = new Area(9+i*2, 3);
					if(playerNo!=3 && playerNo!=4)
						areas[areaNo].status = 1;
					areaNo++;
				}
				//5
				for (int i=0; i<13; i++)
				{
					areas[areaNo] = new Area(i*2, 4);
					if (i<=3)
					{
						if(playerNo==3 || playerNo==4 || playerNo==6)
							areas[areaNo].status = 6;
					}
					else if (i>=9)
					{
						if(playerNo==3 || playerNo==4 || playerNo==6)
							areas[areaNo].status = 2;
					}

					areaNo++;
				}
				//6
				for (int i=0; i<12; i++)
				{
					areas[areaNo] = new Area(1+i*2, 5);
					if (i<=2)
					{
						if(playerNo==3 || playerNo==4 || playerNo==6)
							areas[areaNo].status = 6;
					}
					else if (i>=9)
					{
						if(playerNo==3 || playerNo==4 || playerNo==6)
							areas[areaNo].status = 2;
					}

					areaNo++;
				}
				//7
				for (int i=0; i<11; i++)
				{
					areas[areaNo] = new Area(2+i*2, 6);
					if (i+1<=2)
					{
						if(playerNo==3 || playerNo==4 || playerNo==6)
							areas[areaNo].status = 6;
					}
					else if (i+1>=10)
					{
						if(playerNo==3 || playerNo==4 || playerNo==6)
							areas[areaNo].status = 2;
					}

					areaNo++;
				}
				//8
				for (int i=0; i<10; i++)
				{
					areas[areaNo] = new Area(3+i*2, 7);
					if (i+1<=1)
					{
						if(playerNo==3 || playerNo==4 || playerNo==6)
							areas[areaNo].status = 6;
					}
					else if (i+1>=10)
					{
						if(playerNo==3 || playerNo==4 || playerNo==6)
							areas[areaNo].status = 2;
					}

					areaNo++;
				}
				//9
				for (int i=0; i<9; i++)
				{
					areas[areaNo] = new Area(4+i*2, 8);
					areaNo++;
				}
				//10
				for (int i=0; i<10; i++)
				{
					areas[areaNo] = new Area(3+i*2, 9);
					if (i+1<=1)
					{
						if(playerNo==4 || playerNo==6)
							areas[areaNo].status = 5;
					}
					else if (i+1>=10)
					{
						if(playerNo==4 || playerNo==6)
							areas[areaNo].status = 3;
					}
					
					areaNo++;
				}
				//11
				for (int i=0; i<11; i++)
				{
					areas[areaNo] = new Area(2+i*2, 10);
					if (i+1<=2)
					{
						if(playerNo==4 || playerNo==6)
							areas[areaNo].status = 5;
					}
					else if (i+1>=10)
					{
						if(playerNo==4 || playerNo==6)
							areas[areaNo].status = 3;
					}
					
					areaNo++;
				}
				//12
				for (int i=0; i<12; i++)
				{
					areas[areaNo] = new Area(1+i*2, 11);
					if (i<=2)
					{
						if(playerNo==4 || playerNo==6)
							areas[areaNo].status = 5;
					}
					else if (i>=9)
					{
						if(playerNo==4 || playerNo==6)
							areas[areaNo].status = 3;
					}
					
					areaNo++;
				}
				//13
				for (int i=0; i<13; i++)
				{
					areas[areaNo] = new Area(i*2, 12);
					if (i<=3)
					{
						if(playerNo==4 || playerNo==6)
							areas[areaNo].status = 5;
					}
					else if (i>=9)
					{
						if(playerNo==4 || playerNo==6)
							areas[areaNo].status = 3;
					}
					
					areaNo++;
				}
				//14
				for (int i=0; i<4; i++)
				{
					areas[areaNo] = new Area(9+i*2, 13);
					if(playerNo!=4)
						areas[areaNo].status = 4;
					areaNo++;
				}
				//15
				for (int i=0; i<3; i++)
				{
					areas[areaNo] = new Area(10+i*2, 14);
					if(playerNo!=4)
						areas[areaNo].status = 4;
					areaNo++;
				}
				//16
				for (int i=0; i<2; i++)
				{
					areas[areaNo] = new Area(11+i*2, 15);
					if(playerNo!=4)
						areas[areaNo].status = 4;
					areaNo++;
				}
				//17
				for (int i=0; i<1; i++)
				{
					areas[areaNo] = new Area(12+i*2, 16);
					if(playerNo!=4)
						areas[areaNo].status = 4;
					areaNo++;
				}
		
	}

	 
	 public Color changeColor(int status)
	 {
		 if(status==0)
			 return Color.GRAY;
		 else if(status==1)
			 return Color.GREEN;
		 else if(status==2)
			 return Color.BLACK;
		 else if(status==3)
			 return Color.BLUE;
		 else if(status==4)
			 return Color.ORANGE;
		 else if(status==5)
			 return Color.YELLOW;
		 else if(status==6)
			 return Color.PINK;
		 else
			 return Color.GRAY;
		
	 }
	 
	 public void reDraw(int xOF, int yOF, int xNF, int yNF)
	 {
		 findArea(xNF, yNF).status = findArea(xOF, yOF).status;
		 findArea(xOF, yOF).status = 0;
		 findArea(xOF, yOF).marked = false;
		 findArea(xNF, yNF).marked = false;
		 repaint();
	 }
	 
	 public void reset()
	 {
		 for(Area a : areas)
			 a.marked=false;
		 
		 checked=0;
		 repaint();
	 }
	 
	 private class Area
	 {
		 private int x;
		 private int y;
		 private int status = 0;
		 private Ellipse2D.Double ellipse;
		 private boolean marked = false;
		 
		 public Area(int x, int y)
		 {
			 this.x = x;
			 this.y = y;
		 }
	 }

	 public Area findArea(int x, int y)
	 {
		 for(Area a : areas)
		 {
			 if(a.x==x && a.y==y)
				 return a;
		 }
		 
		 return null;
	 }
	 
	 public void mouseClicked(MouseEvent e)
	{	
		for(Area a : areas)
		{
			if (a.ellipse.contains(e.getX(), e.getY()) && a.status == playerID && checked == 0)
			{
				a.marked = true;
				checked=1;
				
				if(a.x<10)
					response = "0" + a.x;
				else 
					response = "" + a.x;
				
				if(a.y<10)
					response += "0" + a.y;
				else 
					response += "" + a.y;

				repaint();
			}
			
			if (a.ellipse.contains(e.getX(), e.getY()) && a.status == 0 && checked == 1)
			{
				a.marked = true;
				checked = 2;

				if(a.x<10)
					response += "0" + a.x;
				else 
					response += "" + a.x;
				
				if(a.y<10)
					response += "0" + a.y;
				else 
					response += "" + a.y;

				repaint();
					
			}
		}
	}
	
	
	public int getChecked()
	{
		return checked;
	}
	
	public String getMove()
	{
		return response;
	}

	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
	}

	public void mousePressed(MouseEvent e)
	{
	}

	public void mouseReleased(MouseEvent e)
	{
	}
}
