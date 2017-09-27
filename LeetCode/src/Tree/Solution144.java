package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GinoLee on 2017/2/16.
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // recursive solution
        List<Integer> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        // recursion
        output.add(root.val);
        if (root.left != null) {
            output.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            output.addAll(preorderTraversal(root.right));
        }
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

        Solution144 s = new Solution144();
        System.out.println(s.preorderTraversal(source));
    }
}
