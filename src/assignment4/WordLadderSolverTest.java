/*Group Number: 36
UT Name: Henry Vo; Hyo-Jung Kim
UT EID: hv3364; hk6336  */
package assignment4;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class WordLadderSolverTest
{
	Assignment4Interface wordLadderSolver = new WordLadderSolver();
	@Test
	public void testwhitebox1() //test if the result of the system has starting word length error
	{	
		try{
			List<String> result = wordLadderSolver.computeLadder("babe", "child");
			fail("Fail the test\n");
		}
		catch (NoSuchLadderException e)
		{
			System.out.println(e);
			System.out.println("Passes starting word length check test\n");
		}
	}
	@Test
	public void testwhitebox2() //test if the result of the system check ending words length
	{	
		try{
			List<String> result = wordLadderSolver.computeLadder("babes", "chil");
			fail("Fail the test\n");
		}
		catch (NoSuchLadderException e)
		{
			System.out.println(e);
			System.out.println("Passes ending word length check test\n");
		}
	}
	@Test
	public void testwhitebox3() //test if the result of the system check words are in the dictionary
	{	
		try{
			List<String> result = wordLadderSolver.computeLadder("bbbbb", "child");
			fail("Fail the test\n");
		}
		catch (NoSuchLadderException e)
		{
			System.out.println(e);
			System.out.println("Passes starting word dictionary check test\n");
		}
	}
	@Test
	public void testwhitebox4() //test if the result of the system  check words are in the dictionary
	{	
		try{
			List<String> result = wordLadderSolver.computeLadder("babes", "ccccc");
			fail("Fail the test\n");
		}
		catch (NoSuchLadderException e)
		{
			System.out.println(e);
			System.out.println("Passes ending word dictionary check test\n");
		}
	}
	@Test
	public void testwhitebox5() //test if the result of the system figures out such example that doesn't have solution
	{	
		try{
			List<String> result = wordLadderSolver.computeLadder("atlas", "zebra");
			fail("Fail the test\n");
		}
		catch (NoSuchLadderException e)
		{
			System.out.println(e);
			System.out.println("Passes no infinite loop or no way check test\n");
		}
	}
	@Test
	public void testwhitebox6() //test if the result of the system check same ending and starting words
	{	
		try{
			List<String> result = wordLadderSolver.computeLadder("atlas", "atlas");
			fail("Fail the test\n");
		}
		catch (NoSuchLadderException e)
		{
			System.out.println(e);
			System.out.println("Passes same endiing and starting words check test\n");
		}
	}
	@Test
	public void testwhitebox7() //test if the result of the system handles appropriate inputs
	{	
		try{
			List<String> result = wordLadderSolver.computeLadder("stone", "money");
			System.out.println("Passes all the test\n");
		}
		catch (NoSuchLadderException e)
		{
			System.out.println(e);
			fail("Fail the test\n");
			
		}
	}
}
