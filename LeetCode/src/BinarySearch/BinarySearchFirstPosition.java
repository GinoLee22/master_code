package BinarySearch;

/**
 * Created by ginolee on 8/28/17.
 */

/**
 * For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
 * If the target number does not exist in the array, return -1.
 *
 * Example:
 * If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 */
public class BinarySearchFirstPosition {
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] == target) {     // both left & right are OK because left == right
            return left;
        }
        return -1;
    }
}
