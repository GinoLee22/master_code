package BackTrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 2/27/17.
 */
public class Solution90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> curList = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrack(output, curList, nums, used, 0);
        List<Integer> empty = new LinkedList<>();
        output.add(empty);
        return output;
    }

    // nums[] should  be sorted. start should be 0. used[] should be false
    private void backTrack(List<List<Integer>> output, List<Integer> curList, int[] nums, boolean[] used, int start) {
        // no base case because every iteration should be added to the output
        for (int i = start; i <nums.length; i++) {
            // cope with duplicated items
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            curList.add(nums[i]);
            output.add(new LinkedList(curList));
            used[i] = true;
            backTrack(output, curList, nums, used, i + 1);
            curList.remove(curList.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println("selft-tesing");
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {1, 2, 2, 2};
        Solution90 s = new Solution90();
        System.out.println(s.subsetsWithDup(nums1));
        System.out.println(s.subsetsWithDup(nums2));
    }
}
