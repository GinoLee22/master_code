package Tree;

/**
 * Created by ginolee on 6/22/17.
 */
public class Solution617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode newRoot = new TreeNode(0);
        newRoot.val = ((t1 == null) ? 0 : t1.val) + ((t2 == null) ? 0 : t2.val);
        newRoot.left = mergeTrees(t1.left, t2.left);
        newRoot.right = mergeTrees(t1.right, t2.right);
        return newRoot;
    }
}
