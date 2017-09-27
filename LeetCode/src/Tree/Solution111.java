package Tree;

/**
 * Created by ginolee on 2/22/17.
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        // base case:
        if (root == null) {
            return 0;
        }
        // recursion: there are 4 different recursion state
        if (root.left == null) {        // this contain both are null
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {       // only right is none
            return 1 + minDepth(root.left);
        }
        // both children are not null
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static void main(String[] args) {
        System.out.println("\n ---------- self-testing");
        Solution111 s = new Solution111();
        TreeNode source = new TreeNode(5);
        source.left = new TreeNode(4);
        source.left.left = new TreeNode(3);
        source.left.left.left = new TreeNode(2);
        source.left.left.left.left = new TreeNode(1);
        source.right = new TreeNode(6);
        source.right.left = new TreeNode(9);
        source.right.right = new TreeNode(7);
        source.right.right.right = new TreeNode(8);
//        source.right.right.right.right = new TreeNode(9);
        System.out.println(TreeNode.dfsTree(source));

        System.out.println(s.minDepth(source));
    }
}
