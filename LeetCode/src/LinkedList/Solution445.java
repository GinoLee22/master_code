package LinkedList;

import java.util.Stack;

/**
 * Created by ginolee on 3/17/17.
 */
public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        /**
         * keyidea: don't implement the idea of insertion because it's complicate --> have to record the next listnode.
         * Instead create a new head, always inserting at the very beginning
         */
        int sum = 0;
        ListNode result = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) {
                sum += s1.pop();
            }
            if (!s2.empty()) {
                sum += s2.pop();
            }
            result.val = sum % 10;
            ListNode newHead = new ListNode(sum / 10);
            newHead.next = result;
            result = newHead;
            sum /= 10;
        }
        return result.val == 0 ? result.next : result;
    }

    public static void main(String[] args) {
        Solution445 s = new Solution445();
        System.out.println("\n ----- self-testing");
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        System.out.println(l1);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(l2);

        System.out.println(s.addTwoNumbers(l1, l2));

    }
}
