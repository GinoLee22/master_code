package LinkedList;

/**
 * Created by ginolee on 3/16/17.
 */
public class Solution160 {
    /**
     * Pre-Assumption: the 2 list only intersection once and then won't separate
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {       // this part is not necessary
            return null;
        }
        // 1st step: find the lengths respectively
        int lengthA = length(headA), lengthB = length(headB);
        // 2nd step: alignment
        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }
        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }
        // 3rd step: compare
        while (headA != headB) {        // if no intersection, they will all reach null and equal to each other
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int length(ListNode head) {
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing of private method");
        Solution160 s = new Solution160();
        ListNode l = new ListNode(0);
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(3);
        System.out.println(s.length(l));

        System.out.println("\n ----- self-testing of solution");
        ListNode lA = new ListNode(0);
        lA.next = new ListNode(1);
        lA.next.next = new ListNode(2);
        lA.next.next.next = new ListNode(3);
        System.out.println(s.length(lA));
        ListNode lB = new ListNode(100);
        lB.next = new ListNode(101);
        lB.next.next = new ListNode(102);
        lB.next.next.next = lA.next.next;
        System.out.println(lA);
        System.out.println(lB);
        System.out.println(s.getIntersectionNode(lA, lB));
    }
}
