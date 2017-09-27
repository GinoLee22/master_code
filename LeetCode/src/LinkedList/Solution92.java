package LinkedList;

/**
 * Created by ginolee on 3/16/17.
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        // locate slow & fast
        for (int i = 0; i < m - 1; i++) {
            slow = slow.next;
        }
        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }
        // create 2 listNodes to record next of them & then swap
        ListNode nextSlow = slow.next.next, nextFast = fast.next.next, mNode = slow.next;
        slow.next = fast.next;
        fast.next.next = nextSlow;
        fast.next = mNode;
        mNode.next = nextFast;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution92 s = new Solution92();
//        ListNode l = new ListNode(1);
//        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
//        System.out.println(l.toString());
//        int m = 2, n = 4;
        ListNode l = new ListNode(3);
        l.next = new ListNode(5);
        int m = 1, n = 2;
        System.out.println(s.reverseBetween(l, m, n));
    }
}
