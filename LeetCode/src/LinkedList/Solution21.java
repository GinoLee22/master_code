package LinkedList;

import java.util.List;

/**
 * Created by ginolee on 3/1/17.
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // base case: there are 2 here
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // recursion part
        ListNode mergeHead;
        if (l1.val < l2.val) {
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        } else {
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution21 s = new Solution21();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
//        ListNode l2 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        ListNode mergeHead = s.mergeTwoLists(l1, l2);
        while (mergeHead != null) {
            System.out.print(mergeHead.val + " ");
            mergeHead = mergeHead.next;
        }

    }
}
