package LinkedList;

/**
 * Created by ginolee on 3/16/17.
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0), largeHead = new ListNode(0);
        ListNode small = smallHead, large = largeHead;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        small.next = largeHead.next;
        large.next = null;                  // end the listNode
        return smallHead.next;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution86 s = new Solution86();
        ListNode l = new ListNode(1);
        l.next = new ListNode(4);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(2);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(2);
        System.out.println(l.toString());
        System.out.println(s.partition(l, 3));
    }
}
