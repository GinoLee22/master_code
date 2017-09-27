package Tree;

/**
 * Created by ginolee on 9/3/17.
 */
public class Solution156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // base case: leaf node
        if (root.left == null && root.right == null) {
            return root;
        }
        // recursion
        TreeNode leftNode = upsideDownBinaryTree(root.left);
        TreeNode cur = leftNode;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.left = root.right;
        cur.right = root;
        root.left = null;
        root.right = null;
        return leftNode;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution156 s = new Solution156();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeNode newRoot = s.upsideDownBinaryTree(root);

    }
}
