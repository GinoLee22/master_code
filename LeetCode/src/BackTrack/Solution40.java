package BackTrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 2/26/17.
 */
public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> curList = new LinkedList<>();
        Arrays.sort(candidates);
        backTrack(output, curList, 0, target, candidates);
        return output;
    }

    // assume the input collection is already sorted
    private void backTrack(List<List<Integer>> output, List<Integer> curList, int start, int sum, int[] nums) {
        // base case 1:
        if (sum < 0) {
            return;
        }
        // base case 2:
        if (sum == 0 && !output.contains(curList)) {
            output.add(new LinkedList(curList));
        }
        // recursion
        for (int i = start; i < nums.length; i++) {
            curList.add(nums[i]);
            backTrack(output, curList, i + 1, sum - nums[i], nums);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution40 s = new Solution40();
        int[] candidate = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(s.combinationSum2(candidate, target));

        System.out.println("\n ----- self-testing of list contain");
        List<List<Integer>> l = new LinkedList<>();
        List<Integer> t1 = new LinkedList<>();
        t1.add(1);
        t1.add(2);
        List<Integer> t2 = new LinkedList<>();
        t2.add(2);
        t2.add(3);
        List<Integer> t3 = new LinkedList<>();
        t3.add(1);
        t3.add(2);
        l.add(t1);
        l.add(t2);
        System.out.println(l.contains(t3));
    }
}
