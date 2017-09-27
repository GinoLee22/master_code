package LinkedList;

/**
 * Created by ginolee on 3/17/17.
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        ListNode cur = evenHead;
        boolean isOdd = true;

        while (cur != null && cur.next != null) {
            cur = cur.next;
            if (isOdd) {
                odd.next = cur;
                odd = odd.next;
            } else {
                even.next = cur;
                even = even.next;
            }
            isOdd = !isOdd;
        }
        odd.next = evenHead;
        even.next = null;
        return head;
    }

    public static void main(String[] args) {
        Solution328 s = new Solution328();
        System.out.println("\n ----- self-testing");
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        System.out.println(l.toString());
        System.out.println(s.oddEvenList(l));
    }
}
