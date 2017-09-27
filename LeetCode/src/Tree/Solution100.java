package Tree;

/**
 * Created by GinoLee on 2017/2/19.
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // null node, it is the base case: one of p or q is the null pointer
        if (p == null || q == null) {
            return p == q;
        }
        // recursion
        return (p.val == q.val) && (isSameTree(p.left, q.left)) && (isSameTree(p.right, q.right));
    }

    public static void main(String[] args) {
        TreeNode s1 = new TreeNode(1);
        s1.left = new TreeNode(2);
        s1.right = new TreeNode(3);
        s1.left.right = new TreeNode(4);

        TreeNode s2 = new TreeNode(1);
        s2.left = new TreeNode(2);
        s2.right = new TreeNode(3);

        System.out.println("\n ---------- Self-testing of isSameTree()");
        Solution100 s = new Solution100();
        System.out.println(s.isSameTree(s1, s2));
    }
}
