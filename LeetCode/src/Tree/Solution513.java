package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by GinoLee on 2017/2/15.
 */
public class Solution513 {
    // treat this as BFS --> so using a queue
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int output = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            // find the number to dequeue the TreeNode in the queue
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode dequeueTreeNode = queue.poll();
                // record the node value, always the 1st one
                if (i == 0) {
                    output = dequeueTreeNode.val;
                }
                if (dequeueTreeNode.left != null) {
                    queue.add(dequeueTreeNode.left);
                }
                if (dequeueTreeNode.right != null) {
                    queue.add(dequeueTreeNode.right);
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        TreeNode source1 = new TreeNode(2);
        source1.left = new TreeNode(1);
        source1.right = new TreeNode(3);

        TreeNode source2 = new TreeNode(1);
        source2.left = new TreeNode(2);
        source2.right = new TreeNode(3);
        source2.left.left = new TreeNode(4);
        source2.right.left = new TreeNode(5);
        source2.right.right = new TreeNode(6);
        source2.right.left.left = new TreeNode(7);

        Solution513 s = new Solution513();
        System.out.println(s.findBottomLeftValue(source1));
        System.out.println(s.findBottomLeftValue(source2));

    }
}
