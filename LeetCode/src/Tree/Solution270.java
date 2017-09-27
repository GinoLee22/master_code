package Tree;

/**
 * Created by ginolee on 8/31/17.
 */
public class Solution270 {
    public int closestValue(TreeNode root, double target) {
        double minDif = Double.MAX_VALUE;
        TreeNode closeNode = root;
        while (root != null) {
            // update the difference if possible
            double dif = Math.abs(target - root.val);
            if (dif < minDif) {
                minDif = dif;
                closeNode = root;
            }
            // update the root
            if (target > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return closeNode.val;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + 1);
    }
}
