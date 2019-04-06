package ChineseCheckers.ChineseCheckers;

import java.util.Random;

import javax.swing.JOptionPane;

import ChineseCheckers.ChineseCheckers.Server.PlayerHandler;

public class Bot
{
	
	Random generator = new Random();
	private int playerID;
	private Field goal;
	private int corner;
	private String move;
	boolean victory=false;
	
	public boolean getVictory()
	{
		return victory;
	}
	
	public int getID()
	{
		return playerID;
	}
	
	
	public Bot(int playerID, Game game)
	{
		this.playerID=playerID;
		
		switch (game.getPlayerNo())
		{
			case 2:
				if(playerID==1)
					this.goal = new Field(12, 16, 4);
				else
					this.goal = new Field(12, 0, 1);
				break;
				
			case 3:
				if(playerID==2)
					this.goal = new Field(0, 12, 5);
				else if(playerID==4)
					this.goal = new Field(12, 0, 1);
				else
					this.goal = new Field(24, 12, 3);
				break;
				
			case 4:
				if(playerID==2)
					this.goal = new Field(0, 12, 5);
				else if(playerID==3)
					this.goal = new Field(0, 4, 6);
				else if(playerID==5)
					this.goal = new Field(24, 4, 2);
				else
					this.goal = new Field(24, 12, 3);
				break;
				
			case 6:
				if(playerID==1)
					this.goal = new Field(12, 16, 4);
				else if(playerID==2)
					this.goal = new Field(0, 12, 5);
				else if(playerID==3)
					this.goal = new Field(0, 4, 6);
				else if(playerID==4)
					this.goal = new Field(12, 0, 1);
				else if(playerID==5)
					this.goal = new Field(24, 4, 2);
				else
					this.goal = new Field(24, 12, 3);
				break;
		}
		
		this.corner = (this.goal.getCorner()+3)%6;
			
	}

		
	public void moveBot(Game game, int fail)
	{
		move="";
		Checker [] checkers = game.getBoard().getCheckers();
		Field [] fields = game.getBoard().getFields();
		int checkerNo = generator.nextInt(game.getPlayerNo()*10);
		
		while(checkers[checkerNo].getStartCorner()!=playerID || checkerNo==fail || checkers[checkerNo].currentField(game)==goal)
				checkerNo = generator.nextInt(game.getPlayerNo()*10);
				

		if(checkers[checkerNo].getX()<10)
			move = "0" + checkers[checkerNo].getX();
		else 
			move = "" + checkers[checkerNo].getX();
		
		if(checkers[checkerNo].getY()<10)
			move += "0" + checkers[checkerNo].getY();
		else 
			move += "" + checkers[checkerNo].getY();

		
		Checker tempChecker = checkers[checkerNo];
		double distance = goal.distance(tempChecker.currentField(game));
		Field newField = null;
		for (Field f : fields)
		{
			if(game.getRules().legal(tempChecker, f,  game.getBoard()))
			{
				if (goal.distance(f)<distance)
				{
					distance = goal.distance(f);
					newField = f;
				}
			}
		}
		
		if (newField==null)
			moveBot(game, checkerNo);
		
		else
		{
			if(newField.getX()<10)
				move += "0" + newField.getX();
			else 
				move += "" + newField.getX();
			
			if(newField.getY()<10)
				move += "0" + newField.getY();
			else 
				move += "" + newField.getY();
			
			
			game.getRules().makeMove(checkers[checkerNo], newField, game.getBoard());
			
			victory = true;
			for(Checker c : game.getBoard().getCheckers())
			{
				if(c.getStartCorner()==playerID && !(c.isOpposite()))
						victory=false;
			}
		}

	}
	
	public String getMove()
	{
		return move;
	}
	
	public boolean isLocked(Game game)
	{
		double distance;
		for (Checker c: game.getBoard().getCheckers())
		{
			if (c.getStartCorner()==playerID)
			{
				distance = goal.distance(c.currentField(game));
				for (Field f: game.getBoard().getFields())
				{
					if(game.getRules().legal(c, f,  game.getBoard()))
						if (goal.distance(f)<distance)
							return false;
				}
			}
		}
		
		return true;
	}
}
