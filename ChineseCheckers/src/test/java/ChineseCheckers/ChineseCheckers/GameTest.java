package ChineseCheckers.ChineseCheckers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ChineseCheckers.ChineseCheckers.Server.PlayerHandler;

public class GameTest {
	Game game1, game2;
	Bot bot1;
	
	@Before
	public void start() throws Exception
	{
		game1 = new Game(2);
		game2 = new Game(6);
		bot1 = new Bot(1, game2);
	}
	
	@Test
	public void gettersTest()
	{
		assertNotNull(game1.getBoard());
		assertNotNull(game1.getRules());
		assertEquals(game1.getPlayerNo(), 2);
		assertNotEquals(game2.getPlayerNo(), 3);
		assertNotNull(game1.getBots());
		assertNotNull(game1.getPlayers());
		assertNotNull(game1.isRow());
		assertNotNull(game1.getIsGame());
		assertNotNull(game1.getObservers());
		assertNotNull(game1.getWinner());
		assertEquals(game1.getWinner(), 0);
		assertNotEquals(game1.getWinner(), 1);
		assertEquals(game1.getID(), 1);
		assertEquals(game1.getID(), game2.getID());
		assertEquals(game1.getIterator(), 0);

	}
	
	@Test
	public void botTest()
	{
		game2.addBot(bot1);
		assertEquals(game2.getBots().get(0), bot1);
	}
	
	@Test
	public void observerTest()
	{
		PlayerHandler observer = new PlayerHandler(null);
		game2.addObserver(observer);
		assertEquals(game2.getObservers().get(0), observer);
		
	}
	
	@Test
	public void rowTest()
	{
		game1.goRow();
		assertTrue(game1.isRow());
		game1.resetRow();
		assertFalse(game1.isRow());
	}
	
	@Test
	public void winnerTest()
	{
		game1.nextWinner();
		assertEquals(game1.getWinner(), 1);
	}
	
	@Test
	public void findersTest()
	{
		assertNotNull(game2.findChecker(12, 0));
		assertNull(game2.findChecker(10, 0));
		
		assertEquals(game2.findNoField(0, 0), 122);
		assertEquals(game2.findNoField(12, 0), 0);
		
		assertNull(game2.findField(0, 0));
	}
	
	@Test
	public void playerTest()
	{
		PlayerHandler player = null;
		game2.addPlayer(player);
		assertEquals(game2.getPlayers().get(0), player);
		
	}
	
	@Test
	public void iteratorTest()
	{
		game2.iterate();
		assertEquals(game2.getIterator(), 1);
	}
	
	@After
	public void stop()
	{
		bot1 = null;
		game1 = null;
		game2 = null;
				
	}
	
	

}
