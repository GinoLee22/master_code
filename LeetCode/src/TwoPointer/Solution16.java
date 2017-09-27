package TwoPointer;

import java.util.Arrays;

/**
 * Created by ginolee on 3/26/17.
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        /**
         * key idea: find the closest sum --> there must be a result
         * so what we do here --> check each result with the previous one
         */
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
                // every time, check if it is necessary to update the result
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution16 s = new Solution16();
        System.out.println("\n ----- self-testing");
        int[] nums = {0, 1, 2, 5, 9};
        int target = 9;
        System.out.println(s.threeSumClosest(nums, target));
    }
}
