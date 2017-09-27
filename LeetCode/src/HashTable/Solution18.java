package HashTable;

import java.util.*;

/**
 * Created by ginolee on 5/15/17.
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 1st: sort the array
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        //i: 1st element, j: next, m: next next, n: last
        for (int i = 0; i < nums.length - 3; i++) {
            // remove duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // remove duplicates
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int m = j + 1, n = nums.length - 1;
                while (m < n) {
                    if (nums[i] + nums[j] + nums[m] + nums[n] == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        m++;
                        n--;
                        // remove duplicates
                        while (m < n && nums[m] == nums[m - 1]) {
                            m++;
                        }
                        while (m < n && nums[n] == nums[n + 1]) {
                            n--;
                        }
                    } else if (nums[i] + nums[j] + nums[m] + nums[n] > target) {
                        n--;
                    } else {
                        m++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("/n ----- self-testing");
        Solution18 s = new Solution18();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(s.fourSum(nums, target));

    }
}
