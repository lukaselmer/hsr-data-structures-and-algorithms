/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-26 18:48:07 +0100 (Fr, 26 Mrz 2010) $
 */

package u6a2;

public class Entry<K extends Comparable<? super K>, V> {

  private K key;

  private V value;

  public Entry() {
  }

  public Entry(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public K setKey(K key) {
    K oldKey = this.key;
    this.key = key;
    return oldKey;
  }

  public V getValue() {
    return value;
  }

  public V setValue(V value) {
    V oldValue = this.value;
    this.value = value;
    return oldValue;
  }

  public String toString() {
    String str = key.toString();
    if (value != null) {
      str += ": " + value.toString();
    }
    return str;
  }
}
 
