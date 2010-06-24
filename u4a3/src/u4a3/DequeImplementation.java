/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-12 19:02:27 +0100 (Fr, 12 Mrz 2010) $
 */
package u4a3;

public class DequeImplementation<T> {

    Node<T> header, trailer;
    int size;

    public DequeImplementation() {
        header = new Node<T>();
        trailer = new Node<T>();
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
    }

    public void insertFirst(T element) {
        Node<T> second = header.getNext();
        Node<T> first = new Node<T>(element, header, second);
        second.setPrev(first);
        header.setNext(first);
        size++;
    }

    public T removeLast() throws DequeEmptyException {
        if (!isEmpty()) {
            Node<T> last = trailer.getPrev();
            T o = last.getElement();
            Node<T> secondtolast = last.getPrev();
            trailer.setPrev(secondtolast);
            secondtolast.setNext(trailer);
            size--;
            return o;
        } else {
            throw new DequeEmptyException("Deque is empty!");
        }
    }

    public T removeFirst() throws DequeEmptyException {
        if (!isEmpty()) {
            Node<T> first = header.getNext();
            header.setNext(first.getNext());
            header.getNext().setPrev(header);
            size--;
            return first.getElement();
        } else {
            throw new DequeEmptyException("Deque is empty!");
        }

    }

    public void insertLast(T element) {
        Node<T> last = trailer.getPrev();
        Node<T> newLast = new Node(element, last, trailer);
        last.setNext(newLast);
        trailer.setPrev(newLast);
        size++;
    }

    public T first() throws DequeEmptyException {
        if (isEmpty()) {
            throw new DequeEmptyException("Deque is empty!");
        }
        return header.getNext().getElement();
    }

    public T last() throws DequeEmptyException {
        if (isEmpty()) {
            throw new DequeEmptyException("Deque is empty!");
        }
        return trailer.getPrev().getElement();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }

    public static void main(String[] args) {
        DequeImplementation<Integer> deque = new DequeImplementation<Integer>();
        for (int i = 0; i < 10; i++) {
            System.out.println("insertFirst(): " + i);
            deque.insertFirst(i);
        }
        for (int i = 10; i < 20; i++) {
            System.out.println("insertLast(): " + i);
            deque.insertLast(i);
        }
        System.out.println("first(): " + deque.first());
        System.out.println("last():  " + deque.last());
        for (int i = 0; i < 5; i++) {
            deque.removeFirst();
        }
        for (int i = 0; i < 5; i++) {
            deque.removeLast();
        }
        System.out.println("first(): " + deque.first());
        System.out.println("last():  " + deque.last());

    }
}

/* Session-Log (SOLL):

insertFirst(): 0
insertFirst(): 1
insertFirst(): 2
insertFirst(): 3
insertFirst(): 4
insertFirst(): 5
insertFirst(): 6
insertFirst(): 7
insertFirst(): 8
insertFirst(): 9
insertLast(): 10
insertLast(): 11
insertLast(): 12
insertLast(): 13
insertLast(): 14
insertLast(): 15
insertLast(): 16
insertLast(): 17
insertLast(): 18
insertLast(): 19
first(): 9
last():  19
first(): 4
last():  14

 */
