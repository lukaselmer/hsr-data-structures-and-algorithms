/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-12 19:02:27 +0100 (Fr, 12 Mrz 2010) $
 */

package u4a3;

/**
 * Template exercise 4 
 * Double linked list and DE-Queue (double ended queue)
 */
public class Node<T> {

  private T element;
  private Node<T> next, prev;

  Node() {
    this(null, null, null);
  }

  Node(T e, Node<T> p, Node<T> n) {
    element = e;
    prev = p;
    next = n;
  }

  void setElement(T newElem) {
    element = newElem;
  }

  void setNext(Node<T> newNext) {
    next = newNext;
  }

  void setPrev(Node<T> newPrev) {
    prev = newPrev;
  }

  T getElement() {
    return element;
  }

  Node<T> getNext() {
    return next;
  }

  Node<T> getPrev() {
    return prev;
  }
}
