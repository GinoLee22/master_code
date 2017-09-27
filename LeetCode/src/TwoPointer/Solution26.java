package TwoPointer;

import java.util.Arrays;

/**
 * Created by ginolee on 3/25/17.
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        /**
         * 2-pointer --> think it as two different arrays
         */
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index < 1 || nums[i] > nums[index - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
