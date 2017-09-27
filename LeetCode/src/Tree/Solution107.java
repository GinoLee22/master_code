package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by GinoLee on 2017/2/19.
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> allList = new LinkedList<>();
        if (root == null) {
            return allList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> newList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                newList.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            allList.add(0, newList);
        }
        return allList;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        TreeNode source = new TreeNode(3);
        source.left = new TreeNode(9);
        source.right = new TreeNode(20);
        source.right.left = new TreeNode(15);
        source.right.right = new TreeNode(7);

        Solution107 s = new Solution107();
        System.out.println(s.levelOrderBottom(source));
    }
}
