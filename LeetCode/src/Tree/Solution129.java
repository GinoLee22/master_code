package Tree;

/**
 * Created by GinoLee on 2017/2/19.
 */
public class Solution129 {

    public int sumNumbers(TreeNode root) {
        return sumNumbersHelp(root, 0);
    }

    private int sumNumbersHelp(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // base case: it is a leaf node
        if (root.left == null && root.right == null) {
            return 10 * sum + root.val;
        }
        // recursion
        int mediumSum = 10 * sum + root.val;
        int sumLeft = sumNumbersHelp(root.left, mediumSum);
        int sumRight = sumNumbersHelp(root.right, mediumSum);
        return sumLeft + sumRight;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        TreeNode source = new TreeNode(1);
        source.left = new TreeNode(2);
        source.right = new TreeNode(3);

        Solution129 s = new Solution129();
        System.out.println(s.sumNumbers(source));
    }
}
