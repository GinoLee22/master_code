package LintCode;

/**
 * Created by ginolee on 6/19/17.
 */
public class Solution458 {
    public int lastPostion(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {                        // equal
                left = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        } else if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution458 s = new Solution458();
        int[] nums = {1, 2, 2, 4, 5, 5};
        int target1 = 2, target2 = 6, target3 = 5;
        System.out.println(s.lastPostion(nums, target1));
        System.out.println(s.lastPostion(nums, target2));
        System.out.println(s.lastPostion(nums, target3));
    }
}
