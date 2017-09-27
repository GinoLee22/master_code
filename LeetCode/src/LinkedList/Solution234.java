package LinkedList;

/**
 * Created by ginolee on 3/16/17.
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {    // empty OR one element list, always true
            return true;
        }

        ListNode slow = head, fast = head;
        // when finish this loop, mid point is found --> slow
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the latter one, begin with "slow.next"
        ListNode reverse = reverse(slow.next);
        // compare: because list: reverse always shorter than the previous list --> just limit the length to reverse
        while (reverse != null) {
            if (reverse.val == head.val) {
                reverse = reverse.next;
                head = head.next;
            } else {
                return false;
            }

        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {             // empty list
            return head;
        }

        ListNode cur = head;
        ListNode newHead;
        while (cur.next != null) {     // if only 1 element, just return the head
            newHead = cur.next;
            cur.next = cur.next.next;
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution234 s = new Solution234();
        System.out.println("\n ----- self testing reverse()");
        ListNode l = new ListNode(0);
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(3);
        System.out.println("Original List");
        System.out.println(l);
        System.out.println("Reversed List");
        System.out.println(s.reverse(l));
        System.out.println("\n ----- self testing isPalindrome");
        System.out.println("palindrome list");
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(0);
        System.out.println(s.isPalindrome(l1));

        System.out.println("not palindrome list");
        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(2);
        l2.next.next.next = new ListNode(3);
        System.out.println(s.isPalindrome(l2));

    }
}
