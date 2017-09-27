package BackTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 2/27/17.
 */
public class Solution216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> curList = new LinkedList<>();
        backTrack(output, curList, k, n, 1);
        return output;
    }

    // start: initially should be 1
    private void backTrack(List<List<Integer>> output, List<Integer> curList, int counter, int sum, int start) {
        // base case:
        if (curList.size() == counter && sum == 0) {
            output.add(new LinkedList(curList));
        } else {
            // recursion
            for (int i = start; i <= 9; i++) {
                curList.add(i);
                backTrack(output, curList, counter, sum - i, i + 1);
                curList.remove(curList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution216 s = new Solution216();
        System.out.println(s.combinationSum3(3, 7));
        System.out.println(s.combinationSum3(3, 9));
    }
}
