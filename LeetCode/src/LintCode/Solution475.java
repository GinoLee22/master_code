package LintCode;

/**
 * Created by ginolee on 6/20/17.
 */
public class Solution475 {
    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = maxPathSum2(root.left) <= 0 ? 0 : maxPathSum2(root.left);
        int righttSum = maxPathSum2(root.right) <= 0 ? 0 : maxPathSum2(root.left);

        return root.val + Math.max(leftSum, righttSum);
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution475 s = new Solution475();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-100);
        System.out.println(s.maxPathSum2(root));
    }
}
