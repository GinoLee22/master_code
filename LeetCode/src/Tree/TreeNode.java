package Tree;

/**
 * Created by GinoLee on 2017/2/15.
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static String dfsTree(TreeNode inputNode) {
        String output = "";
//        output += inputNode.val;
        if (inputNode.left != null) {
            output += "(" + dfsTree(inputNode.left) + ")";
        }
        output += " " + inputNode.val + " ";
        if (inputNode.right != null) {
            output += "(" + dfsTree(inputNode.right) + ")";
        }
        return output;
    }

}
