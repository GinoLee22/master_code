package BackTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 2/26/17.
 */
public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> curList = new LinkedList<>();
        backTrack(output, curList, 0, nums);
        return output;
    }

    private void backTrack(List<List<Integer>> output, List<Integer> curList, int counter, int[] nums) {
        // base case:
        if (counter == nums.length) {
            output.add(new LinkedList(curList));
        } else {
            // recursion:
            for (int i = 0; i < nums.length; i++) {
                // code with duplicated item, jump to next iteration
                if (curList.contains(nums[i])) {
                    continue;
                }
                curList.add(nums[i]);
                backTrack(output, curList, counter + 1, nums);
                curList.remove(curList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        int[] nums = {1, 2, 3};
        Solution46 s = new Solution46();
        System.out.println(s.permute(nums));
    }
}
