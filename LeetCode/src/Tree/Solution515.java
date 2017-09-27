package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by GinoLee on 2017/2/16.
 */
public class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return output;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                max = Math.max(max, currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            output.add(max);
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        TreeNode source = new TreeNode(1);
        source.left = new TreeNode(3);
        source.right = new TreeNode(2);
        source.left.left = new TreeNode(5);
        source.left.right = new TreeNode(3);
        source.right.right = new TreeNode(9);

        Solution515 s = new Solution515();
        System.out.println(s.largestValues(source));
    }
}
