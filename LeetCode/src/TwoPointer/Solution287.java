package TwoPointer;

import java.util.Arrays;

/**
 * Created by ginolee on 3/24/17.
 */
public class Solution287 {
    public int findDuplicate(int[] nums) {
        if (nums == null) {
            return -1;
        }

        int low = 1, high = nums.length - 1;
        while (low < high) {
            // count the number small than or equal to mid
            int mid = (low + high) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            // if count > mid --> duplicate happened in [1, mid]
            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        Solution287 s = new Solution287();
        System.out.println("\n ----- self-testing");
        int[] nums = {1, 2, 3, 4, 5, 6, 6};
        System.out.println(s.findDuplicate(nums));
    }
}
