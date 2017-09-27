package TwoPointer;

/**
 * Created by ginolee on 3/22/17.
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * i & j are ending indexes of nums1 & nums2
         * stop criteria: one of (i, j) < 0;
         *      if i < 0 --> do nothing
         *      if j < 0 --> adding remaining elts in nums2 into nums1
         */
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    private static String arrayToString(int[] nums) {
        String output = "[ ";
        for (int i = 0; i < nums.length; i++) {
            output += nums[i] + " ";
        }
        return output + "]";
    }

    public static void main(String[] args) {
        Solution88 s = new Solution88();
        System.out.println("\n ----- self-testing");
        int[] nums1 = {4, 6, 8, 10, 0, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {1, 3, 5, 7};
        s.merge(nums1, 4, nums2, 4);
        System.out.println(arrayToString(nums1));

    }
}
