package Tree;


/**
 * Created by GinoLee on 2017/2/19.
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        // base case: null node
        if (root == null) {
            return 0;
        }
        // recursion:
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    public static void main(String[] args) {
        TreeNode source = new TreeNode(1);
        source.left = new TreeNode(1);
        source.right = new TreeNode(1);
        source.left.left = new TreeNode(1);
        source.left.right = new TreeNode(1);

        Solution104 s = new Solution104();
        System.out.println(s.maxDepth(source));
    }
}
