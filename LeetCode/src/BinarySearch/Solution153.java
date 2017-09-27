package BinarySearch;

/**
 * Created by ginolee on 6/9/17.
 */
public class Solution153 {
    public int findMin(int[] nums) {
        /**
         * idea: every dividing --> 1 sorted array + 1 unsorted array (our focus)
         * This is a very special condition! Because when
         */
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // already sorted
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            // unsorted
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left - 1];
    }

    public int pp(int n) {
        return ++n;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing to find the max");
        Solution153 s = new Solution153();
        int[] nums0 = {1};
        int[] nums1 = {3, 1, 2};
        int[] nums2 = {3, 4, 5, 6, 7, 0, 1, 2};
        System.out.println(s.findMin(nums0));
        System.out.println(s.findMin(nums1));
        System.out.println(s.findMin(nums2));

        System.out.println(s.pp(5));
    }
}
