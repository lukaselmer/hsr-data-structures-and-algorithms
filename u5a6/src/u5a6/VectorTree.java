/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-02-16 15:22:23 +0100 (Di, 16 Feb 2010) $
 */
package u5a6;

import java.util.Vector;

public class VectorTree<T> implements TreeInterface<T> {

    private Vector<T> binaryTree;
    private int size = 0;

    public VectorTree() {
        binaryTree = new Vector<T>();
        binaryTree.setSize(2);
    }

    public T root() {
        return binaryTree.get(1);
    }

    private void checkElementExistance(T element) throws NoSuchNodeException {
        if (!binaryTree.contains(element)) {
            throw new NoSuchNodeException();
        }
    }

    public void setRoot(T root) {
        binaryTree.setSize(2);
        size = 1;
        binaryTree.set(1, root);
    }

    public T parent(T child) throws NoSuchNodeException {
        checkElementExistance(child);
        return binaryTree.get(binaryTree.indexOf(child) / 2);
    }

    private T elementAt(int position) {
        if (position < binaryTree.size()) {
            return binaryTree.get(position);
        }
        return null;
    }

    public T leftChild(T parent) throws NoSuchNodeException {
        checkElementExistance(parent);
        int position = binaryTree.indexOf(parent) * 2;
        return elementAt(position);
    }

    public T rightChild(T parent) throws NoSuchNodeException {
        checkElementExistance(parent);
        int position = (binaryTree.indexOf(parent) * 2) + 1;
        return elementAt(position);
    }

    public boolean isInternal(T node) throws NoSuchNodeException {
        checkElementExistance(node);
        int position = binaryTree.indexOf(node) * 2;
        return elementAt(position) != null || elementAt(position + 1) != null;
    }

    public boolean isExternal(T node) throws NoSuchNodeException {
        return !isInternal(node);
    }

    public boolean isRoot(T node) {
        return node.equals(binaryTree.get(1));
    }

    public void setLeftChild(T parent, T child) throws NoSuchNodeException {
        checkElementExistance(parent);
        int position = binaryTree.indexOf(parent) * 2;
        if (elementAt(position) != null) {
            removeNode(position);
        }
        size++;
        if ((position + 1) >= binaryTree.size()) {
            binaryTree.setSize(position + 1);
        }
        binaryTree.set(position, child);
    }

    public void setRightChild(T parent, T child) throws NoSuchNodeException {
        checkElementExistance(parent);
        int position = (binaryTree.indexOf(parent) * 2) + 1;
        if (elementAt(position) != null) {
            removeNode(position);
        }
        size++;
        if ((position + 1) >= binaryTree.size()) {
            binaryTree.setSize(position + 1);
        }
        binaryTree.set(position, child);
    }

    private void removeNode(int position) {
        int left_child_position = position * 2;
        int right_child_position = (position * 2) + 1;
        if (elementAt(left_child_position) != null) {
            removeNode(left_child_position);
        }
        if (elementAt(right_child_position) != null) {
            removeNode(right_child_position);
        }
        binaryTree.set(position, null);
        size--;
    }

    public void removeLeftChild(T parent) throws NoSuchNodeException {
        if (parent == null) {
            return;
        }
        checkElementExistance(parent);
        int position = binaryTree.indexOf(parent) * 2;
        if (elementAt(position) == null) {
            return; //throw new NoSuchNodeException();
        }
        removeNode(position);
    }

    public void removeRightChild(T parent) throws NoSuchNodeException {
        if (parent == null) {
            return;
        }
        checkElementExistance(parent);
        int position = (binaryTree.indexOf(parent) * 2) + 1;
        if (elementAt(position) == null) {
            return; //throw new NoSuchNodeException();
        }
        removeNode(position);
    }

    public int size() {
        return size;
    }

    public void printVector() {
        System.out.println(binaryTree);
    }

    public static void main(String[] args) throws NoSuchNodeException {

        // Hinweis:
        // Beispiel ist aus Folien-Skript "Speicherverfahren f�r B�ume: 2) Array basiert"

        VectorTree<Character> vt = new VectorTree<Character>();
        if (vt.size() != 0) {
            throw new Error("Bad size: " + vt.size() + " != 0");
        }
        if (vt.root() != null) {
            throw new Error("vt.root() != null");
        }

        System.out.println("\nSetting root with 'A':");
        Character a = 'A';
        vt.setRoot(a);
        vt.printVector();
        if (vt.size() != 1) {
            throw new Error("Bad size: " + vt.size() + " != 1");
        }
        if (!vt.isRoot(a)) {
            throw new Error("!vt.root(a)");
        }
        if (!vt.root().equals(a)) {
            throw new Error("!vt.root().equals(a) : " + vt.root());
        }
        if (!vt.isExternal(a)) {
            throw new Error("!vt.isExternal(a)");
        }
        if (vt.parent(a) != null) {
            throw new Error("vt.parent(a) != null");
        }

        System.out.println("\nSetting right child of 'A' with 'D':");
        Character d = 'D';
        vt.setRightChild(vt.root(), d);
        vt.printVector();
        if (vt.size() != 2) {
            throw new Error("Bad size: " + vt.size() + " != 2");
        }
        if (!vt.rightChild(vt.root()).equals(d)) {
            throw new Error("!vt.rightChild(vt.root()).equals(d) : "
                    + vt.rightChild(vt.root()));
        }
        if (!vt.isExternal(d)) {
            throw new Error("!vt.isExternal(d)");
        }
        if (!vt.isInternal(vt.root())) {
            throw new Error("!vt.isInternal(vt.root()");
        }
        if (!vt.parent(d).equals(a)) {
            throw new Error("!vt.parent(d).equals(a)");
        }

        System.out.println("\nSetting left child of 'A' with 'B':");
        Character b = 'B';
        vt.setLeftChild(vt.root(), b);
        vt.printVector();
        if (vt.size() != 3) {
            throw new Error("Bad size: " + vt.size() + " != 3");
        }

        System.out.println("\nSetting right child of 'B' with 'F':");
        Character f = 'F';
        vt.setRightChild(b, f);
        vt.printVector();

        System.out.println("\nSetting right child of 'F' with 'H':");
        Character h = 'H';
        vt.setRightChild(f, h);
        vt.printVector();

        System.out.println("\nSetting left child of 'F' with 'G':");
        Character g = 'G';
        vt.setLeftChild(f, g);
        vt.printVector();
        if (vt.size() != 6) {
            throw new Error("Bad size: " + vt.size() + " != 6");
        }
        if (!vt.isInternal(f)) {
            throw new Error("!vt.isInternal(f)");
        }
        if (!vt.isExternal(h)) {
            throw new Error("!vt.isExternal(h)");
        }
        if (!vt.rightChild(vt.rightChild(vt.leftChild(vt.root()))).equals(h)) {
            throw new Error(
                    "!vt.rightChild(vt.rightChild(vt.leftChild(vt.root()))).equals(h)");
        }

        vt.removeLeftChild(b);
        if (vt.size() != 6) {
            throw new Error("Bad size: " + vt.size() + " != 6");
        }

        System.out.println("\nRemoving right child of 'B':");
        vt.removeRightChild(b);
        vt.printVector();
        if (vt.size() != 3) {
            throw new Error("Bad size: " + vt.size() + " != 3");
        }
        if (!vt.isExternal(b)) {
            throw new Error("!vt.isExternal(b)");
        }

        System.out.println("\nSetting right child of 'D' with 'J':");
        vt.setRightChild(d, 'J');
        vt.printVector();

        System.out.println("\nSetting right child of root 'A' with 'X':");
        vt.setRightChild(a, 'X');
        vt.printVector();
        if (vt.size() != 3) {
            throw new Error("Bad size: " + vt.size() + " != 3");
        }

        System.out.println("\nSetting root with 'Y':");
        vt.setRoot('Y');
        vt.printVector();
        if (vt.size() != 1) {
            throw new Error("Bad size: " + vt.size() + " != 1");
        }

    }
}

/* Session-Log:

Setting root with 'A':
[null, A]

Setting right child of 'A' with 'D':
[null, A, null, D]

Setting left child of 'A' with 'B':
[null, A, B, D]

Setting right child of 'B' with 'F':
[null, A, B, D, null, F]

Setting right child of 'F' with 'H':
[null, A, B, D, null, F, null, null, null, null, null, H]

Setting left child of 'F' with 'G':
[null, A, B, D, null, F, null, null, null, null, G, H]

Removing right child of 'B':
[null, A, B, D, null, null, null, null, null, null, null, null]

Setting right child of 'D' with 'J':
[null, A, B, D, null, null, null, J, null, null, null, null]

Setting right child of root 'A' with 'X':
[null, A, B, X, null, null, null, null, null, null, null, null]

Setting root with 'Y':
[null, Y, null, null, null, null, null, null, null, null, null, null]

 */
 
