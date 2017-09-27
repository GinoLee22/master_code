package BackTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 2/27/17.
 */
public class Solution77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> curList = new LinkedList<>();
        backTrack(output, curList, k, n, 1);
        return output;
    }

    private void backTrack(List<List<Integer>> output, List<Integer> curList, int length, int bound, int start) {
        // base case:
        if (curList.size() == length) {
            output.add(new LinkedList(curList));
        } else {
            // recursion:
            for (int i = start; i <= bound; i++) {      // initially: this start should equal to 1
                curList.add(i);
                backTrack(output, curList, length, bound, i + 1);
                curList.remove(curList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution77 s = new Solution77();
        System.out.println(s.combine(4, 2));
    }
}
