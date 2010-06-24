package u4a5;

/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-18 18:21:14 +0100 (Do, 18 Mrz 2010) $
 */



import java.lang.reflect.Array;

public class QueueImpl<T> implements Queue<T> {

  private T[] array;
  private int size;
  Class<T> dataType;
  /**
   * If tracing, than enlarging or reducing of the capacity shall be traced to
   * the console.
   */
  private boolean tracing = true;

  @SuppressWarnings("unchecked")
  public QueueImpl(Class<T> dataType) {
    this.dataType = dataType;
    array = (T[]) Array.newInstance(dataType, 2); 
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public T front() throws EmptyQueueException {
    return array[0];
  }

  public void enqueue(T element) {
    if (array.length <= size) {
      enlargeArray();
    }
    array[size++] = element;
  }

  public T dequeue() throws EmptyQueueException {
    if (size > 0) {
      T obj = array[0];
      for (int i = 1; i < size; i++) {
        array[i - 1] = array[i];
      }
      size--;
      if ((size >= 2) && (size <= array.length / 2)) {
        reduceArray();
      }
      return obj;
    } else {
      throw (new EmptyQueueException(
          "Could not dequeue because queue is empty."));
    }
  }

  @SuppressWarnings("unchecked")
  private void enlargeArray() {
    T[] prev = array;
    array = (T[]) Array.newInstance(dataType, prev.length * 2); 
    if (tracing) {
      System.out.println("Enlarging array from " + prev.length + " to "
          + array.length);
    }
    for (int i = 0; i < prev.length; i++) {
      array[i] = prev[i];
    }
  }

  @SuppressWarnings("unchecked")
  private void reduceArray() {
    T[] prev = array;
    if (prev.length % 2 == 0) {
      array = (T[]) Array.newInstance(dataType, prev.length / 2);
    } else {
      array = (T[]) Array.newInstance(dataType, prev.length / 2 + 1);
    }
    if (tracing) {
      System.out.println("Reducing array from " + prev.length + " to "
          + array.length);
    }
    for (int i = 0; i < array.length; i++) {
      array[i] = prev[i];
    }
  }

  public void print() {
    if (size == 0) {
      System.out.println("The queue is empty.");
    } else {
      for (int i = 0; i < size; i++) {
        System.out.print(array[i]);
      }
    }
  }

  public void tracing(boolean newValue) {
    tracing = newValue;
  }

  public static void main(String[] args) {
    QueueImpl<Integer> queue = new QueueImpl<Integer>(Integer.class);
    for (int i = 0; i < 20; i++) {
      System.out.println("enqueue(): " + i);
      queue.enqueue(i);
    }
    System.out.println("front(): " + queue.front());
    while (!queue.isEmpty()) {
      System.out.println("dequeue(): " + queue.dequeue());
    }
  }
}

/* Session-Log:

enqueue(): 0
enqueue(): 1
enqueue(): 2
Enlarging array from 2 to 4
enqueue(): 3
enqueue(): 4
Enlarging array from 4 to 8
enqueue(): 5
enqueue(): 6
enqueue(): 7
enqueue(): 8
Enlarging array from 8 to 16
enqueue(): 9
enqueue(): 10
enqueue(): 11
enqueue(): 12
enqueue(): 13
enqueue(): 14
enqueue(): 15
enqueue(): 16
Enlarging array from 16 to 32
enqueue(): 17
enqueue(): 18
enqueue(): 19
front(): 0
dequeue(): 0
dequeue(): 1
dequeue(): 2
Reducing array from 32 to 16
dequeue(): 3
dequeue(): 4
dequeue(): 5
dequeue(): 6
dequeue(): 7
dequeue(): 8
dequeue(): 9
dequeue(): 10
Reducing array from 16 to 8
dequeue(): 11
dequeue(): 12
dequeue(): 13
dequeue(): 14
Reducing array from 8 to 4
dequeue(): 15
dequeue(): 16
Reducing array from 4 to 2
dequeue(): 17
dequeue(): 18
dequeue(): 19

*/
 
