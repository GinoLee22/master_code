package BackTrack;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 2/27/17.
 */
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> curList = new LinkedList<>();
        backTrack(output, curList, nums, 0);
        List<Integer> empty = new LinkedList<>();
        output.add(empty);
        return output;
    }

    // interface: the nums[] is already sorted
    private void backTrack(List<List<Integer>> output, List<Integer> curList, int[] nums, int start) {
        // base case:
        if (start == nums.length) {
            return;
        } else {
            // recursion
            for (int i = start; i < nums.length; i++) {
                if (curList.contains(nums[i])) {
                    continue;
                }
                curList.add(nums[i]);
                output.add(new LinkedList(curList));
                backTrack(output, curList, nums, i + 1);
                curList.remove(curList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution78 s = new Solution78();
        int[] nums = {1, 2, 3};
        System.out.println(s.subsets(nums));
    }
}
