package TwoPointer;
import java.util.*;

/**
 * Created by ginolee on 5/15/17.
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 1st: sort this array
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        // i: 1st element, j: next element, k: last element
        for (int i = 0; i < nums.length - 2; i++) {
            // remove duplicate items
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    k--;
                    j++;
                    // remove duplicates
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("\n ---------- Self-Testing");
        Solution15 s = new Solution15();
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(s.threeSum(nums1));
        int[] nums2 = {-2, 0, 1, 1, 2};
        System.out.println(s.threeSum(nums2));

    }

}
