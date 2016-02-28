/* Vo, Henry; Kim, Hyo-Jung
 * hv3364; hk6336
 * EE422C-Assignment 4
 */

package assignment4;

public class StopWatch
{     
	private long startTime;  
	private long elapsedTime;    
	private boolean isRunning;  
	public static final double NANOS_PER_SEC = 1000000000.0;   
	
	/**
	 * Constructs a StopWatch 
	 */
	public StopWatch() 
	{  
		reset();   
	}   
	
	/**
	 * Starts the StopWatch
	 */
	public void start()  
	{  
		if (isRunning) 
		{
			return;
		}
		isRunning = true;     
		startTime = System.nanoTime();   
	}     
	
	/**
	 * Stops the StopWatch
	 */
	public void stop() 
	{ 
		if (!isRunning) 
		{
			return;   
		}
		isRunning = false;     
		long endTime = System.nanoTime();      
		elapsedTime = elapsedTime + endTime - startTime;  
	}    
	
	/**
	 * @return total elapsed time
	 */
	public long getElapsedTime()   
	{  
		if (isRunning)      
		{  
			long endTime = System.nanoTime ();     
			elapsedTime = elapsedTime + endTime - startTime;   
			startTime = endTime;   
		}     
		return elapsedTime; 
	}     
	
	/**
	 * Resets elapsed time to 0
	 */
	public void reset()  
	{  
		elapsedTime = 0;
		isRunning = false;  
	}
}