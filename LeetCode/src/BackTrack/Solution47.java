package BackTrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 2/26/17.
 */
public class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> curList = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrack(output, curList, nums, used);
        return output;
    }

    // interface: int[] nums is already sorted, boolean[] used: initially is [false, false, false]
    private void backTrack(List<List<Integer>> output, List<Integer> curList, int[] nums, boolean[] used) {
        // base case:
        if (curList.size() == nums.length) {
            output.add(new LinkedList(curList));
        } else {
            // recursion
            for (int i = 0; i < nums.length; i++) {
                // can only use once: the final !used[i - 1] is to ensure the starting point is not index 0;
                if (used[i] == true || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                curList.add(nums[i]);
                used[i] = true;
                // backTrack method
                backTrack(output, curList, nums, used);
                curList.remove(curList.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution47 s = new Solution47();
        int[] nums = {1, 1, 2};
        System.out.println(s.permuteUnique(nums));
    }
}
