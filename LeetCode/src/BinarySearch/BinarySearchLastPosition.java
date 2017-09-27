package BinarySearch;

/**
 * Created by ginolee on 8/28/17.
 */

/**
 * For a given sorted array (ascending order) and a target number, find the last index of this number in O(log n) time complexity.
 * If the target number does not exist in the array, return -1.
 * <p>
 * Example:
 * If the array is [1, 2, 2, 4, 5, 5].
 * For given target 2, return 2.
 * For given target 5, return 5.
 */
public class BinarySearchLastPosition {
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {          // there is 2 cases: left == right OR left + 1 == right
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[right] == target) {
            return right;
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        BinarySearchLastPosition bslp = new BinarySearchLastPosition();
        int[] nums = new int[]{1, 2, 2, 4, 5, 5};
        int target = 5;
        System.out.println(bslp.binarySearch(nums, target));

    }
}
