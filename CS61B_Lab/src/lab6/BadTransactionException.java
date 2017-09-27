package lab6;

/**
 * Created by ginolee on 1/3/17.
 */
public class BadTransactionException extends Exception  {

    public BadTransactionException (int transaction) {
        super("Invalid transaction: " + transaction);
    }
}
