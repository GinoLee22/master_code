package Tree;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by GinoLee on 2017/2/17.
 */
public class Solution114 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(TreeNode.dfsTree(flattenHelp(root)));
//        System.out.println(flattenHelp(root));
    }

    private TreeNode flattenHelp(TreeNode root) {
        //idea is like preorder traversal
//        List<Integer> l = new LinkedList<>();
//        l.add(root.val);
        TreeNode newRoot = new TreeNode(root.val);
        if (root.left != null) {
            System.out.println(root.left.val);
            newRoot.right = flattenHelp(root.left);
//            l.addAll(flattenHelp(root.left));
        }
        if (root.right != null) {
            System.out.println(root.right.val);
            if (root.left != null) {
                newRoot.right.right = flattenHelp(root.right);
            } else {
                newRoot.right = flattenHelp(root.right);
            }
//            l.addAll(flattenHelp(root.right));
        }
        return newRoot;
//        return l;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        TreeNode source = new TreeNode(1);
        source.left = new TreeNode(2);
        source.right = new TreeNode(5);
        source.left.left = new TreeNode(3);
        source.left.right = new TreeNode(4);
        System.out.println(TreeNode.dfsTree(source));

        Solution114 s = new Solution114();
        s.flatten(source);
        System.out.println(TreeNode.dfsTree(source));
    }
}
