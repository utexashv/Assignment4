package assignment4;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

public class Assign4DriverTest
{
	Assignment4Interface wordLadderSolver = new WordLadderSolver();
	@Test
	public void testBlackbox() //test if the result of the system is validate solution
	{
		try{
			List<String> result = wordLadderSolver.computeLadder("babes", "child");
			boolean check = wordLadderSolver.validateResult("bebes", "child", result);
			System.out.println("Passes validate solution list test");
		}
		catch (NoSuchLadderException e)
		{
			System.out.println(e);
			fail("Fail the test\n");
		}
	}
	
}
