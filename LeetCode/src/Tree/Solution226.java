package Tree;

/**
 * Created by GinoLee on 2017/2/15.
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        // base case
        if (root == null) {
            return null;
        }
        // recursion
        // must create a new node here. Can't refer to root. Otherwise, changing the new root will change the original root
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = invertTree(root.right);
        newRoot.right = invertTree(root.left);
        return newRoot;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        TreeNode source1 = new TreeNode(4);
        source1.left = new TreeNode(2);
        source1.right = new TreeNode(7);
        source1.left.left = new TreeNode(1);
        source1.left.right = new TreeNode(3);
        source1.right.left = new TreeNode(6);
        source1.right.right = new TreeNode(9);

        Solution226 s = new Solution226();
        System.out.println(TreeNode.dfsTree(source1));
        System.out.println(TreeNode.dfsTree(s.invertTree(source1)));
    }
}
