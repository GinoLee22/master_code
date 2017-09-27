package LinkedList;

/**
 * Created by ginolee on 3/15/17.
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        /**
         * none recursive solution
         */
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        while (fast != null) {
            // find the last ListNode of none-duplicate
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            // check
            if (slow.next != fast) {
                slow.next = fast.next;
            } else {
                slow = slow.next;
            }
            fast = fast.next;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution82 s = new Solution82();
        System.out.println("\n ----- self-testing");
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(3);
        System.out.println(l1.toString());
        System.out.println(s.deleteDuplicates(l1));

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(3);
        l2.next.next.next.next = new ListNode(4);
        l2.next.next.next.next.next = new ListNode(4);
        l2.next.next.next.next.next.next = new ListNode(5);
        System.out.println(l2.toString());
        System.out.println(s.deleteDuplicates(l2));
    }
}
