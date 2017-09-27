package BinarySearch;

/**
 * Created by ginolee on 8/28/17.
 */

/**
 * Problem description
 * Given array is in shape of mountain, find the maximum value
 *
 * Example:
 * [1 2 3 4 2 1]. return 4
 */
public class MaximumNumberMountainSequence {
    /**
     * To avoid corner cases like [1 2 3 4 5] -> start from 1 and length - 2
     */
    public int findMax(int[] nums) {
        // corner case
        if (nums.length <= 1) {
            return nums[0];
        }
        int left = 1, right = nums.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        MaximumNumberMountainSequence mnms = new MaximumNumberMountainSequence();
        int[] nums = new int[] {1, 2, 3, 4, 2, 1};
        System.out.println(mnms.findMax(nums));
    }
}
