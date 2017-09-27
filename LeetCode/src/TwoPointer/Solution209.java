package TwoPointer;

import num1.Solution;

/**
 * Created by ginolee on 3/25/17.
 */
public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0, fast = 0, min = Integer.MAX_VALUE, sum = 0;
        while (fast < nums.length) {
            sum += nums[fast];
            fast++;
            while (sum >= s) {
                min = Math.min(min, fast - slow);
                sum -= nums[slow];
                slow++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        Solution209 s = new Solution209();
        System.out.println("\n ----- self-testing");
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(s.minSubArrayLen(7, nums));
    }
}
