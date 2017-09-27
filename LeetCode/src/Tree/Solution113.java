package Tree;

import java.util.*;

/**
 * Created by GinoLee on 2017/2/16.
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> allList = new LinkedList<>();
        List<Integer> currentList = new LinkedList<>();
        pathSumHelp(root, sum, allList, currentList);
        return allList;
    }

    private void pathSumHelp(TreeNode root, int sum, List<List<Integer>> allList, List<Integer> currentList) {
        // base case:
        if (root == null) {
            return;
        }
        // determine the leaf node
        currentList.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                allList.add(new LinkedList(currentList));
            }
            currentList.remove(currentList.size() - 1);             // remove the last element
            return;
        } else {
            pathSumHelp(root.left, sum - root.val, allList, currentList);
            pathSumHelp(root.right, sum - root.val, allList, currentList);
        }
        currentList.remove(currentList.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        TreeNode source = new TreeNode(5);
        source.left = new TreeNode(4);
        source.right = new TreeNode(8);
        source.left.left = new TreeNode(11);
        source.left.left.left = new TreeNode(7);
        source.left.left.right = new TreeNode(2);
        source.right.left = new TreeNode(13);
        source.right.right = new TreeNode(4);
        source.right.right.left = new TreeNode(5);
        source.right.right.right = new TreeNode(1);
        System.out.println(TreeNode.dfsTree(source));

        Solution113 s = new Solution113();
        System.out.println(s.pathSum(source, 22).toString());

    }
}
