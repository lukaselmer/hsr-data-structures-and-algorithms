/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2009-12-07 20:53:11 +0100 (Mo, 07 Dez 2009) $
 */

package u4a4;

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
