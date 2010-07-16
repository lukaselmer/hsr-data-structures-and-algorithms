/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-26 18:48:07 +0100 (Fr, 26 Mrz 2010) $
 */

package u6a2;

/**
 * @author msuess
 */
public interface PriorityQueueInterface<K extends Comparable<? super K>, V> {

  int size();

  boolean isEmpty();

  Entry<K, V> min() throws EmptyPriorityQueueException;

  void insert(K key, V value) throws InvalidKeyException;

  Entry<K, V> removeMin() throws EmptyPriorityQueueException;

  void print();
}
 
