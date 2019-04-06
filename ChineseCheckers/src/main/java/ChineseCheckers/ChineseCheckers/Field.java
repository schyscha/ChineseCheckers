package ChineseCheckers.ChineseCheckers;

public class Field
{
	private int x;
	private int y;
	private int status=0;
	private int corner;
	
	public Field(int x, int y, int corner)
	{
		this.x = x;
		this.y = y;
		this.corner = corner;
	}
	
	public void freeStatus()
	{
		this.status = 0;
	}
	
	public void changeStatus(int checker)
	{
		this.status = checker;
	}
	
	public int getStatus()
	{
		return this.status;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int getCorner()
	{
		return this.corner;
	}
	
	public double distance(Field f2)
	{
		double x = Math.pow(this.getX()-f2.getX(), 2);
		double y = Math.pow(this.getY()-f2.getY(), 2);
		return Math.sqrt(x+y);
	}

}
