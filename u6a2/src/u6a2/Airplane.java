/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-26 18:48:07 +0100 (Fr, 26 Mrz 2010) $
 */

package u6a2;

public class Airplane {

  private String departureAirport;
  private long quantityOfPetrol;

  public Airplane(String departureAirport, long quantityOfPetrol) {
    this.departureAirport = departureAirport;
    this.quantityOfPetrol = quantityOfPetrol;
  }

  public String getDepartureAirport() {
    return departureAirport;
  }

  public long getQuantityOfPetrol() {
    return quantityOfPetrol;
  }

}
 
