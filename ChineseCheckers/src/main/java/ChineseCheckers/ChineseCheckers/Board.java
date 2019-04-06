package ChineseCheckers.ChineseCheckers;


public class Board extends AbstractBoard
{
	private final static int fieldsNo = 121;
	
	public Board(int playerNo)
	{
		fields = new Field[fieldsNo];
		checkers = new Checker[10*playerNo];
		int fieldNo=0;
		int checkerNo=0;
		
		
		//1
		for (int i=0; i<1; i++)
		{
			fields[fieldNo] = new Field(12+i*2, 0, 1);
			if(playerNo!=3 && playerNo!=4)
			{
				fields[fieldNo].changeStatus(1);
				
				checkers[checkerNo] = new Checker(12+i*2, 0, 1);
				checkerNo++;
			}
			fieldNo++;
		}
		//2
		for (int i=0; i<2; i++)
		{
			fields[fieldNo] = new Field(11+i*2, 1, 1);
			if(playerNo!=3 && playerNo!=4)
			{
				fields[fieldNo].changeStatus(1);
				
				checkers[checkerNo] = new Checker(11+i*2, 1, 1);
				checkerNo++;
			}
			fieldNo++;
		}
		//3
		for (int i=0; i<3; i++)
		{
			fields[fieldNo] = new Field(10+i*2, 2, 1);
			if(playerNo!=3 && playerNo!=4)
			{
				fields[fieldNo].changeStatus(1);
				
				checkers[checkerNo] = new Checker(10+i*2, 2, 1);
				checkerNo++;
			}
			fieldNo++;
		}
		//4
		for (int i=0; i<4; i++)
		{
			fields[fieldNo] = new Field(9+i*2, 3, 1);
			if(playerNo!=3 && playerNo!=4)
			{
				fields[fieldNo].changeStatus(1);
				
				checkers[checkerNo] = new Checker(9+i*2, 3, 1);
				checkerNo++;
			}
			fieldNo++;
		}
		//5
		for (int i=0; i<13; i++)
		{
			if (i<=3)
			{
				fields[fieldNo] = new Field(i*2, 4, 6);
				
				if(playerNo==3 || playerNo==4 || playerNo==6)
				{
					fields[fieldNo].changeStatus(6);
					
					checkers[checkerNo] = new Checker(i*2, 4, 6);
					checkerNo++;
				}
			}
			else if (i>=9)
			{
				fields[fieldNo] = new Field(i*2, 4, 2);
				
				if(playerNo==3 || playerNo==4 || playerNo==6)
				{
					fields[fieldNo].changeStatus(2);
					
					checkers[checkerNo] = new Checker(i*2, 4, 2);
					checkerNo++;
				}
			}
			else
				fields[fieldNo] = new Field(i*2, 4, 0);
			
			fieldNo++;
		}
		//6
		for (int i=0; i<12; i++)
		{
			if (i<=2)
			{
				fields[fieldNo] = new Field(1+i*2, 5, 6);
				
				if(playerNo==3 || playerNo==4 || playerNo==6)
				{
					fields[fieldNo].changeStatus(6);
					
					checkers[checkerNo] = new Checker(1+i*2, 5, 6);
					checkerNo++;
				}
			}
			else if (i>=9)
			{
				fields[fieldNo] = new Field(1+i*2, 5, 2);
				
				if(playerNo==3 || playerNo==4 || playerNo==6)
				{
					fields[fieldNo].changeStatus(2);
					
					checkers[checkerNo] = new Checker(1+i*2, 5, 2);
					checkerNo++;
				}
			}
			else
				fields[fieldNo] = new Field(1+i*2, 5, 0);
			
			fieldNo++;
		}
		//7
		for (int i=0; i<11; i++)
		{
			if (i+1<=2)
			{
				fields[fieldNo] = new Field(2+i*2, 6, 6);
				
				if(playerNo==3 || playerNo==4 || playerNo==6)
				{
					fields[fieldNo].changeStatus(6);
					
					checkers[checkerNo] = new Checker(2+i*2, 6, 6);
					checkerNo++;
				}
			}
			else if (i+1>=10)
			{
				fields[fieldNo] = new Field(2+i*2, 6, 2);
				
				if(playerNo==3 || playerNo==4 || playerNo==6)
				{
					fields[fieldNo].changeStatus(2);
					
					checkers[checkerNo] = new Checker(2+i*2, 6, 2);
					checkerNo++;
				}
			}
			else
				fields[fieldNo] = new Field(2+i*2, 6, 0);
			
			fieldNo++;
		}
		//8
		for (int i=0; i<10; i++)
		{
			if (i+1<=1)
			{
				fields[fieldNo] = new Field(3+i*2, 7, 6);
				
				if(playerNo==3 || playerNo==4 || playerNo==6)
				{
					fields[fieldNo].changeStatus(6);
					
					checkers[checkerNo] = new Checker(3+i*2, 7, 6);
					checkerNo++;
				}
			}
			else if (i+1>=10)
			{
				fields[fieldNo] = new Field(3+i*2, 7, 2);
				
				if(playerNo==3 || playerNo==4 || playerNo==6)
				{
					fields[fieldNo].changeStatus(2);
					
					checkers[checkerNo] = new Checker(3+i*2, 7, 2);
					checkerNo++;
				}
			}
			else
				fields[fieldNo] = new Field(3+i*2, 7, 0);
			
			fieldNo++;
		}
		//9
		for (int i=0; i<9; i++)
		{
			fields[fieldNo] = new Field(4+i*2, 8, 0);
			fieldNo++;
		}
		//10
		for (int i=0; i<10; i++)
		{
			if (i+1<=1)
			{
				fields[fieldNo] = new Field(3+i*2, 9, 5);
				
				if(playerNo==4 || playerNo==6)
				{
					fields[fieldNo].changeStatus(5);
					
					checkers[checkerNo] = new Checker(3+i*2, 9, 5);
					checkerNo++;
				}
			}
			else if (i+1>=10)
			{
				fields[fieldNo] = new Field(3+i*2, 9, 3);
				
				if(playerNo==4 || playerNo==6)
				{
					fields[fieldNo].changeStatus(3);
					
					checkers[checkerNo] = new Checker(3+i*2, 9, 3);
					checkerNo++;
				}
			}
			else
				fields[fieldNo] = new Field(3+i*2, 9, 0);
			
			fieldNo++;
		}
		//11
		for (int i=0; i<11; i++)
		{
			if (i+1<=2)
			{
				fields[fieldNo] = new Field(2+i*2, 10, 5);
				
				if(playerNo==4 || playerNo==6)
				{
					fields[fieldNo].changeStatus(5);
					
					checkers[checkerNo] = new Checker(2+i*2, 10, 5);
					checkerNo++;
				}
			}
			else if (i+1>=10)
			{
				fields[fieldNo] = new Field(2+i*2, 10, 3);
				
				if(playerNo==4 || playerNo==6)
				{
					fields[fieldNo].changeStatus(3);
					
					checkers[checkerNo] = new Checker(2+i*2, 10, 3);
					checkerNo++;
				}
			}
			else
				fields[fieldNo] = new Field(2+i*2, 10, 0);
			
			fieldNo++;
		}
		//12
		for (int i=0; i<12; i++)
		{
			if (i<=2)
			{
				fields[fieldNo] = new Field(1+i*2, 11, 5);
				
				if(playerNo==4 || playerNo==6)
				{
					fields[fieldNo].changeStatus(5);
					
					checkers[checkerNo] = new Checker(1+i*2, 11, 5);
					checkerNo++;
				}
			}
			else if (i>=9)
			{
				fields[fieldNo] = new Field(1+i*2, 11, 3);
				
				if(playerNo==4 || playerNo==6)
				{
					fields[fieldNo].changeStatus(3);
					
					checkers[checkerNo] = new Checker(1+i*2, 11, 3);
					checkerNo++;
				}
			}
			else
				fields[fieldNo] = new Field(1+i*2, 11, 0);
			
			fieldNo++;
		}
		//13
		for (int i=0; i<13; i++)
		{
			if (i<=3)
			{
				fields[fieldNo] = new Field(i*2, 12, 5);
				
				if(playerNo==4 || playerNo==6)
				{
					fields[fieldNo].changeStatus(5);
					
					checkers[checkerNo] = new Checker(i*2, 12, 5);
					checkerNo++;
				}
			}
			else if (i>=9)
			{
				fields[fieldNo] = new Field(i*2, 12, 3);
				
				if(playerNo==4 || playerNo==6)
				{
					fields[fieldNo].changeStatus(3);
					
					checkers[checkerNo] = new Checker(i*2, 12, 3);
					checkerNo++;
				}
			}
			else
				fields[fieldNo] = new Field(i*2, 12, 0);
			
			fieldNo++;
		}
		//14
		for (int i=0; i<4; i++)
		{
			fields[fieldNo] = new Field(9+i*2, 13, 4);
			if(playerNo!=4)
			{
				fields[fieldNo].changeStatus(4);
				
				checkers[checkerNo] = new Checker(9+i*2, 13, 4);
				checkerNo++;
			}
			fieldNo++;
		}
		//15
		for (int i=0; i<3; i++)
		{
			fields[fieldNo] = new Field(10+i*2, 14, 4);
			if(playerNo!=4)
			{
				fields[fieldNo].changeStatus(4);
				
				checkers[checkerNo] = new Checker(10+i*2, 14, 4);
				checkerNo++;
			}
			fieldNo++;
		}
		//16
		for (int i=0; i<2; i++)
		{
			fields[fieldNo] = new Field(11+i*2, 15, 4);
			if(playerNo!=4)
			{
				fields[fieldNo].changeStatus(4);
				
				checkers[checkerNo] = new Checker(11+i*2, 15, 4);
				checkerNo++;
			}
			fieldNo++;
		}
		//17
		for (int i=0; i<1; i++)
		{
			fields[fieldNo] = new Field(12+i*2, 16, 4);
			if(playerNo!=4)
			{
				fields[fieldNo].changeStatus(4);
				
				checkers[checkerNo] = new Checker(12+i*2, 16, 4);
				checkerNo++;
			}
			fieldNo++;
		}
		
	}
	
	public Field[] getFields()
	{
		return fields;
	}
	
	public Checker[] getCheckers()
	{
		return checkers;
	}
 	
	public void freeFieldStatus(int x, int y)
	{
		for (int i=0; i<121; i++)
			if(fields[i].getX()==x && fields[i].getY()==y)
				fields[i].freeStatus();
	}
	
	public void changeFieldStatus(int x, int y, int player)
	{
		for (int i=0; i<121; i++)
			if(fields[i].getX()==x && fields[i].getY()==y)
				fields[i].changeStatus(player);
	}
	
	public int getNoChecker(int x, int y)
	{
		int i=0;
		for(Checker c : checkers)
		{
			if(c.getX() == x && c.getY() == y)
				return i;
			i++;
		}
		return 122;
	}
	
	public Field searchField(int x, int y)
	{
		for (int i=0; i<121; i++)
			if(fields[i].getX()==x && fields[i].getY()==y)
				return fields[i];
		return null;
	}
	
	public void moveChecker(Checker temp, Field field)
	{
		for (Checker c: checkers)
		{
			if (c.getX()==temp.getX() && c.getY()==temp.getY())
			{
				c.setX(field.getX());
				c.setY(field.getY());
				break;
			}
		}
	}
	
	public boolean anyJumper(Checker temp)
	{
		for (Checker c: checkers)
			if (c.getStartCorner()==temp.getStartCorner() && c.isJumper())
				return true;
		return false;
	}
	
	public void resetJumpers()
	{
		for (Checker c: checkers)
			c.noJumper();
	}
}
