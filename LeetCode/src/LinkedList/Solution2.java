package LinkedList;

/**
 * Created by ginolee on 3/28/17.
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * without change the listnode l1 & l2
         */
        // create a new listnode as the head of the output listnode. Note to return newListNode.next
        ListNode newListNode = new ListNode(0);
        ListNode cur = newListNode;
        int carrier = 0;
        while (l1 != null || l2 != null) {
            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null) ? 0 : l2.val;
            int temp = val1 + val2 + carrier;

            carrier = temp / 10;
            cur.next = new ListNode(temp % 10);
            cur = cur.next;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        // deal with the carrier
        if (carrier == 1) {
            cur.next = new ListNode(1);
        }
        return newListNode.next;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println("\n ---------- Test method addTwoNumber()");
        System.out.println("\n ---------- 1st Test");
        System.out.println("\n ---------- Create two ListNode with same length & 1 carry: ");
        ListNode ln1 = new ListNode(2);
        ln1.next = new ListNode(4);
        ln1.next.next = new ListNode(3);
        System.out.println(ln1.toString());

        ListNode ln2 = new ListNode(5);
        ln2.next = new ListNode(6);
        ln2.next.next = new ListNode(4);
        System.out.println(ln2.toString());

        ListNode sumListNode = s.addTwoNumbers(ln1, ln2);
        System.out.println(sumListNode);

        System.out.println("\n ---------- 2nd Test");
        System.out.println("\n ---------- Create two ListNode with different length & 1 carry: ");
        ListNode ln3 = new ListNode(2);
        ln3.next = new ListNode(4);
        ln3.next.next = new ListNode(6);
        System.out.println(ln3.toString());

        ListNode ln4 = new ListNode(5);
        ln4.next = new ListNode(6);
        ln4.next.next = new ListNode(4);
        ln4.next.next.next = new ListNode(9);
        System.out.println(ln4.toString());

        sumListNode = s.addTwoNumbers(ln3, ln4);
        System.out.println(sumListNode);

        System.out.println("\n ---------- 3rd Test");
        ListNode ln5 = new ListNode(9);
        ln5.next = new ListNode(9);
        ln5.next.next = new ListNode(9);
        ln5.next.next.next = new ListNode(9);
        System.out.println(ln5.toString());

        ListNode ln6 = new ListNode(1);
        System.out.println(ln6.toString());

        sumListNode = s.addTwoNumbers(ln5, ln6);
        System.out.println(sumListNode);

        System.out.println(10 % 10);
    }
}
