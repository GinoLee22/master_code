package LinkedList;

/**
 * Created by ginolee on 3/16/17.
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode runner = head, walker = head;
        // if this loop end --> it can't be a cycle list
        while (runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("\n self-testing");
        Solution141 s = new Solution141();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = l;
//        System.out.println(l);
        System.out.println(s.hasCycle(l));
    }
}
