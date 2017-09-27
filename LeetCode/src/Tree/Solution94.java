package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by GinoLee on 2017/2/16.
 */
public class Solution94 {
    /**
     * recursion template
     * // base case
     * if (root == null) {
     * return;
     * }
     * // recursion
     * inorder(root.left);
     * visit(root);
     * inorder(root.right);
     * NOTE: draw a recursive graph to illustrate the overall procedure
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();
        stack.add(root);
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        TreeNode source = new TreeNode(1);
        source.left = new TreeNode(2);
        source.right = new TreeNode(3);
        source.left.left = new TreeNode(4);
        source.left.right = new TreeNode(5);

        Solution94 s = new Solution94();
        System.out.println(s.inorderTraversal(source));

        Map<Integer, Integer> map = new HashMap<>();
        map.put(10, 1);
        map.put(20, 2);
        for (int i : map.keySet()) {
            if (map.get(i) == 2) {
                System.out.println(i);
            }
        }
    }
}
