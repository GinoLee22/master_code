package LinkedList;

/**
 * Created by ginolee on 3/16/17.
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(val - 1);         // create a dummy node not equal to val
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution203 s = new Solution203();
        ListNode l = new ListNode(0);
//        l.next = new ListNode(1);
//        l.next.next = new ListNode(1);
//        l.next.next.next = new ListNode(1);
//        l.next.next.next.next = new ListNode(2);
        System.out.println(l.toString());
        System.out.println(s.removeElements(l, 0));
    }
}
