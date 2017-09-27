package Tree;

/**
 * Created by GinoLee on 2017/2/19.
 */
public class Solution101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        // base case:
        if (left == null || right == null) {
            return left == right;
        }
        // recursion
        return (left.val == right.val) && (isSymmetricHelp(left.left, right.right)) && (isSymmetricHelp(left.right, right.left));
    }

    public static void main(String[] args) {
        TreeNode source = new TreeNode(1);
        source.left = new TreeNode(2);
        source.right = new TreeNode(2);
        source.left.left = new TreeNode(3);
        source.left.right = new TreeNode(4);
        source.right.left = new TreeNode(4);
        source.right.right = new TreeNode(4);
//        source.right.right.right = new TreeNode(100);

        Solution101 s = new Solution101();
        System.out.println(s.isSymmetric(source));
    }
}
