/* DListNode.java */

package hw4.list;

/**
 * A DListNode is a node in a DList (doubly-linked list).
 */

public class DListNode {

    /**
     * item references the item stored in the current node.
     * prev references the previous node in the DList.
     * next references the next node in the DList.
     * <p>
     * DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
     */

    public Object item;
    protected DListNode prev;
    protected DListNode next;

    /**
     * DListNode() constructor.
     *
     * @param i the item to store in the node.
     * @param p the node previous to this node.
     * @param n the node following this node.
     */
    DListNode(Object i, DListNode p, DListNode n) {
        item = i;
        prev = p;
        next = n;
    }

    @Override
    public String toString() {          // only applicable in double-linked list
        return "Item of this node: " + item + ".  Item of prev: " + prev.item + ". Item of next: " + next.item +  ".";
    }


}
