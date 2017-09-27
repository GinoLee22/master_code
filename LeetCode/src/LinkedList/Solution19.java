package LinkedList;

/**
 * Created by ginolee on 3/29/17.
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * create 2 ListNodes: slow & fast with a gap "n".
         * when the fast ListNode reaches the end of the list, the slow ListNode reaches the to be deleted node
         */
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode slow = sentinel, fast = sentinel;
        // find the fast ListNode
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        // loop until the fast ListNode reach the end & find the slow ListNode
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // delete this slow ListNode
        slow.next = slow.next.next;
        return sentinel.next;
    }

    public static void main(String[] args) {
        Solution19 s = new Solution19();
        System.out.println("\n ----- self-testing");
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(l1.toString());
        System.out.println(s.removeNthFromEnd(l1, 1));
    }
}
