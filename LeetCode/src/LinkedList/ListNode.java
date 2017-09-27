package LinkedList;

/**
 * Created by ginolee on 3/1/17.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        ListNode cur = this;
        String output = "[ ";
        while (cur != null) {
            output += cur.val + " ";
            cur = cur.next;
        }
        return output + "]";
    }
}
