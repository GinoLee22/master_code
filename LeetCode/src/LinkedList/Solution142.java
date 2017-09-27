package LinkedList;

/**
 * Created by ginolee on 3/16/17.
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode walker = head, runner = head;
        while (runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker) {
                ListNode cur = head;
                while (cur != walker) {
                    cur = cur.next;
                    walker = walker.next;
                }
                return cur;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution142 s = new Solution142();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = l;
        System.out.println(s.detectCycle(l.next).val);
    }
}
