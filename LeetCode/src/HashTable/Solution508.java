package HashTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by ginolee on 5/28/17.
 */
public class Solution508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        /**
         * Ideal: calculate each TreeSum of different nodes & store in HashTable. Then, find the max.
         */
        Map<Integer, Integer> map = new HashMap<>();        // (K, V): (sum, # of appearance)
        List<Integer> list = new LinkedList<>();
        preOrderSum(root, map);
        // loop to find the maximum frequency
        int max = 0;
        for (int value : map.values()) {
            max = Math.max(value, max);
        }
        // loop for the final list
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        // Integer list --> int[] array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * calculate each TreeSum of different nodes.
     */
    private int preOrderSum(TreeNode root, Map<Integer, Integer> map){
        if (root == null) {
            return 0;
        }
        int sum = root.val + preOrderSum(root.left, map) + preOrderSum(root.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-test of preOrderSum()");
        Solution508 s = new Solution508();
        TreeNode root = new TreeNode(5);
        Map<Integer, Integer> map = new HashMap<>();

        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        System.out.println(s.preOrderSum(root, map));
        System.out.println(map);

        System.out.println("\n ----- self-testing");
        System.out.println(s.findFrequentTreeSum(root));
    }
}
