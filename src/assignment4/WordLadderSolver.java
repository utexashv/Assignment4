/* Vo, Henry; Kim, Hyo-Jung
 * hv3364; hk6336
 * EE422C-Assignment 4
 */

package assignment4;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// do not change class name or interface it implements
public class WordLadderSolver implements Assignment4Interface
{
    // delcare class members here.
	private StopWatch myWatch;
	private Dictionary myDictionary;
	private ArrayList<String> tempList; 
	private ArrayList<String> SolutionList;  
	public static final double NANOS_PER_SEC = 1000000000.0; 
	
    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there
	public WordLadderSolver()
	{
		myWatch = new StopWatch();
		myDictionary = new Dictionary();
		tempList = new ArrayList<String>();
		SolutionList = new ArrayList<String>();
	}
    // do not change signature of the method implemented from the interface
    public List<String> computeLadder(String startingWord, String endingWord) throws NoSuchLadderException 
    {
    	SolutionList.removeAll(SolutionList);
    	myWatch.reset();
    	// Words are not 5 characters
    	if((startingWord.length()!= 5) || (endingWord.length()!= 5))
    	{ 
    		System.out.println("Starting word: " + startingWord +"\nEnding word: " + endingWord + "\n");
    		throw new NoSuchLadderException("\nEach word must be 5 letters long.\n\n**********");
    	}
    	// Words are not in the dictionary
    	else if((myDictionary.findWord(startingWord) == false) && (myDictionary.findWord(endingWord) == false)) 
    	{ 
    		System.out.println("Starting word: " + startingWord +"\nEnding word: " + endingWord + "\n");
    		throw new NoSuchLadderException("\n" + startingWord + " is not in the dictionary.\n" + endingWord + "  is not in the dictionary.\n\n*********");
    	}
    	// Starting word is not in the dictionary
    	else if(myDictionary.findWord(startingWord) == false)
    	{
    		System.out.println("Starting word: " + startingWord +"\nEnding word: " + endingWord + "\n");	
    		throw new NoSuchLadderException("\n" + startingWord + " is not in the dictionary.\n\n**********");
    	}
    	// Ending words is not in the dictionary
    	else if(myDictionary.findWord(endingWord) == false) 
    	{
    		System.out.println("Starting word: " + startingWord +"\nEnding word: " + endingWord + "\n");
    		throw new NoSuchLadderException("\n" + endingWord + "  is not in the dictionary.\n\n**********");
    	}
    	// Words are the same
    	else if(startingWord.equals(endingWord))
        {
    		System.out.println("Starting word: " + startingWord +"\nEnding word: " + endingWord + "\n");
    		throw new NoSuchLadderException("\n" + startingWord + " and " + endingWord + " are the same.\n\n*********");
    	}
    	// Finds the words in the dictionary
    	else if((myDictionary.findWord(startingWord)) && (myDictionary.findWord(endingWord))) 
        { 		
        	myWatch.start();
    		boolean result = makeLadder(startingWord, endingWord, -1);
    		myWatch.stop();
    
    		if (result == false) 
    		{
    			System.out.println("Starting word: " + startingWord +"\nEnding word: " + endingWord + "\n");
    			System.out.println("Elapsed time is: " + (myWatch.getElapsedTime()/NANOS_PER_SEC) + " seconds"); 
    			throw new NoSuchLadderException("\nCannot create a word ladder between " + startingWord + " and " + endingWord + "\n\n**********");
    		}
    		else 
    		{
    			printSolutionList(startingWord, endingWord, SolutionList);
    		}
    	}
        return SolutionList; 
    }

    public boolean validateResult(String startingWord, String endingWord, List<String> wordLadder) 
    {
   	 	if (!myDictionary.findWord(startingWord) || startingWord.length() != 5){
   	 		
   	 	}
   	 	
			for (int i=1; i < wordLadder.size() ; i ++)
			{
				String check = wordLadder.get(i);
				String prev = wordLadder.get(i-1);
				if(check.length() != 5){
					
				}
				if(!myDictionary.findWord(check)){
					
				}
				if(difLetters(prev,check)!= 1){
					
				}
				
			}
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    /**
     * Calculates the number of different letters in first word to second word
     * @param firstWord first word
     * @param secondWord second word compared to
     * @return number of different letters between the words
     */
    public static int difLetters(String firstWord, String secondWord) 
    {
    	int numDifference = 0; 
    	for(int i = 0; i < 5; i++) 
    	{
	    	if((firstWord.charAt(i)) != (secondWord.charAt(i))) 
	    	{
	    		numDifference++;   	 
	    	}
	    }	
    	return numDifference; 
    }
    
   /**
    * Index of different letter
    * @param firstWord first word
    * @param secondWord second word
    * @return index of the different letter
    */
    public static int indexOfDiff(String firstWord, String secondWord) 
    {
    	for(int i = 0; i < 5; i++)
    	{
    		if((firstWord.charAt(i)) != (secondWord.charAt(i))) 
    		{
	    		 return i; 
	    	}
    	}	
    	return -1; 
    }
    
    /**
     * Recursive method that creates the ladder
     * @param firstWord starting word
     * @param secondWord target word
     * @param pos index of different letter
     */    
    private boolean makeLadder(String firstWord, String secondWord, int pos)
    {
    	ArrayList<String> temp = new ArrayList<String>(); 
    	
    	int dictionarySize = myDictionary.dictSize();
    	SolutionList.add(firstWord);
    	int index = difLetters(firstWord, secondWord);
    	if(index == 1) 
    	{ 	
    		SolutionList.add(secondWord);
    		return true;
    	}
    	for(int i = 0; i < dictionarySize; i++)
    	{
    		String word = myDictionary.getWord(i);
    		
    		if((difLetters(firstWord, word) == 1) && (pos != indexOfDiff(firstWord, word)) && (SolutionList.contains(word) != true)) 
    		{
    			int num = difLetters(secondWord,word);
    			temp.add(num + word);
    		}
    	}
    	Collections.sort(temp); 
    	boolean result = false; 
    	int count = 0; 
    	while(count < temp.size())
    	{
    		String tempStr = temp.get(count);
    		count++; 
    		String newFirst = tempStr.substring(1,6); 
    		int newPos = indexOfDiff(newFirst, firstWord); 
    		if(!(tempList.contains(newFirst)))
    		{
    			result = makeLadder(newFirst, secondWord, newPos);  
    		}
    
    		if(result == true)
    		{
    			return true; 
    		}
    		else
    		{
    			tempList.add(newFirst); 
    		}
    	}
    	SolutionList.remove(firstWord); 
    	return false; 
    }
    
    /**
     * Prints the word ladder
     * @param start starting word
     * @param to ending word
     */ 
    private void printSolutionList(String startingWord, String endingWord, List<String> Solution)
    {
    	System.out.println("Starting word: " + startingWord + "\nEnding word: " + endingWord);
    	System.out.println("\nPrinting results:"); 
    	System.out.println("");
    	for(int i = 0; i < Solution.size(); i++) 
    	{
    		System.out.println(Solution.get(i)); 
    	}	  
    	System.out.println("\nElapsed time is: " + (myWatch.getElapsedTime()/NANOS_PER_SEC) + " seconds"); 
    	myWatch.reset();
    	System.out.println("\n**********");
    }
}
