package BackTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 2/24/17.
 */
public class Solution39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> currentList = new LinkedList<>();
        backTrack(output, currentList, target, 0, candidates);
        return output;
    }

    private void backTrack(List<List<Integer>> output, List<Integer> currentList, int remain, int start, int[] nums) {
        // base case 1:
        if (remain < 0) {
            return;
        }
        // base case 2:
        if (remain == 0) {
            output.add(new LinkedList<>(currentList));
        }
        // recursion:
        for (int i = start; i < nums.length; i++) {
            currentList.add(nums[i]);
            backTrack(output, currentList, remain - nums[i], i, nums);
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        int[] candidates = {2, 6, 3, 7};
        int target = 7;
        Solution39 s = new Solution39();
        System.out.println(s.combinationSum(candidates, target));
    }
}
