package Tree;

/**
 * Created by ginolee on 8/30/17.
 * Traverse + Divide&Conquer
 */

/**
 * Problem Description
 * Given a binary tree, find the subtree with the minimum sum. Return the root of the subtree.
 *
 * Example:
 *         1
 *    -5      2
 *  0   2  -4  -5
 *  Return the node 1
 */
public class MinimumSubtree {
    private int minSum = Integer.MAX_VALUE;
    private TreeNode rootRes = null;

    public TreeNode findSubtree(TreeNode root) {
        rootSum(root);
        return rootRes;
    }

    private int rootSum(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        // recursion
        int res = root.val + rootSum(root.left) + rootSum(root.right);
        // comparison: this is the traversal procedure
        if (res < minSum) {
            minSum = res;
            rootRes = root;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        MinimumSubtree ms = new MinimumSubtree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(-4);
        root.right.right = new TreeNode(-5);
        System.out.println(ms.rootSum(root));
    }
}
