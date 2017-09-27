package TwoPointer;

/**
 * Created by ginolee on 8/27/17.
 */

/**
 * Problem Description
 * Given an array nums of integers and an int k, partition the array (i.e. move the elements in nums) such that
 *      All elements < k are moved to the left
 *      All elements >= k are moved to the right
 * Return the partition index, the first index i s.t. nums[i] >= k
 *
 *
 * Example:
 * nums = [3, 2, 2, 1], and k = 2. A valid answer is 1
 */

public class PartitionArrayByValue {
    /**
     * Idea: left always keep track of elements < k and right always keep track >= k
     * left to find the first pointer >= k, right to find the first pointer < k. Then swap.
     * Invariant -> nums[left] < k && nums[right] >= k
     */
    public int PartitionArray(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] < k) {
                left++;
            }
            while (left < right && nums[right] >= k) {
                right--;
            }
            // swap
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        // find index
        return left;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        PartitionArrayByValue pa = new PartitionArrayByValue();
        int[] nums = new int[] {3, 2, 2, 1};
        int k = 2;
        System.out.println(pa.PartitionArray(nums, k));
    }
}
