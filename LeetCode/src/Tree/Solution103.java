package Tree;

import java.util.*;

/**
 * Created by GinoLee on 2017/2/16.
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) {
            return output;
        }
        queue.add(root);
        boolean isForward = true;               // control of zigzig
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> newList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // control the zigzag part
                if (isForward == true) {
                    newList.add(cur.val);
                } else {
                    newList.add(0, cur.val);
                }
                // queue operation
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            isForward = !isForward;             // change the control state
            output.add(newList);
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing of insertBefore() & insertAfter()");
        List<Integer> testList = new LinkedList<>();
        testList.add(1);
        testList.add(0, 2);
        System.out.println(testList.toString());

        System.out.println("\n ----- self-testing");
        TreeNode source = new TreeNode(3);
        source.left = new TreeNode(9);
        source.right = new TreeNode(20);
        source.right.left = new TreeNode(15);
        source.right.right = new TreeNode(7);

        Solution103 s = new Solution103();
        System.out.println(s.zigzagLevelOrder(source));
    }
}
