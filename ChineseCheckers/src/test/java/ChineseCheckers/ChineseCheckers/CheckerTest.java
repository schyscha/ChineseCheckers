package ChineseCheckers.ChineseCheckers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckerTest {

	Checker checker1, checker2;
	Game game;
	
	@Before
	public void start() throws Exception
	{
		checker1 = new Checker(12, 12, 0);
		checker2 = new Checker(13, 13, 1);
		game = new Game(6);
	}
	
	@Test
	public void coordinateTest()
	{
		assertEquals(checker1.getX(), 12);
		assertEquals(checker1.getY(), 12);
		assertEquals(checker2.getX(), 13);
		assertEquals(checker2.getY(), 13);
		
		assertNotEquals(checker1.getX(), checker2.getX());
		assertNotEquals(checker1.getY(), checker2.getY());
		
		checker1.setX(10);
		checker1.setY(10);
		
		assertNotEquals(checker1.getX(), 12);
		assertNotEquals(checker1.getY(), 12);
		assertEquals(checker1.getX(), 10);
		assertEquals(checker1.getY(), 10);
	}
	
	@Test
	public void cornerTest()
	{
		assertEquals(checker1.getStartCorner(), 0);
		
		checker1.setStartCorner(2);
		
		assertNotEquals(checker1.getStartCorner(), 0);
		assertEquals(checker1.getStartCorner(), 2);
		assertNotEquals(checker1.getStartCorner(), checker2.getStartCorner());
	}
	
	@Test
	public void oppositeTest()
	{
		assertFalse(checker2.isOpposite());
		
		checker2.setOpposite();
		
		assertTrue(checker2.isOpposite());
		assertNotEquals(checker1.isOpposite(), checker2.isOpposite());
	}
	
	@Test
	public void currentFieldTest()
	{
		assertNotNull(checker1.currentField(game));
		
		assertEquals(checker1.currentField(game).getX(), checker1.getX());
		assertEquals(checker1.currentField(game).getY(), checker1.getY());
	}
	
	@Test
	public void jumperTest()
	{
		assertFalse(checker1.isJumper());
		
		checker1.yesJumper();
		assertTrue(checker1.isJumper());
		assertNotEquals(checker1.isJumper(), checker2.isJumper());
		
		checker1.noJumper();
		assertFalse(checker1.isJumper());
	}
	
	@After
	public void stop()
	{
		checker1 = null;
		checker2 = null;
		game = null;
				
	}

}
