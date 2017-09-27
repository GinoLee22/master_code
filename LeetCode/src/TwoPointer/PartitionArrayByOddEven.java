package TwoPointer;

/**
 * Created by ginolee on 8/27/17.
 */

/**
 * Problem Description
 * Partition an integer array into odd numbers first and even numbers second.
 *
 * Example:
 * nums = [1, 2, 3, 4]. return [1, 3, 2, 4]
 */

public class PartitionArrayByOddEven {
    /**
     * Idea: left keep track of elements are odd & right keep track of elements are even
     */
    public void partitionArray(int[] nums) {
        // corner case
        if (nums == null || nums.length < 2) {
            return;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            // swap
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public String ArrayToString(int[] nums) {
        String output = "[ ";
        for (int i = 0; i < nums.length; i++) {
            output += nums[i] + " ";
        }
        return output + "]";
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        PartitionArrayByOddEven paoe = new PartitionArrayByOddEven();
        int[] nums = new int[] {1, 2, 3, 4};
        paoe.partitionArray(nums);
        System.out.println(paoe.ArrayToString(nums));
    }
}
