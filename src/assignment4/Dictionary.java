/* Vo, Henry
 * hv3364
 * EE422C-Assignment 4
 */

package assignment4;

import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Dictionary 
{
	
	private ArrayList<String> myDictionary; 

	/**
	 * Adds all the dictionary words from file into an arraylist
	 */
	public Dictionary()
	{
		myDictionary = new ArrayList<String>(); 
		try 
		{
			FileReader file = new FileReader("A4-words.dat");
			BufferedReader bufferedFile = new BufferedReader(file);
			
			for (String x = bufferedFile.readLine(); x != null; x = bufferedFile.readLine()) 
			{
				if(x.charAt(0)!='*')
				{
					myDictionary.add(x.substring(0, 5)); 
				}
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println ("Error: A4-words.dat not found. Exiting.");
			e.printStackTrace();
			System.exit(-1);
		} 
        catch (IOException e) 
		{
			System.err.println ("Error: IO exception. Exiting.");
			e.printStackTrace();
			System.exit(-1);
		}	
	}
	
	/**
	 * Checks to see if the word is in the dictionary arraylist
	 * @param word word to be checked 
	 * @return true if word is in the arraylist
	 */
	public boolean findWord(String word) 
	{
		return myDictionary.contains(word);
	}
	
	/**
	 * Size of dictionary arraylist
	 * @return size of dictionary
	 */
	public int dictSize()
	{
		return myDictionary.size(); 
	}
	
	/**
	 * Gets word from dictionary
	 * @param index index of the word
	 * @return word at the dictionary index
	 */
	public String getWord(int index)
	{
		return myDictionary.get(index);
	}	
}
