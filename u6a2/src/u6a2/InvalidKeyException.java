/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-26 18:48:07 +0100 (Fr, 26 Mrz 2010) $
 */

package u6a2;

public class InvalidKeyException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public InvalidKeyException(String err) {
    super(err);
  }
}
 
