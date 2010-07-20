/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-04-24 08:49:59 +0200 (Sa, 24 Apr 2010) $
 */



import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class AVLTree<K extends Comparable<? super K>, V> extends
    BinarySearchTree<K, V> {

  /**
   * After a BST-operation, actionNode shall points to where the balance has to
   * be checked. -> rebalance() will than be called with actionNode.
   */
  protected AVLNode actionNode;
  

  protected class AVLNode extends BinarySearchTree<K, V>.Node {

    private int height;
    private Node parent;

    AVLNode(Entry<K, V> entry) {
      super(entry);
    }

    protected AVLNode setParent(AVLNode parent) {
      AVLNode old = parent;
      this.parent = parent;
      return old;
    }

    protected AVLNode getParent() {
      return (AVLNode) parent;
    }

    protected int setHeight(int height) {
      int old = this.height;
      this.height = height;
      return old;
    }

    protected int getHeight() {
      return height;
    }

    @Override
    public AVLNode getLeftChild() {
      return (AVLNode) super.getLeftChild();
    }

    @Override
    public AVLNode getRightChild() {
      return (AVLNode) super.getRightChild();
    }

    @Override
    public String toString() {
      String result = String.format("%2d", getEntry().getKey()) + " / "
          + getEntry().getValue() + " | h=" + height;
      if (parent == null) {
        result += " ROOT";
      } else {
        boolean left = (parent.getLeftChild() == this) ? true : false;
        result += (left ? " / " : " \\ ") + "parent(key)="
            + parent.getEntry().getKey();
      }
      return result;
    }

  } // End of class AVLNode

  
  protected AVLNode getRoot() {
    return (AVLNode) root;
  }
  
  public V put(K key, V value) {
    // TODO Implement here...
    return null;
  }
  
  public V get(K key) {
    // TODO Implement here...
    return null;
  }


  /**
   * Assures the balance of the tree from 'node' up to the root.
   * 
   * @param node
   *          The node from where to start.
   */
  protected void rebalance(AVLNode node) {
    // TODO Implement here...
  }

  /**
   * Returns the height of this node.
   * @param node
   * @return The height or -1 if null.
   */
  protected int height(AVLNode node) {
    return (node != null) ? node.getHeight() : -1;
  }

  /**
   * Restructures the tree with rotations.
   * 
   * @param zPos
   *          The Z-node.
   * @return The new root-node of this subtree.
   */
  protected AVLNode restructure(AVLNode zPos) {
    // TODO Implement here...
    return null;
  }

  protected AVLNode tallerChild(AVLNode node) {
    // TODO Implement here...
    return null;
  }

  protected AVLNode rotateWithLeftChild(AVLNode k2) {
    // TODO Implement here...
    return null;
  }

  protected AVLNode doubleRotateWithLeftChild(AVLNode k3) {
    // TODO Implement here...
    return null;
  }

  protected AVLNode rotateWithRightChild(AVLNode k1) {
    // TODO Implement here...
    return null;
  }

  protected AVLNode doubleRotateWithRightChild(AVLNode k3) {
    // TODO Implement here...
    return null;
  }

  /**
   * Assures that the childrens have theirs correct parents.
   * Used after rotations.
   * @param oldSubtreeRoot The old root-node of this subtree.
   * @param newSubtreeRoot The new root-node of this subtree.
   */
  protected void adjustParents(final AVLNode oldSubtreeRoot,
      final AVLNode newSubtreeRoot) {
    // TODO Implement here...
  }

  /**
   * Assures that the children have this node as theirs parent.
   * 
   * @param node
   *          The Parent.
   */
  protected void adjustParents(final AVLNode node) {
    // TODO Implement here...
  }

  protected boolean isBalanced(AVLNode node) {
    // TODO Implement here...
    return false;
  }

  /**
   * Assures the correct height for node. 
   * @param node
   */
  protected void setHeight(AVLNode node) {
    // TODO Implement here...
  }
  
  /**
   * Factory-Method. Creates a new node.
   * 
   * @param entry
   *          The entry to be inserted in the new node.
   * @return The new created node.
   */
  @Override
  protected Node newNode(Entry<K, V> entry) {
    AVLNode avlNode = new AVLNode(entry);
    return avlNode;
  }
  
  public V remove(K key) {
    // TODO Implement here...
    return null;
  }
 
  protected void inorder(Collection<AVLNode> nodeList, AVLNode node) {
    if (node == null)
      return;
    inorder(nodeList, node.getLeftChild());
    nodeList.add(node);
    inorder(nodeList, node.getRightChild());
  }

  public void print() {
    List<AVLNode> nodeList = new LinkedList<AVLNode>();
    inorder(nodeList, (AVLNode) root);
    for (AVLNode node : nodeList) {
      System.out.println(node + "  ");
    }
  }

  public static void main(String[] args) {

    AVLTree<Integer, String> avlTree = new AVLTree<Integer, String>();
    
    // Start the GVS-Server first: Double-Click 'GVS_Server_v1.4.jar'
    //AVLTree<Integer, String> avlTree = new AVLTreeGVS<Integer, String>();
    
    System.out.println("Inserting 5:");
    avlTree.put(5, "Str_5");
    avlTree.print();
    System.out.println("================================");
    System.out.println("Inserting 7:");
    avlTree.put(7, "Str_7");
    avlTree.print();
    System.out.println("================================");
    System.out.println("Inserting 9: Single-Rotation");
    avlTree.put(9, "Str_9");
    avlTree.print();
    System.out.println("================================");
    System.out.println("Inserting 3:");
    avlTree.put(3, "Str_3");
    avlTree.print();
    System.out.println("================================");
    System.out.println("Inserting 1: Single-Rotation");
    avlTree.put(1, "Str_1");
    avlTree.print();
    System.out.println("================================");
    System.out.println("Inserting 4: Double-Rotation");
    avlTree.put(4, "Str_4");
    avlTree.print();
    System.out.println("================================");
    
  }

}

/* Session-Log:

Inserting 5:
 5 / Str_5 | h=0 ROOT  
================================
Inserting 7:
 5 / Str_5 | h=1 ROOT  
 7 / Str_7 | h=0 \ parent(key)=5  
================================
Inserting 9: Single-Rotation
 5 / Str_5 | h=0 / parent(key)=7  
 7 / Str_7 | h=1 ROOT  
 9 / Str_9 | h=0 \ parent(key)=7  
================================
Inserting 3:
 3 / Str_3 | h=0 / parent(key)=5  
 5 / Str_5 | h=1 / parent(key)=7  
 7 / Str_7 | h=2 ROOT  
 9 / Str_9 | h=0 \ parent(key)=7  
================================
Inserting 1: Single-Rotation
 1 / Str_1 | h=0 / parent(key)=3  
 3 / Str_3 | h=1 / parent(key)=7  
 5 / Str_5 | h=0 \ parent(key)=3  
 7 / Str_7 | h=2 ROOT  
 9 / Str_9 | h=0 \ parent(key)=7  
================================
Inserting 4: Double-Rotation
 1 / Str_1 | h=0 / parent(key)=3  
 3 / Str_3 | h=1 / parent(key)=5  
 4 / Str_4 | h=0 \ parent(key)=3  
 5 / Str_5 | h=2 ROOT  
 7 / Str_7 | h=1 \ parent(key)=5  
 9 / Str_9 | h=0 \ parent(key)=7  
================================

*/