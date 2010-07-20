/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-04-24 08:49:59 +0200 (Sa, 24 Apr 2010) $
 */
package u9a4;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class BinarySearchTreeBak<K extends Comparable<? super K>, V> {

    protected Node root;

    public static class Entry<K, V> {

        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        protected K setKey(K key) {
            K oldKey = this.key;
            this.key = key;
            return oldKey;
        }

        public K getKey() {
            return key;
        }

        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append("[").append(key).append("/").append(value).append("]");
            return result.toString();
        }
    } // End of class Entry

    protected class Node {

        private Entry<K, V> entry;
        private Node leftChild;
        private Node rightChild;

        public Node(Entry<K, V> entry) {
            this.entry = entry;
        }

        public Node(Entry<K, V> entry, Node leftChild, Node rightChild) {
            this.entry = entry;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public Entry<K, V> getEntry() {
            return entry;
        }

        public Entry<K, V> setEntry(Entry<K, V> entry) {
            Entry<K, V> oldEntry = entry;
            this.entry = entry;
            return oldEntry;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    } // End of class Node

    protected class RemoveResult {

        private Node node;
        private Entry<K, V> entry;

        RemoveResult() {
        }

        public RemoveResult(Node node, Entry<K, V> entry) {
            this.node = node;
            this.entry = entry;
        }

        RemoveResult set(Node node) {
            this.node = node;
            return this;
        }

        public Node getNode() {
            return node;
        }

        public Entry<K, V> getEntry() {
            return entry;
        }
    }

    public Entry<K, V> insert(K key, V value) {
        Entry<K, V> newEntry = new Entry<K, V>(key, value);
        if (root == null) {
            root = new Node(newEntry);
        } else {
            Node actNode = root, parent = null;
            int cmp = 0;
            while (actNode != null) {
                cmp = actNode.getEntry().getKey().compareTo(key);
                //if (cmp == 0) {
                //    actNode.setEntry(newEntry);
                //} else {
                parent = actNode;
                if (cmp < 0) {
                    actNode = actNode.getLeftChild();
                } else {
                    actNode = actNode.getRightChild();
                }
                //}
            }
            if (cmp < 0) {
                parent.setLeftChild(new Node(newEntry));
            } else {
                parent.setRightChild(new Node(newEntry));
            }
        }
        return newEntry;
    }

    /**
     * Factory-Method: Creates a new node.
     *
     * @param entry
     *          The entry to be inserted in the new node.
     * @return The new created node.
     */
    protected Node newNode(Entry<K, V> entry) {
        return new Node(entry);
    }

    public void clear() {
        root = null;
    }

    public Entry<K, V> find(K key) {
        if (root != null) {
            Node actNode = root;
            while (actNode != null) {
                int cmp = actNode.getEntry().getKey().compareTo(key);
                if (cmp == 0) {
                    return actNode.getEntry();
                } else {
                    if (cmp < 0) {
                        actNode = actNode.getLeftChild();
                    } else {
                        actNode = actNode.getRightChild();
                    }
                }
            }
        }
        return null;
    }

    /**
     * Returns a collection with all entries with key.
     *
     * @param key
     *          The key to be searched.
     * @return Collection of all entries found. An empty collection is returned if
     *         no entry with key is found.
     */
    public Collection<Entry<K, V>> findAll(K key) {
        Collection<Entry<K, V>> entryCol = new LinkedList<Entry<K, V>>();
        Collection<Node> nodeCol = findAll(root, key);
        if (nodeCol != null) {
            Iterator<Node> it = nodeCol.iterator();
            while (it.hasNext()) {
                entryCol.add(it.next().getEntry());
            }
        }
        return entryCol;
    }

    private Collection<Node> findAll(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.getEntry().getKey()) < 0) {
            return findAll(node.leftChild, key);
        }
        if (key.compareTo(node.getEntry().getKey()) > 0) {
            return findAll(node.rightChild, key);
        }
        Collection<Node> ret = new LinkedList<Node>();
        if (node.rightChild != null) {
            Collection<Node> col = findAll(node.rightChild, key);
            if (col != null) {
                ret.addAll(col);
            }
        }
        ret.add(node);
        return ret;
    }

    /**
     * Returns a collection with all entries in inorder.
     *
     * @return Inorder-Collection of all entries.
     */
    public Collection<Entry<K, V>> inorder() {
        Collection<Entry<K, V>> ret = new LinkedList<Entry<K, V>>();
        insertInorder(root, ret);
        return ret;
    }

    private void insertInorder(Node node, Collection<Entry<K, V>> list) {
        if (node == null) {
            return;
        }
        insertInorder(node.getLeftChild(), list);
        list.add(node.getEntry());
        insertInorder(node.getRightChild(), list);
    }

    /**
     * Prints the entries of the tree as a list in inorder to the console.
     */
    public void printInorder() {
        Collection<Entry<K, V>> entries = inorder();
        for (Entry<K, V> entry : entries) {
            System.out.print("[" + entry.getKey() + "/" + entry.getValue() + "] ");
        }
        System.out.println();
    }

    /**
     * Search for the inorder successor.
     *
     * @param p
     *          The node for which the inorder successor shall be searched.
     * @return The parent-node(!) of the inorder successor.
     */
    protected Node getParentNext(Node p) {
        if (p.rightChild.leftChild != null) {
            p = p.rightChild;
            while (p.leftChild.leftChild != null) {
                p = p.leftChild;
            }
        }
        return p;
    }

    public Entry<K, V> remove(Entry<K, V> entry) {
        if (entry == null) {
            return null;
        }
        RemoveResult result = remove(root, entry);
        root = result.node;
        return result.entry;
    }

    protected RemoveResult remove(final Node node, final Entry<K, V> entry) {
        RemoveResult result = null;
        if (node == null) {
            return new RemoveResult(null, null);
        }
        if (entry.getKey().compareTo(node.getEntry().getKey()) < 0) {
            result = remove(node.leftChild, entry);
            node.leftChild = result.node;
            return result.set(node);
        } else if (entry.getKey().compareTo(node.getEntry().getKey()) > 0) {
            result = remove(node.rightChild, entry);
            node.rightChild = result.node;
            return result.set(node);
        } else {
            // Key found: is this the correct entry?
            if (node.getEntry() != entry) {
                // Searching for next entry with this key
                result = remove(node.rightChild, entry);
                node.rightChild = result.node;
                return result.set(node);
            }
            // We have reachted the correct node.
            if (node.leftChild == null) {
                return new RemoveResult(node.rightChild, node.getEntry());
            }
            if (node.rightChild == null) {
                return new RemoveResult(node.leftChild, node.getEntry());
            }
            Entry<K, V> entryRemoved = node.getEntry();
            Node q = getParentNext(node);
            if (q == node) {
                node.setEntry(node.rightChild.getEntry());
                q.rightChild = q.rightChild.rightChild;
            } else {
                node.setEntry(q.leftChild.getEntry());
                q.leftChild = q.leftChild.rightChild;
            }
            return new RemoveResult(node, entryRemoved);
        }
    }

    /**
     * The height of the tree.
     *
     * @return The actual height. -1 for an empty tree.
     */
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
    }

    public int size() {
        return inorder().size();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public static void main(String[] args) {

        // Example from lecture "Löschen (IV/IV)":
        BinarySearchTreeBak<Integer, String> bts = new BinarySearchTreeBak<Integer, String>();
        System.out.println("Inserting:");
        bts.insert(1, "Str1");
        bts.printInorder();
        bts.insert(3, "Str3");
        bts.printInorder();
        bts.insert(2, "Str2");
        bts.printInorder();
        bts.insert(8, "Str8");
        bts.printInorder();
        bts.insert(9, "Str9");
        bts.insert(6, "Str6");
        bts.insert(5, "Str5");
        bts.printInorder();

        System.out.println("Removeing 3:");
        Entry<Integer, String> entry = bts.find(3);
        System.out.println(entry);
        bts.remove(entry);
        bts.printInorder();

    }

    /* Session-Log:

    Inserting:
    [1/Str1]
    [1/Str1] [3/Str3]
    [1/Str1] [2/Str2] [3/Str3]
    [1/Str1] [2/Str2] [3/Str3] [8/Str8]
    [1/Str1] [2/Str2] [3/Str3] [5/Str5] [6/Str6] [8/Str8] [9/Str9]
    Removeing 3:
    [3/Str3]
    [1/Str1] [2/Str2] [5/Str3] [6/Str6] [8/Str8] [9/Str9]

     */
} // End of class BinaryTree

