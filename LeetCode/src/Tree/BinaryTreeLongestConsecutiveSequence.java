package Tree;

/**
 * Created by ginolee on 9/1/17.
 */

/**
 * Problem Description (Very Good Problem)
 * Given a binary tree, find the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-children connection.
 * The longest consecutive path need to be from parent to child.
 *
 * Example
 *          1
 *           \
 *           3
 *          / \
 *         2  4
 *             \
 *             5
 *              => return 3-4-5
 */
public class BinaryTreeLongestConsecutiveSequence {
    /**
     * my 1st idea is to use backtrack to return all results. But it is not good because this problem could have many start point & end point
     * BackTrack algorithm is awesome for Fixed start point!
     * use Divide&Conquer instead.
     * In Divide&Conquer, I have to check each treenode separately -> so have to use a global variable to track the longest value
     */
    private int longest = 0;
    public int longestConsecutive(TreeNode root) {
        help(root);
        return longest;
    }

    private int help(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        // recursion by Divide&Conquer
        int leftMax = help(root.left);
        int rightMax = help(root.right);

        int curLongest = 1;
        if (root.left != null && root.val + 1 == root.left.val) {
            curLongest = Math.max(leftMax + 1, curLongest);
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            curLongest = Math.max(rightMax + 1, curLongest);
        }
        if (curLongest > longest) {
            longest = curLongest;
        }
        return curLongest;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        BinaryTreeLongestConsecutiveSequence lcs = new BinaryTreeLongestConsecutiveSequence();
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(2);
//        root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode(5);
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(lcs.longestConsecutive(root));
    }
}
