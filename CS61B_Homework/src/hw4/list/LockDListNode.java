package hw4.list;

/**
 * Created by ginolee on 1/2/17.
 */
public class LockDListNode extends DListNode {

    // inherited fields from DListNode
    /**
     *  public Object item;
     *  protected DListNode prev;
     *  protected DListNode next;
     */
    protected boolean isLock;

    /**
     * LockDListNode() constructor.
     *
     * @param i the item to store in the node.
     * @param lp the locknode previous to this node.
     * @param ln the locknode following this node.
     * The isLock is always false when creation
     * Important: Every LockDListNode is DListNode, so "superclass = subclass".
     */
    LockDListNode(Object i, LockDListNode lp, LockDListNode ln) {
        super(i, lp, ln);
        isLock = false;
    }

    @Override
    public String toString() {          // only applicable in double-linked list
        return "Item of this node: " + item + ". Its isLock state is: " + isLock + ".";
    }

    public void toLock() {
        isLock = true;
    }

    public boolean isLock() {
        return isLock;
    }

    public static void main(String[] args) {
        LockDListNode ldln = new LockDListNode(10, null, null);
        System.out.println(ldln.toString());
        ldln.toLock();
        System.out.println(ldln.toString());
    }
}
