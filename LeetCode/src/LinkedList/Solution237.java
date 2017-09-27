package LinkedList;

/**
 * Created by ginolee on 3/16/17.
 */
public class Solution237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution237 s = new Solution237();
        ListNode l = new ListNode(0);
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);
        System.out.println(l);
        s.deleteNode(l.next);
        System.out.println(l);
    }
}
