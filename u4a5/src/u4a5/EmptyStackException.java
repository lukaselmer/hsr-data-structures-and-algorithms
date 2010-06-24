package u4a5;

/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-18 18:21:14 +0100 (Do, 18 Mrz 2010) $
 */



/**
 * Runtime exception thrown when one tries to perform operation top or pop on an
 * empty stack.
 */

public class EmptyStackException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public EmptyStackException(String err) {
    super(err);
  }
}
 
