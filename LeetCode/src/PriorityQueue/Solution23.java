package PriorityQueue;
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * Created by ginolee on 9/14/17.
 */

public class Solution23 {
    /**
     * Note: for PriorityQueue for a listNode -> have to define an self-comparator
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> comparator = (l1, l2) -> l1.val - l2.val;
        Queue<ListNode> pq = new PriorityQueue<>(comparator);
        // initialize the PriorityQueue
        for (ListNode listNode : lists) {
            if (listNode != null) {
                pq.add(listNode);
            }
        }

        ListNode dummy = new ListNode(0), cur = dummy;
        while (!pq.isEmpty()) {
            ListNode curNode = pq.poll();
            cur.next = curNode;
            cur = cur.next;
            // update the PriorityQueue
            if (curNode.next != null) {
                pq.add(curNode.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution23 s = new Solution23();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        ListNode[] lists = new ListNode[] {l1, l2, l3};
        s.mergeKLists(lists);
    }
}
