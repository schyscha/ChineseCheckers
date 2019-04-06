package ChineseCheckers.ChineseCheckers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardTest
{

	Board board2, board3, board4, board6;
	
	@Before
	public void start()
	{
		board2 = new Board(2);
		board3 = new Board(3);
		board4 = new Board(4); 
		board6 = new Board(6);
	}
	
	@Test
	public void test1()
	{
		for(int i=0; i<board6.getFields().length; i++)
		{
			assertNotNull(board6.getFields()[i]);
		}
		
		for(int i=0; i<board6.getCheckers().length; i++)
		{
			assertNotNull(board6.getCheckers()[i]);
		}
	}
	
	@Test
	public void test2()
	{
		for(int i=0; i<board6.getFields().length-1; i++)
		{
			Field field1 = board6.getFields()[i];
			Field field2 = board6.getFields()[i+1];
			
			if(field1.getY()>field2.getY())
				fail();
		}
	}
	
	@Test
	public void test3()
	{
		Field [] fields = new Field[10];
		
		for(int i=0; i<10; i++)
		{
			fields[i] = board6.getFields()[i];
			
			assertEquals(fields[i].getCorner(), 1);
			assertEquals(fields[i].getStatus(), 1);
		}
		
		int [] numbers2 = {19, 20, 21, 22, 32, 33, 34, 44, 45, 55};
		int [] numbers3 = {74, 84, 85, 95, 96, 97, 107, 108, 109, 110};
		int [] numbers5 = {65, 75, 76, 86, 87, 88, 98, 99, 100, 101};
		int [] numbers6 = {10, 11, 12, 13, 23, 24, 25, 35, 36, 46};

		for(int i=0; i<10; i++)
		{
			fields[i] = board6.getFields()[numbers2[i]];
			assertEquals(fields[i].getCorner(), 2);
			assertEquals(fields[i].getStatus(), 2);
		}
		
		for(int i=0; i<10; i++)
		{
			fields[i] = board6.getFields()[numbers3[i]];
			assertEquals(fields[i].getCorner(), 3);
			assertEquals(fields[i].getStatus(), 3);
		}
		
		for(int i=0; i<10; i++)
		{
			fields[i] = board6.getFields()[numbers5[i]];
			assertEquals(fields[i].getCorner(), 5);
			assertEquals(fields[i].getStatus(), 5);
		}
		
		for(int i=0; i<10; i++)
		{
			fields[i] = board6.getFields()[numbers6[i]];
			assertEquals(fields[i].getCorner(), 6);
			assertEquals(fields[i].getStatus(), 6);
		}
		
		
		for(int i=0; i<10; i++)
		{
			fields[i] = board6.getFields()[i+111];
			
			assertEquals(fields[i].getCorner(), 4);
			assertEquals(fields[i].getStatus(), 4);
		}
	}

	@Test
	public void test4()
	{
		Field [] fields = new Field[121];
		
		for(int i=0; i<board6.getFields().length; i++)
		{
			fields[i] = board6.getFields()[i];

			if(fields[i].getCorner()!=1 && fields[i].getCorner()!=2 && fields[i].getCorner()!=3 &&
					fields[i].getCorner()!=4 && fields[i].getCorner()!=5 && fields[i].getCorner()!=6)
				{
					assertEquals(fields[i].getCorner(), 0);
				}
		}
	}
	
	@Test
	public void test5()
	{
		assertEquals(board6.searchField(12, 0).getStatus(), 1);
		
		assertEquals(board3.searchField(11, 13).getStatus(), 4);
		
		assertEquals(board6.searchField(13, 7).getStatus(), 0);
		
		assertNull(board6.searchField(0, 5));
	}
	

	@Test
	public void test6()
	{
		board6.resetJumpers();
		
		for(Checker c : board6.getCheckers())
		{
			assertFalse(c.isJumper());
		}
		
		assertFalse(board6.anyJumper(board6.getCheckers()[0]));
		
		board6.getCheckers()[9].yesJumper();
		
		assertTrue(board6.anyJumper(board6.getCheckers()[0]));
		
		board6.moveChecker(board6.getCheckers()[9], board6.getFields()[18]);
		
		assertEquals(board6.getCheckers()[9].getX(), 16);
		assertEquals(board6.getCheckers()[9].getY(), 4);
	}

	

	@Test
	public void test7()
	{
		board6.changeFieldStatus(14, 4, 1);
		assertEquals(board6.getFields()[17].getStatus(), 1);
		
		board6.freeFieldStatus(14, 4);
		assertEquals(board6.getFields()[17].getStatus(), 0);
		
		assertEquals(board6.getNoChecker(12, 16), 59);
		
		assertEquals(board6.getNoChecker(13, 16), 122);
	}
	
	@After
	public void stop()
	{
		board2 = null;
		board3 = null;
		board4 = null; 
		board6 = null;
	}
}
