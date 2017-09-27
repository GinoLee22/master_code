package PriorityQueue;

import java.util.*;

/**
 * Created by ginolee on 9/14/17.
 */
public class Solution215 {
    /**
     * kth largest element -> typical problem of PriorityQueue
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution215 s = new Solution215();
        int[] nums = new int[] {3, 1, 2, 4, 0};
        System.out.println(s.findKthLargest(nums, 2));

    }
}
