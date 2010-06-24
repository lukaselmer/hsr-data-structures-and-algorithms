/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2009-12-07 20:53:11 +0100 (Mo, 07 Dez 2009) $
 */

package u4a3;

/**
 * Runtime exception thrown when one tries to perform an operation on an empty
 * queue.
 */

public class DequeEmptyException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public DequeEmptyException(String err) {
    super(err);
  }
}