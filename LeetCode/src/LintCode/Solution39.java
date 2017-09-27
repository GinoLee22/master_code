package LintCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ginolee on 6/5/17.
 */
public class Solution39 {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        /**
         * idea: 3 steps convert
         * 1. find the edge
         * 2. convert each array
         * 3. concatenate & convert the entire one
         * Pay Attention to corner case: already sorted list
         */

        // 1st step: finally the start becomes the end idx of sorted half
        int cut = 0;
        while (cut < nums.size() - 1 && nums.get(cut) <= nums.get(cut + 1)) {
            cut++;
        }
        // corner case: it is already sorted
        if (cut == nums.size() - 1) {
            return;
        }
        // 2nd step: convert the first half & convert the other
        convertArrayList(nums, 0, cut);
        convertArrayList(nums, cut + 1, nums.size() - 1);
        // 3rd step: convert it entirely
        convertArrayList(nums, 0, nums.size() - 1);
    }

    private void convertArrayList(ArrayList<Integer> nums, int startIdx, int endIdx) {
        for (int start = startIdx, end = endIdx; start < end; start++, end--) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
        }
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution39 s = new Solution39();
        System.out.println("Rotated Sorted Array");
        ArrayList aList = new ArrayList(0);
        aList.add(4);
        aList.add(5);
        aList.add(1);
        aList.add(2);
        aList.add(3);
        System.out.println(aList);
        System.out.println("Recovered Sorted Array");
        s.recoverRotatedSortedArray(aList);
        System.out.println(aList);
    }
}
