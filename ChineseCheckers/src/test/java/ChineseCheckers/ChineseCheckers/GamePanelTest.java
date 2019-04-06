package ChineseCheckers.ChineseCheckers;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GamePanelTest {
	
	GamePanel gp1, gp2;
	
	@Before
	public void start()
	{
		gp1 = new GamePanel(6, 1);
		gp2 = new GamePanel(6, 2);
	}
	
	@Test
	public void checkedTest()
	{
		assertEquals(gp1.getChecked(), 0);
		assertNotEquals(gp2.getChecked(), 2);
		
		gp2.reset();
		assertEquals(gp2.getChecked(), 0);
	}
	
	
	@Test
	public void areaTest()
	{	
		assertNotNull(gp1.findArea(12, 0));
		assertNull(gp1.findArea(0, 0));
		
	}
	
	@Test
	public void changeColorTest()
	{
		assertNotNull(gp1.changeColor(0));
		assertEquals(gp1.changeColor(1), Color.GREEN);
		assertNotEquals(gp1.changeColor(2), Color.GRAY);
		assertNotEquals(gp1.changeColor(3), Color.GRAY);
		assertNotEquals(gp1.changeColor(4), Color.GRAY);
		assertNotEquals(gp1.changeColor(5), Color.GRAY);
		assertNotEquals(gp1.changeColor(6), Color.GRAY);
		assertEquals(gp1.changeColor(7), Color.GRAY);
	}
	
	@Test
	public void responseTest()
	{
		assertNull(gp2.getMove());
	}
	
	
	@Test
	public void reDrawTest()
	{
		gp1.reDraw(10, 10, 11, 11);
	}
	
	@After
	public void stop()
	{
		gp1 = null;
		gp2 = null;
				
	}

}
