package TwoPointer;

import java.util.Arrays;

/**
 * Created by ginolee on 3/25/17.
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < 2 || nums[i] > nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution80 s = new Solution80();
        System.out.println("\n ----- self-testng");
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3};
        System.out.println(s.removeDuplicates(nums));
    }
}
