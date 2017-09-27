package hw4.list;

/**
 * Created by ginolee on 1/2/17.
 */
public class LockDList extends DList {
    // inherited fields from DListNode.
    /**
     *  protected DListNode head;
     *  protected int size;
     */
    @Override
    // at this stage, the parameter should maintain the same: DListNode instead of LockDListNode
    protected LockDListNode newNode(Object item, DListNode lprev, DListNode lnext) {
        return new LockDListNode(item, (LockDListNode) lprev, (LockDListNode)lnext);
    }

    @Override
    public String toString() {
        String result = "[  ";
        DListNode current = head.next;
        while (current != head) {
            result = result + current.item + " (isLock: " + ((LockDListNode)current).isLock + ")  ";
            current = current.next;
        }
        return result + "]";
    }

    @Override
    public void remove(DListNode node) {
        // Your solution here.
        if (node == null) {
            return;
        }
        else if (((LockDListNode)node).isLock()) {
            System.err.println("This node is locked. Can't remove.");
            return;
        }
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        // answer from Github. I don't think it's a good sol as identification of null is always the 1st step.
//        if (((LockDListNode)node).isLocked == false) {
//            super.remove(node);
//        }
    }
    // new method
    public void lockNode(DListNode lnode) {
        ((LockDListNode)lnode).toLock();
    }

    // testing
    public static void main(String[] args) {
        /**
         * The true power of inheritance is only to change the constructor but leave the remaining code unchanged.
         * The overall result will be the inherited results!
         */
        System.out.println("\n ---------- Testing of Constructor, isEmpty(), length(), insertFront(), insertBack(), front(), back()");
        LockDList lockDL1 = new LockDList();
        System.out.println(lockDL1.toString() + " Size: " + lockDL1.length());
        System.out.println("This list should be empty (answer: true): " + lockDL1.isEmpty());
        lockDL1.insertFront(3);
        lockDL1.insertFront(2);
        lockDL1.insertFront(1);
        lockDL1.insertBack(4);
        lockDL1.insertBack(5);
        System.out.println(lockDL1.toString() + " Size: " + lockDL1.length());
        System.out.println("This list should not be empty (answer: false): " + lockDL1.isEmpty());
        System.out.println("The front node is: " + lockDL1.front().toString());
        System.out.println("The back node is: " + lockDL1.back().toString());

        System.out.println("\n ---------- Testing of next(), prev(), insertAfter(), insertBefore(), remove()");
        DListNode holdNode = lockDL1.front().next.next;         // let the App hold a DListNode. In this case, is "3"
        System.out.println("This node should be: " + holdNode.toString());
        System.out.println("The next node should be: " + lockDL1.next(holdNode).toString());
        System.out.println("The prev node should be: " + lockDL1.prev(holdNode).toString());
        lockDL1.insertAfter(100, holdNode);
        lockDL1.insertBefore(50, holdNode);
        System.out.println(lockDL1.toString() + " Size: " + lockDL1.length());
        lockDL1.remove(holdNode);
        System.out.println(lockDL1.toString() + " Size: " + lockDL1.length());

        System.out.println("\n ---------- Testing of lockNode()");
        DListNode toLockNode = lockDL1.front().next.next;
        System.out.println("This node should be: " + toLockNode.toString());
        lockDL1.lockNode(toLockNode);
        System.out.println("After the lock operation: " + toLockNode);
        lockDL1.remove(toLockNode);
        System.out.println("After the remove operation: " + lockDL1.toString());
    }
}
