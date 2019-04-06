package ChineseCheckers.ChineseCheckers;

public class Checker
{

	private int x;
	private int y;
	private int startCorner;
 	private boolean isOpposite = false;
 	private boolean jumper = false;

 	public Checker(int x, int y, int startCorner)
 	{
 		this.x = x;
 		this.setY(y);
 		this.startCorner = startCorner;
 	}
 	
 	public void setX(int x)
 	{
 		this.x = x;
 	}

 	public void setY(int y)
 	{
 		this.y = y;
 	}
 	
 	public void setStartCorner(int startCorner)
 	{
 		this.startCorner = startCorner;
 	}
 	
 	public void setOpposite()
 	{
 		isOpposite = true;
 	}
 	
 	public int getX()
 	{
		return x;
	}
 	
	public int getY()
	{
		return y;
	}
	
	public int getStartCorner()
	{
		return startCorner;
	}
	
	public boolean isOpposite()
	{
		return isOpposite;
	}
	
	public Field currentField(Game game)
	{
		return game.findField(getX(), getY());
	}
	
	public void yesJumper()
	{
		jumper = true;
	}
	
	public void noJumper()
	{
		jumper = false;
	}
	
	public boolean isJumper()
	{
		return jumper;
	}
 	

}
