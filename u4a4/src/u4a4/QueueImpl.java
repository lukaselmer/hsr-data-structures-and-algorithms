/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-12 19:39:58 +0100 (Fr, 12 Mrz 2010) $
 */
package u4a4;

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
    private int front;

    @SuppressWarnings("unchecked")
    public QueueImpl(Class<T> dataType) {
        this.dataType = dataType;
        array = (T[]) Array.newInstance(dataType, 2);
        size = 0;
        front = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T front() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty!");
        }
        return array[front];
    }

    public void enqueue(T element) {
        if (array.length <= size) {
            enlargeArray();
        }
        array[rearIndex()] = element;
        size++;
    }

    private int rearIndex() {
        return (front + size) % array.length;
    }

    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty!");
        }
        T element = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        if ((size * 2) <= (array.length) && (array.length > 2)) {
            reduceArray();
        }
        return element;
    }

    @SuppressWarnings("unchecked")
    private void enlargeArray() {
        if (tracing) {
            System.out.println("Enlarging array from " + array.length + " to " + array.length * 2);
        }
        T[] newArray = (T[]) Array.newInstance(dataType, array.length * 2);
        int tmpSize = size;
        for (int i = 0; 0 < tmpSize; i++) {
            newArray[i] = array[(i + front) % array.length];
            tmpSize--;
        }
        front = 0;
        array = newArray;
    }

    @SuppressWarnings("unchecked")
    private void reduceArray() {
        if (tracing) {
            System.out.println("Reducing array from " + array.length + " to " + array.length / 2);
        }
        T[] newArray = (T[]) Array.newInstance(dataType, array.length / 2);
        int tmpSize = size;
        for (int i = 0; 0 < tmpSize; i++) {
            newArray[i] = array[(i + front) % array.length];
            tmpSize--;
        }
        front = 0;
        array = newArray;
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

/* Session-Log (SOLL):

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
