package Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 8/30/17.
 */
public class Test {
    public List<List<Integer>> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<Integer> cur = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        backtrack(root, res, cur);
        return res;
    }

    private void backtrack(TreeNode root, List<List<Integer>> res, List<Integer> cur) {
        // base case: 2
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            cur.add(root.val);
            res.add(new LinkedList(cur));
            cur.remove(cur.size() - 1);
            return;
        }
        // recursion
        cur.add(root.val);
        backtrack(root.left, res, cur);
        backtrack(root.right, res, cur);
        cur.remove(cur.size() - 1);
        return;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Test t = new Test();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(t.binaryTreePaths(root));

        System.out.println("->".length());
    }
}
