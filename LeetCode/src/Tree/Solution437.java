package Tree;

/**
 * Created by ginolee on 8/8/17.
 */
public class Solution437 {
    int num = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        pathSumStart(root, sum);
        while (root != null) {
            pathSum(root.left, sum - root.val);
            pathSum(root.right, sum - root.val);
        }
        return num;
    }

    private void pathSumStart(TreeNode startNode, int sum) {
        // base case
        if (startNode == null) {
            return;
        }
        if (sum == startNode.val) {
            num++;
        }
        // recursion
        pathSumStart(startNode.left, sum - startNode.val);
        pathSumStart(startNode.right, sum - startNode.val);
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution437 s = new Solution437();
        TreeNode root = new TreeNode(1);
        System.out.println(s.pathSum(root, 8));
    }
}
