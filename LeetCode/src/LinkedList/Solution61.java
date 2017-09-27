package LinkedList;

//import num.Solution;

/**
 * Created by ginolee on 3/6/17.
 */
public class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {
        /**
         * two pass algorithm: 1 by counting the lenght, 1 by rotation
         */
        // empty list
        if (head == null) {
            return null;
        }
        // if not empty --> get the length of the list
        int l = 1;
        ListNode curNode = head;
        while (curNode.next != null ) {
            l++;
            curNode = curNode.next;         // finally it will be the original tailnode
        }

        // rotation number within [0 l]
        int rotation = k % l;
        ListNode newTail = head;
        for (int i = 0; i < l - rotation - 1; i++) {
            newTail = newTail.next;
        }

        // rotation operation
        curNode.next = head;            // connect the tail to head firstly otherwise there will be null if k = 0
        head = newTail.next;
        newTail.next = null;
        return head;

        /**
         * one pass algorithm achieved by 2 pointer
         * However, it is very inefficient when "list length is 3" and "n = 9999999"
         */
//        // initialization
//        if (head == null || k == 0) {
//            return head;
//        }
//
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode slow = dummy, fast = dummy, pre = dummy;
//        // locate the fast ListNode
//        for (int i = 0; i <= k; i++) {
//            if (fast == null) {
//                fast = dummy.next;
//            }
//            fast = fast.next;
//        }
//        // find the rotation location
//        while (fast != null) {
//            // set the pre ListNode
//            if (fast.next == null) {
//                pre = fast;
//            }
//            slow = slow.next;
//            fast = fast.next;
//        }
//        // rotation
//        ListNode newHead = slow.next;
//        slow.next = null;
//        pre.next = dummy.next;
//        return newHead;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
//        l.next.next.next.next.next = new ListNode(5);
        System.out.println("\n ----- Original List");
        System.out.println(l);
        System.out.println("\n ----- Rotation");
        Solution61 s = new Solution61();
        int k = 7;
        System.out.println(s.rotateRight(l, k));
        System.out.println();
    }
}
