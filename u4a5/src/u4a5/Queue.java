package u4a5;

/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-18 18:21:14 +0100 (Do, 18 Mrz 2010) $
 */



public interface Queue<T> {

  /**
   * Returns the number of elements in the queue.
   * 
   * @return Number of elements in the queue.
   */
  public int size();

  /**
   * Returns whether the queue is empty.
   * 
   * @return True if the queue is empty, false otherwise.
   */
  public boolean isEmpty();

  /**
   * Inspects the element at the front of the queue.
   * 
   * @return Element at the front of the queue.
   * @exception EmptyQueueException
   *              If the queue is empty.
   */
  public T front() throws EmptyQueueException;

  /**
   * Inserts an element at the rear of the queue.
   * 
   * @param element
   *          New element to be inserted.
   */
  public void enqueue(T element);

  /**
   * Removes the element at the front of the queue.
   * 
   * @return Element removed.
   * @exception EmptyQueueException
   *              If the queue is empty.
   */
  public T dequeue() throws EmptyQueueException;
  
  /**
   * Prints the contents of the queue to the console. 
   */
  public void print();

}
 
