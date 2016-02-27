/* Vo, Henry
 * hv3364
 * EE422C-Assignment 4
 */

package assignment4;

/**
 * Exception is thrown when a ladder cannot be created
 */
public class NoSuchLadderException extends Exception
{
    private static final long serialVersionUID = 1L;

    public NoSuchLadderException(String message)
    {
        super(message);
    }

    public NoSuchLadderException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
