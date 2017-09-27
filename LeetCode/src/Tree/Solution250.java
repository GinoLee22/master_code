package Tree;

/**
 * Created by ginolee on 9/3/17.
 */
public class Solution250 {
    /**
     * basic idea of Divide&Conquer
     * root.val == left.val == right.val -> 1 + count(left) + count(right)
     * otherwise -> count(left) + count(right)
     */
    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        isUniFrom(root);
        return count;
    }

    private boolean isUniFrom(TreeNode root) {
        // base case
        if (root == null) {
            return true;
        }
        // recursion by Divide&Conquer
        boolean isUni = isUniFrom(root.left) && isUniFrom(root.right);
        if ((root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)) {
            isUni = (true && isUni);
        } else {
            isUni = (false && isUni);
        }
        if (isUni) {
            count++;
        }
        return isUni;
    }

    public static void main(String[] args) {
        System.out.println("selt-testing");
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        Solution250 s = new Solution250();
        System.out.println(s.countUnivalSubtrees(root));
    }
}
