/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-18 18:21:14 +0100 (Do, 18 Mrz 2010) $
 */
package u5a6;

/**
 * @author msuess
 */
public interface TreeInterface<T> {

    T root();

    void setRoot(T root);

    T parent(T child) throws NoSuchNodeException;

    T leftChild(T parent) throws NoSuchNodeException;

    T rightChild(T parent) throws NoSuchNodeException;

    boolean isInternal(T node) throws NoSuchNodeException;

    boolean isExternal(T node) throws NoSuchNodeException;

    boolean isRoot(T node);

    void setRightChild(T parent, T child) throws NoSuchNodeException;

    void setLeftChild(T parent, T child) throws NoSuchNodeException;

    void removeRightChild(T parent) throws NoSuchNodeException;

    void removeLeftChild(T parent) throws NoSuchNodeException;

    int size();
}
 
