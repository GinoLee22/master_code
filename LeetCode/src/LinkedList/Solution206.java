package LinkedList;

/**
 * Created by ginolee on 3/16/17.
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode newHead;
        while (cur.next != null) {
            newHead = cur.next;
            cur.next = cur.next.next;
            newHead.next = head;
            head = newHead;                 // update the original head
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution206 s = new Solution206();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        System.out.println(s.reverseList(l));
    }
}
