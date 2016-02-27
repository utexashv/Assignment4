/* Vo, Henry
 * hv3364
 * EE422C-Assignment 4
 */

package assignment4;

import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Assign4Driver
{
    public static void main(String[] args) throws IOException
    {
    	// Create a word ladder solver object
        Assignment4Interface wordLadderSolver = new WordLadderSolver();
		boolean flag = true; 
		
		String startingWord = new String(); 
		String endingWord = new String(); 
		
		FileReader file = new FileReader("A4-words.txt");
		BufferedReader bufferedFile = new BufferedReader(file);
		
		String line = bufferedFile.readLine();
		while(flag) 
		{
	        try 
	        {
	        	while(line != null)
	        	{
	        		int index = line.indexOf(" "); 
		        	startingWord = line.substring(0, index); 
		        	while(line.charAt(index) == ' ')
		        	{
		        		index++; 
		        	}
		        	int end = line.length();
		        	endingWord = line.substring(index, end);	
		        	line = bufferedFile.readLine();     	
		        	List<String> result = wordLadderSolver.computeLadder(startingWord, endingWord);
	        	}
		        flag = false; 
	        }
	        catch (FileNotFoundException e) 
	        {
				System.err.println ("Error: File not found. Exiting.");
				e.printStackTrace();
				System.exit(-1);
	        }
	        catch (NoSuchLadderException e) 
	        {
	        	System.out.println(e);
	        }
    	}
		bufferedFile.close();
		file.close();	
    } 
}
