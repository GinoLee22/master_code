package Tree;

/**
 * Created by ginolee on 8/30/17.
 */

/**
 * Given a binary tree, find the subtree with minimum average. Return the root of the subtree.
 *
 * Example:
 *         1
 *    -5      11
 *  1    2  4   -2
 *  Return the node 11
 */

class ReturnType {
    public int sum;
    public int size;

    public ReturnType(int sum, int size) {
        this.sum = sum;
        this.size = size;
    }
}

public class SubtreeMaxAverage {
    private double minAvg = Integer.MIN_VALUE;
    private TreeNode minNode = null;

    public TreeNode findSubtree(TreeNode root) {
        help(root);
        return minNode;
    }

    private ReturnType help(TreeNode root) {
        // base case
        if (root == null) {
            return new ReturnType(0, 0);
        }
        // recursion
        ReturnType left = help(root.left);
        ReturnType right = help(root.right);
        // comparison: traverse
        int curSum = left.sum + right.sum + root.val, curSize = left.size + right.size + 1;
        double curAvg = (double) curSum / (double) curSize;
        if (curAvg > minAvg) {
            minAvg = curAvg;
            minNode = root;
        }
        return new ReturnType(curSum, curSize);
    }

    public static void main(String[] args) {
        System.out.println("self-tesing");
        SubtreeMaxAverage sma = new SubtreeMaxAverage();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(-2);
        System.out.println(sma.findSubtree(root).val);
    }
}
