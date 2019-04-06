package ChineseCheckers.ChineseCheckers;


import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import ChineseCheckers.ChineseCheckers.Server.PlayerHandler;

public class Game
{
	private ArrayList<PlayerHandler> players = new ArrayList<PlayerHandler>();
	private ArrayList<Bot> bots = new ArrayList<Bot>();
	private ArrayList<PlayerHandler> observers = new ArrayList<PlayerHandler>();
	private Board board;
	private int[] ID;
	private int playerIterator = 0;
	private int playerNo;
	private int winner = 0;
	private Rules rules;
	private boolean isGame=false;
	private boolean row=false;
	
	public Game(int playerNo) throws Exception
	{
		this.playerNo = playerNo;
		this.ID = new int[playerNo];
		this.board = new Board(playerNo);
		rules = new Rules();

		switch (playerNo)
		{
			case 2:
				ID[0] = 1;
				ID[1] = 4;
				break;
				
			case 3:
				ID[0] = 2;
				ID[1] = 4;
				ID[2] = 6;
				break;
				
			case 4:
				ID[0] = 2;
				ID[1] = 3;
				ID[2] = 5;
				ID[3] = 6;
				break;
				
			case 6:
				ID[0] = 1;
				ID[1] = 2;
				ID[2] = 3;
				ID[3] = 4;
				ID[4] = 5;
				ID[5] = 6;
				break;
		}
	}
	
	public void addBot(Bot bot)
	{
		if(playerIterator<playerNo)
		{
			bots.add(bot);
			playerIterator++;
			
			if(playerIterator==playerNo)
			{
				isGame=true;
				playerIterator = ThreadLocalRandom.current().nextInt(0, playerNo);
			}
		}
		
		else
			playerIterator=0;
	}
	
	public ArrayList<Bot> getBots()
	{
		return bots;
	}
	
	public Board getBoard()
	{
		return this.board;
	}
	
	public int getID()
	{
		return ID[playerIterator];
	}
	
	public void iterate()
	{	
		this.row = false;
		playerIterator++;
		
		if(playerIterator>=playerNo)
			playerIterator=0;
	}
	
	public void addPlayer(PlayerHandler player)
	{
		if(playerIterator<playerNo)
		{
			
			players.add(player);
			playerIterator++;
			
			if(playerIterator==playerNo)
			{
				isGame=true;
				playerIterator = ThreadLocalRandom.current().nextInt(0, playerNo);
			}
		}
		
		else
			playerIterator=0;
	}
	
	public void addObserver(PlayerHandler observer)
	{
		observers.add(observer);
	}
	
	public int getIterator()
	{
		return playerIterator;
	}
	
	public boolean getIsGame()
	{
		return isGame;
	}
	
	public int getPlayerNo()
	{
		return playerNo;
	}
	
	public ArrayList<PlayerHandler> getPlayers()
	{
		return players;
	}
	
	public ArrayList<PlayerHandler> getObservers()
	{
		return observers;
	}
	
	public Field findField(int x, int y)
	{
		for(Field f : board.getFields())
		{
			if(f.getX() == x && f.getY() == y)
				return f;
		}
		
		return null;
	}
	
	public int findNoField(int x, int y)
	{
		for(int i=0; i<121; i++)
		{
			if(board.getFields()[i].getX() == x && board.getFields()[i].getY() == y)
				return i;
		}
		return 122;
	}
	
	public Checker findChecker(int x, int y)
	{
		for(Checker c : board.getCheckers())
		{
			if(c.getX() == x && c.getY() == y)
				return c;
		}
		
		return null;
	}
	
	public int getWinner()
	{
		return winner;
	}
	
	public void nextWinner()
	{
		winner++;
	}
	
	public Rules getRules()
	{
		return this.rules;
	}	
	
	public boolean isRow()
	{
		return row;
	}
	
	public void goRow()
	{
		row = true;
	}
	
	public void resetRow()
	{
		row = false;
	}
}
