package LinkedList;

/**
 * Created by ginolee on 3/2/17.
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        /**
         * recursion
         */
//        // base case:
//        if (head == null || head.next == null) {
//            return head;
//        }
//        // recursion:
//        ListNode n = head.next;
//        head.next = swapPairs(head.next.next);
//        n.next = head;
//        return n;

        /**
         * iteration
         */
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            cur.next = second;
            cur.next.next = first;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution24 s = new Solution24();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        System.out.println(l1.toString());
        System.out.println(s.swapPairs(l1));
    }
}
