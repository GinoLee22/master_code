package Tree;

/**
 * Created by ginolee on 6/22/17.
 */
public class Solution606 {
    public String tree2str(TreeNode t) {
        return preOrder(t);
    }

    private String preOrder(TreeNode root) {
        // base case
        if (root == null) {
            return null;
        }
        // recursion by Divide&Conquer
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        String left = preOrder(root.left);
        String right = preOrder(root.right);
        if (left != null) {
            sb.append("(" + left + ")");
        } else if (right != null) {
            sb.append("()");
        }
        if (right != null) {
            sb.append("(" + right + ")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution606 s = new Solution606();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        System.out.println(s.tree2str(root));
    }
}
