package LinkedList;

/**
 * Created by ginolee on 3/15/17.
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        /**
         * none recursive solution
         */
        // no element OR only element
        if (head == null || head.next == null) {
            return head;
        }
        // remove duplicate
        ListNode cur = head;
        while (cur.next != null) {          // the end of the list
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;             // update the current listnode only when they are not equal
            }
        }
        return head;
        /**
         * recursive solution
         */
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution83 s = new Solution83();
        ListNode l = new ListNode(1);
        l.next = new ListNode(1);
        l.next.next = new ListNode(1);
        l.next.next.next = new ListNode(1);
        l.next.next.next.next = new ListNode(2);
        l.next.next.next.next.next = new ListNode(2);
        System.out.println(l.toString());
        System.out.println(s.deleteDuplicates(l));

    }
}
