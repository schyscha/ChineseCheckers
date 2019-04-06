package ChineseCheckers.ChineseCheckers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RulesTest {
	
	Rules rules;
	
	@Before
	public void start()
	{
		rules = new Rules();
	}
	
	@Test
	public void isFinishedTest()
	{
		assertNotNull(rules.isFinished());
		assertFalse(rules.isFinished());
	}
	
	@After
	public void stop()
	{
		rules = null;
				
	}

}
