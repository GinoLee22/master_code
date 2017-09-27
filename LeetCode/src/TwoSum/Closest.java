package TwoSum;

/**
 * Created by ginolee on 8/25/17.
 */

import java.util.Arrays;

/**
 * Problem Description
 * Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.
 * Return the difference between the sum and the target.
 *
 * Example:
 * Given array, nums = [-1, 2, 1, -4], and target = 4
 * The minimum difference is 1. (4 - (2 + 1) = 1)
 */
public class Closest {
    public int twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, res = Integer.MAX_VALUE;
        while (left < right) {
            int sum = nums[left] + nums[right];
            res = Math.min(res, Math.abs(target - sum));
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Closest c = new Closest();
        int[] nums = new int[] {-1, 2, 1, -4};
        int target = 4;
        System.out.println(c.twoSumClosest(nums, target));
    }
}
