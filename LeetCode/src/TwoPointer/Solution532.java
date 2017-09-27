package TwoPointer;

import java.util.Arrays;

/**
 * Created by ginolee on 08/24/17.
 */
public class Solution532 {
    /**
     * two-pointer algorithm
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 1 || k < 0) {
            return 0;
        }

        Arrays.sort(nums);
        int left = 0, right = 1, cnt = 0;
        while (left < nums.length - 1 && right < nums.length) {
            if (nums[left] + k == nums[right]) {
                cnt++;
                left++;
                while (left < nums.length - 1 && nums[left] == nums[left - 1]) {
                    left++;
                }
            } else if (nums[left] + k < nums[right]) {
                left++;
            } else {
                right++;
            }
            right = Math.max(right, left + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution532 s = new Solution532();
        System.out.println("\n ----- self-testing");
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 3, 1, 5, 4};
        System.out.println(s.findPairs(nums1, 1));
        System.out.println(s.findPairs(nums2, 0));

    }
}
