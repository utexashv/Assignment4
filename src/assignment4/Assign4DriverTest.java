package assignment4;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

public class Assign4DriverTest
{

	@Test
	public void testMain()
	{
		Assignment4Interface wordLadderSolver = new WordLadderSolver();
		try{
			List<String> result = wordLadderSolver.computeLadder("babes", "child");
			boolean check = wordLadderSolver.validateResult("bebes", "child", result);
		}
		catch (NoSuchLadderException e) {
			
			fail("Fail the test");
		}
	}

}
