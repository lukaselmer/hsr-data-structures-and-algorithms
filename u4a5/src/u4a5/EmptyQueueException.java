package u4a5;

/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-18 18:21:14 +0100 (Do, 18 Mrz 2010) $
 */



/**
 * Runtime exception thrown when one tries to perform operation on an empty
 * queue.
 */

public class EmptyQueueException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public EmptyQueueException(String err) {
    super(err);
  }
}
 
