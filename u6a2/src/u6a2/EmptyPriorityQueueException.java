/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-26 18:48:07 +0100 (Fr, 26 Mrz 2010) $
 */

package u6a2;

/**
 * Runtime exception thrown when one tries to perform operation on an empty
 * priority queue.
 */

public class EmptyPriorityQueueException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public EmptyPriorityQueueException(String err) {
    super(err);
  }
}
 
