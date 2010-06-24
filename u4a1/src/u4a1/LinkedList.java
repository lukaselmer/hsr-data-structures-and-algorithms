/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-12 18:13:32 +0100 (Fr, 12 Mrz 2010) $
 */
package u4a1;

/**
 * @title task 1 from exercise 4 4
 * @author tbeeler
 *
 * 1a) see numNodes() 1b) see concatenate() 1c) see reverse()
 */
public class LinkedList {

    /**
     * Solution task 1a. Recursive calculation of the numbers of nodes in the list
     * "head". Runtime O(n).
     *
     * @param head
     *          Head of the list.
     * @return Number of nodes in the list.
     */
    public int numNodes(Node head) {
        if (head == null) {
            return 0;
        }
        return 1 + numNodes(head.getNext());
    }

    /**
     * Solution task 1b. Concatenate two lists l1 and l2 to a new list. l1 and l2
     * were not changed. If a change is allowed, the runtime can be improved to
     * O(|l1|). Runtime O(|l2|+|l1|) = O(n), whereas n is the number of elements
     * in the new list.
     *
     * @param l1
     *          List 1.
     * @param l2
     *          List 2.
     * @return Concatenated list l1 and l2.
     */
    public Node concatenate(Node l1, Node l2) {
        Node current = new Node(l1.getElement());
        Node head = current;
        while (l1.getNext() != null) {
            current.append(new Node(l1.getNext().getElement()));
            current = current.getNext();
            l1 = l1.getNext();
        }
        current.append(new Node(l2.getElement()));
        current = current.getNext();
        while (l2.getNext() != null) {
            current.append(new Node(l2.getNext().getElement()));
            current = current.getNext();
            l2 = l2.getNext();
        }
        return head;
    }

    /**
     * Solution task 1c. Invert the order of list 'head'. No new list is built. The old
     * head afterwards is the last node in the list. Runtime O(n) (task).
     *
     * @param head
     *          Head of the list.
     * @return New head.
     */
    public Node reverse(Node head) {
        Node next = head.getNext();
        head.append(null);
        return reverseHelper(next, head);
    }

    public Node reverseHelper(Node n, Node beforeN) {
        if (n == null) {
            return beforeN;
        }
        Node next = n.getNext();
        n.append(beforeN);
        return reverseHelper(next, n);
    }

    /**
     * Print the elements of the list.
     *
     * @param head
     *          Head of the list.
     */
    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.getElement().toString());
            System.out.print(" ");
            head = head.getNext();
        }
        System.out.println();
    }

    /*
     * Add a copy of l2 to tail
     */
    private Node append(Node tail, Node l2) {
        while (l2 != null) {
            tail.append(new Node(l2.getElement()));
            l2 = l2.getNext();
            tail = tail.getNext();
        }
        return tail;
    }

    /**
     * Tests the class exercise 1.
     */
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("Exercise 4 - Task 1");
        System.out.println("Author: tbeeler@hsr.ch");
        final int LI = 10;
        final int L2 = 15;
        LinkedList ueb1 = new LinkedList();
        // create a List l1 with 10 elements
        Node head1 = new Node(new Integer((int) (Math.random() * 100)));
        Node l1 = head1;
        for (int i = 1; i < LI; i++) {
            l1.append(new Node(new Integer((int) (Math.random() * 100))));
            l1 = l1.getNext();
        }
        System.out.println("List 1:");
        ueb1.printList(head1);
        System.out.println();
        // create a List l2 with 15 elements
        Node head2 = new Node(new Integer((int) (Math.random() * 100)));
        Node l2 = head2;
        for (int i = 1; i < L2; i++) {
            l2.append(new Node(new Integer((int) (Math.random() * 100))));
            l2 = l2.getNext();
        }
        System.out.println("List 2:");
        ueb1.printList(head2);
        System.out.println();
        if (LI != ueb1.numNodes(head1)) {
            System.err.println("Node count does not match l1 ("
                    + ueb1.numNodes(head1) + " != " + LI + ")");
            System.exit(1);
        }
        if (L2 != ueb1.numNodes(head2)) {
            System.err.println("Node count does not match l2 ("
                    + ueb1.numNodes(head2) + " != " + L2 + ")");
            System.exit(1);
        }
        Node head3 = ueb1.concatenate(head1, head2);
        System.out.println("List 3 = List 1 o List 2:");
        ueb1.printList(head3);
        System.out.println();
        if (ueb1.numNodes(head1) + ueb1.numNodes(head2) != ueb1.numNodes(head3)) {
            System.err.println("Node count does not match head3 ("
                    + ueb1.numNodes(head3) + " != " + (LI + L2) + ")");
            System.exit(1);
        }
        Node head4 = ueb1.reverse(head3);
        System.out.println("List 4 = inverted List 3:");
        ueb1.printList(head4);
        System.out.println();
        if (ueb1.numNodes(head1) + ueb1.numNodes(head2) != ueb1.numNodes(head4)) {
            System.err.println("Node count does not match head3 ("
                    + ueb1.numNodes(head4) + " != " + (LI + L2) + ")");
            System.exit(1);
        }

        System.out.println("\nDONE\n");
        System.out.println("=========================================");
    }
}

/**
 * @title Node
 * @author tbeeler
 *
 * Utility class. Nodes of a simple linked list.
 */
class Node {

    private Object element;
    private Node next;

    /**
     * Constructs a new unlinked node.
     *
     * @param elem
     *          Object for the node.
     */
    public Node(Object elem) {
        element = elem;
        next = null;
    }

    /**
     * Adds the node next to this node.
     *
     * @param next
     *          The next node.
     */
    public void append(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public Object getElement() {
        return element;
    }
}

/* Session-Log (SOLL):

=========================================
Exercise 4 - Task 1
Author: tbeeler@hsr.ch
List 1:
51 83 31 23 53 53 90 98 88 40

List 2:
96 57 88 29 84 59 88 80 1 90 88 93 69 89 58

List 3 = List 1 o List 2:
51 83 31 23 53 53 90 98 88 40 96 57 88 29 84 59 88 80 1 90 88 93 69 89 58

List 4 = inverted list 3:
58 89 69 93 88 90 1 80 88 59 84 29 88 57 96 40 88 98 90 53 53 23 31 83 51


DONE

=========================================

 */
