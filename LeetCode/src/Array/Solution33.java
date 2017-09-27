package Array;


/**
 * Created by GinoLee on 2017/2/20.
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        // find the index of min value: takes O(lgn)
        int left = 0;
        int right = nums.length - 1;
        // empty array
        if (nums.length == 0) {
            return -1;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // if this array is not rotated
        if (left == 0) {
            return bSearch(nums, 0, nums.length - 1, target);
        }
        // rotated --> partial binary search
        if (target >= nums[0]) {                // only do bSearch at left array
            // left is the minimum index
            return bSearch(nums, 0, left - 1, target);
        } else {
            return bSearch(nums, left, nums.length - 1, target);
        }
    }

    private int bSearch(int[] nums, int left, int right, int target) {
        int mid = (left + right) / 2;
        // base case 1: no target in the array
        while (left > right) {
            return -1;                      // no such value
        }
        if (nums[mid] < target) {
            return bSearch(nums, mid + 1, right, target);
        } else if (nums[mid] > target) {
            return bSearch(nums, left, mid - 1, target);
        } else {        // base case 2:
            return mid;
        }
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution33 s = new Solution33();
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums3 = {};
        int[] nums4 = {1};
        int[] nums5 = {5, 1, 3};
        System.out.println("\n ----- testing for Binary Search");
        System.out.println(s.bSearch(nums2, 0, nums2.length - 1, 6));
        System.out.println(s.search(nums1, 1));
        System.out.println(s.search(nums3, 1));
        System.out.println(s.search(nums4, 1));
        System.out.println(s.search(nums5, 5));

    }
}
