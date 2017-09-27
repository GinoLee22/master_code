package Tree;

import javax.xml.transform.Result;

/**
 * Created by ginolee on 2/22/17.
 */
public class Solution110 {
    private class ResultType {
        private int height;
        private boolean isBalance;

        public ResultType(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    public boolean isBalanced(TreeNode root) {
        ResultType res = getHeightBalance(root);
        return res.isBalance;
    }

    private ResultType getHeightBalance(TreeNode root) {
        // base case
        if (root == null) {
            return new ResultType(0, true);
        }
        // recursion
        ResultType left = getHeightBalance(root.left);
        ResultType right = getHeightBalance(root.right);
        if (!left.isBalance || !right.isBalance || Math.abs(left.height - right.height) > 1) {
            return new ResultType(-1, false);
        }
        return new ResultType(Math.max(left.height, right.height) + 1, true);
    }

    public static void main(String[] args) {
        Solution110 s = new Solution110();
        System.out.println("\n ---------- self-testing of depthTreeNode()");
        TreeNode source = new TreeNode(1);
        source.left = new TreeNode(2);
        source.right = new TreeNode(3);
        source.left.left = new TreeNode(4);
//        source.left.right = new TreeNode(5);
        source.right.left = new TreeNode(6);
        source.right.right = new TreeNode(7);
        source.left.left.left = new TreeNode(8);
        System.out.println(TreeNode.dfsTree(source));
//        System.out.println("depth of this tree is: " + s.height(source));

        System.out.println("\n ---------- self-testing of isBalanced()");
        System.out.println(s.isBalanced(source));

        System.out.println(1 << 0);
        int n = 1;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            char cur = (char) ('A' + (n - 1) % 26);
            sb.append(cur);
            n /= 26;
        }
        System.out.println(sb.toString());
    }
}
