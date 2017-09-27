package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GinoLee on 2017/2/15.
 */
public class Solution257 {
    // good idea
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        searchHelp(root, "", answer);
        return answer;
    }

    private void searchHelp (TreeNode root, String path, List<String> answer) {
        // base case
        if (root.left == null && root.right == null) {
            answer.add(path + root.val);
        }
        // recursion
        if (root.left != null) {
            searchHelp(root.left, path + root.val + "->", answer);
        }
        if (root.right != null) {
            searchHelp(root.right, path + root.val + "->", answer);
        }
    }

    public static void main(String[] args) {
        TreeNode source = new TreeNode(1);
        source.left = new TreeNode(2);
        source.right = new TreeNode(3);
        source.left.right = new TreeNode(5);

        Solution257 s = new Solution257();
        System.out.println(s.binaryTreePaths(source));

    }
}
