package ChineseCheckers.ChineseCheckers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BotTest {
	
	Bot bot1, bot2, bot3;
	Game game;
	
	@Before
	public void start() throws Exception
	{
		game = new Game(4);
		bot1 = new Bot(3, game);
		bot2 = new Bot(5, game);
		bot3 = new Bot(6, game);
	}
	
	@Test
	public void isLockedTest()
	{
		assertFalse(bot1.isLocked(game));
		
		if(bot2.isLocked(game))
			fail();

	}
	
	@Test
	public void playerIDTest()
	{
		assertNotNull(bot3.getID());
		
		assertEquals(bot2.getID(), 5);

	}
	
	@Test
	public void victoryTest()
	{
		assertFalse(bot1.getVictory());
		
		assertEquals(bot2.getVictory(), bot3.getVictory());
	}
	
	@Test
	public void moveTest()
	{
		bot1.moveBot(game, 122);
		
		assertNotEquals(bot1.getMove(),"");
	}
	
	@After
	public void stop()
	{
		bot1 = null;
		bot2 = null;
		bot3 = null;
		game = null;
				
	}

}
