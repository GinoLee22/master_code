package Tree;

import java.util.*;

/**
 * Created by GinoLee on 2017/2/16.
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return output;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                levelList.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            output.add(levelList);
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        TreeNode source = new TreeNode(3);
        source.left = new TreeNode(9);
        source.right = new TreeNode(20);
        source.right.left = new TreeNode(15);
        source.right.right = new TreeNode(7);

        Solution102 s = new Solution102();
        System.out.println(s.levelOrder(source));
    }
}
