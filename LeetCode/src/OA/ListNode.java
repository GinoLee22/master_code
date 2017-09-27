package OA;

/**
 * Created by ginolee on 9/16/17.
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static String toString(ListNode cur) {
        String output = "[ ";
        while (cur != null) {
            output += cur.val + " ";
            cur = cur.next;
        }
        return output + "]";
    }
}
