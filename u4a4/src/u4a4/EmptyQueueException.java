/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2009-12-07 20:53:11 +0100 (Mo, 07 Dez 2009) $
 */

package u4a4;

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
