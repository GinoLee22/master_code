package Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 8/30/17.
 */
public class TraverseDivideConquer {
    public void preorderTraverse(TreeNode root, List<Integer> res) {
        // base case
        if (root == null) {
            return;
        }
        // recursion
        res.add(root.val);
        preorderTraverse(root.left, res);
        preorderTraverse(root.right, res);
    }

    public List<Integer> divideConquer(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        // base case
        if (root == null) {
            return res;
        }
        // recursion
        List<Integer> left = divideConquer(root.left);
        List<Integer> right = divideConquer(root.right);
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("self-testing of Traverse");
        TraverseDivideConquer tdc = new TraverseDivideConquer();
        List<Integer> res = new LinkedList<>();
        tdc.preorderTraverse(root, res);
        System.out.println(res);

        System.out.println("self-testing of Divide & Conquer");

    }
}
