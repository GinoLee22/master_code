package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ginolee on 3/21/17.
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        /**
         * one pass solution
         */
        Map <Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {i, map.get(complement)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};

        /**
         * 2 pass solution
         */
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement) && map.get(complement) != i) {
//                return new int[] {i, map.get(complement)};
//            }
//        }
//        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        System.out.println("\n ---------- Self-Testing");
        System.out.println("\n ---------- 1st test:");
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        Solution1 s = new Solution1();
        int[] result1 = s.twoSum(nums1, target1);
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }

        System.out.println("\n ---------- 2nd test:");
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = s.twoSum(nums2, target2);
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }

        System.out.println("\n ---------- 3rd test:");
        int[] nums3 = {2, 7, 2, 2, 5};
        int target3 = 4;
        int[] result3 = s.twoSum(nums3, target3);
        for (int i = 0; i < result3.length; i++) {
            System.out.print(result3[i] + " ");
        }
    }
}
