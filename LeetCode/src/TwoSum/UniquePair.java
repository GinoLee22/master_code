package TwoSum;

/**
 * Created by ginolee on 8/25/17.
 */

import java.util.*;

/**
 * Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number. Please return the number of pairs
 *
 * Example:
 * Given number [1 1 2 45 46 46]. target = 47, return 2.
 * 1 + 46 = 47
 * 1 + 45 = 47
 *
 * Note: do not remove the duplicates
 */
public class UniquePair {
    /**
     * HashMap: time: O(n). space: O(n)
     */
    public int twoSum(int[] nums, int target) {
        // 2-pass algorithm
        Map<Integer, Integer> map = new HashMap<>();        // (val, freq)
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // find
        int res1 = 0, res2 = 0;
        for (int key : map.keySet()) {
            int cmp = target - key;
            if (cmp == key && map.get(key) >= 2) {
                res1++;
            }
            if (cmp != key && map.containsKey(cmp)) {
                res2++;
            }
        }
        return res1 + res2 / 2;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        UniquePair up = new UniquePair();
        int[] nums = new int[] {1, 3, 2, 2, 45, 46, 46};
        int target = 4;
        System.out.println(up.twoSum(nums, target));
    }
}
