package Tree;

/**
 * Created by GinoLee on 2017/2/15.
 */
public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (root.left != null) {
            // if it is a left leave
            if (root.left.left == null && root.left.right == null) {
                ans += root.left.val;
            } else {
                ans += sumOfLeftLeaves(root.left);
            }
        }
        ans += sumOfLeftLeaves(root.right);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode source = new TreeNode(3);
        source.left = new TreeNode(9);
        source.right = new TreeNode(20);
        source.right.left = new TreeNode(15);
        source.right.right = new TreeNode(7);

        System.out.println("\n ----- self-testing");
        Solution404 s = new Solution404();
        System.out.println(s.sumOfLeftLeaves(source));
    }
}
