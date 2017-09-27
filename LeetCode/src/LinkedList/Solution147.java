package LinkedList;

/**
 * Created by ginolee on 3/16/17.
 */
public class Solution147 {
    /**
     * next time: don't create a new ListNode, instead, connect it to the existing listnode
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        while (cur != null) {
            ListNode sortedCur = dummy;
            while (sortedCur.next != null && cur.val > sortedCur.next.val) {
                sortedCur = sortedCur.next;
            }
            ListNode temp = sortedCur.next;
            sortedCur.next = new ListNode(cur.val);
            sortedCur.next.next = temp;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution147 s = new Solution147();
        System.out.println("\n ----- self-testing");
        ListNode l = new ListNode(2);
        l.next = new ListNode(1);
        l.next.next = new ListNode(5);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(3);
        System.out.println(l.toString());

        System.out.println(s.insertionSortList(l));
    }
}
