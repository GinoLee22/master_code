package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by ginolee on 9/4/17.
 */
public class Solution314 {
    private Map<Integer, List<Integer>> map = new HashMap<>();      // (K, V) -> (vertical level, list of integer)
    private int min = 0;
    private int max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // construct the hashmap
        inorder(root, 0);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = min; i <= max; i++) {
            if (!map.containsKey(i)) {
                continue;
            }
            res.add(map.get(i));
        }
        return res;
    }

    private void inorder(TreeNode root, int curLevel) {
        // base case
        if (root == null) {
            return;
        }
        // recursion
        inorder(root.left, curLevel - 1);
        // visit
        if (!map.containsKey(curLevel)) {
            map.put(curLevel, new LinkedList<>());
        }
        map.get(curLevel).add(root.val);
        min = Math.min(min, curLevel);
        max = Math.max(max, curLevel);

        inorder(root.right, curLevel + 1);
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution314 s = new Solution314();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(s.verticalOrder(root));
    }
}
