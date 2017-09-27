package Tree;

import java.util.*;

/**
 * Created by GinoLee on 2017/2/16.
 */
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        // recursive solution
        List<Integer> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        // recursion
        if (root.left != null) {
            output.addAll(postorderTraversal(root.left));
        }
        if (root.right != null) {
            output.addAll(postorderTraversal(root.right));
        }
        output.add(root.val);
        return output;

        // none-recursive solution
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        TreeNode source = new TreeNode(1);
        source.left = new TreeNode(2);
        source.right = new TreeNode(3);
        source.left.left = new TreeNode(4);
        source.left.right = new TreeNode(5);

        Solution145 s = new Solution145();
        System.out.println(s.postorderTraversal(source));
    }
}
