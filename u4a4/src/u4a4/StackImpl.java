/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-12 19:39:58 +0100 (Fr, 12 Mrz 2010) $
 */
package u4a4;

import java.util.LinkedList;

public class StackImpl<T> implements Stack<T> {

    private LinkedList<T> list = new LinkedList<T>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty!");
        }
        return list.getFirst();
    }

    public void push(T element) {
        list.push(element);
    }

    public T pop() throws EmptyStackException {
        return list.pop();
    }

    public void print() {
        if (list.size() == 0) {
            System.out.println("The stack is empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
        }
    }

    public static void main(String[] args) {
        StackImpl<Integer> stack = new StackImpl<Integer>();
        for (int i = 0; i < 20; i++) {
            System.out.println("push(): " + i);
            stack.push(i);
        }
        System.out.println("top(): " + stack.top());
        while (!stack.isEmpty()) {
            System.out.println("pop(): " + stack.pop());
        }
    }
}

/* Session-Log (SOLL):

push(): 0
push(): 1
push(): 2
push(): 3
push(): 4
push(): 5
push(): 6
push(): 7
push(): 8
push(): 9
push(): 10
push(): 11
push(): 12
push(): 13
push(): 14
push(): 15
push(): 16
push(): 17
push(): 18
push(): 19
top(): 19
pop(): 19
pop(): 18
pop(): 17
pop(): 16
pop(): 15
pop(): 14
pop(): 13
pop(): 12
pop(): 11
pop(): 10
pop(): 9
pop(): 8
pop(): 7
pop(): 6
pop(): 5
pop(): 4
pop(): 3
pop(): 2
pop(): 1
pop(): 0

 */
