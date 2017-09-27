package BinarySearch;

/**
 * Created by ginolee on 8/28/17.
 */

/**
 * Problem Description
 * Find any position of a target number in a sorted array. Return -1 if target does not exist.
 *
 * Example:
 * Given [1, 2, 2, 4, 5, 5].
 * For target = 2, return 1 or 2.
 * For target = 5, return 4 or 5.
 * For target = 6, return -1.
 */
public class BinarySearchClassic {
    public int findPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

/**
 * Follow up: Search in a Big Array. What if the array has unlimited size?
 * Solution: "Double" method like ArrayList
 * Code:
 * int index = 1;
 * if (reader.get(index - 1) < target) {
 *     index *= 2;
 * }
 * left = 0, right = index
 * ...
 */
