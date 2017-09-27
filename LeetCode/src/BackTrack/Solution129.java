package BackTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 8/14/17.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution129 {
    /**
     * it requires to return all possilbe solution -> typical backtrack problem
     */
    public int sumNumbers(TreeNode root) {
        StringBuilder cur = new StringBuilder();
        List<StringBuilder> res = new LinkedList<>();
        backtrack(root, cur, res);
        int sum = 0;
        for (StringBuilder sb : res) {
            sum += Integer.parseInt(sb.toString());
        }
        return sum;
    }

    private void backtrack(TreeNode root, StringBuilder cur, List<StringBuilder> res) {
        // corner case
        if (root == null) {
            return;
        }
        // base case
        if (root.left == null && root.right == null) {
            cur.append(root.val);
            res.add(new StringBuilder(cur));
            cur.deleteCharAt(cur.length() - 1);
            return;
        }
        // recursion
        cur.append(root.val);
        backtrack(root.left, cur, res);
        backtrack(root.right, cur, res);
        cur.deleteCharAt(cur.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution129 s = new Solution129();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        System.out.println(s.sumNumbers(root));
    }
}
