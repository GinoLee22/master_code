package Tree;

/**
 * Created by ginolee on 2/22/17.
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        // there is no tree
        if (root == null) {
            return false;
        }
        // base case: the leaf
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        // recursion:
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        System.out.println("\n ---------- self-testing");
        Solution112 s = new Solution112();
        TreeNode source = new TreeNode(5);
        source.left = new TreeNode(4);
        source.right = new TreeNode(8);
        source.left.left = new TreeNode(11);
        source.left.left.left = new TreeNode(7);
        source.left.left.right = new TreeNode(2);
        source.right.left = new TreeNode(13);
        source.right.right = new TreeNode(4);
        source.right.right.right = new TreeNode(1);
        System.out.println(TreeNode.dfsTree(source));
        System.out.println(s.hasPathSum(source, 22));
    }
}
