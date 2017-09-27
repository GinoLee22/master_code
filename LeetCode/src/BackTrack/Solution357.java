package BackTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 2/28/17.
 */
public class Solution357 {
    /** at the very beginning, I want to use list to solve this problem based on list.contains() method. But fail because leading zero is hard to cope with
     * so use a counter method to determine the termination
     */
    public int countNumbersWithUniqueDigits(int n) {
        return backTrack(n, 0, new boolean[10]);
    }

    private int backTrack(int numDigit, int index, boolean[] used) {
        // base case:
        if (index == numDigit) {
            return 1;
        }
        int counter = 1;
        // recursion
        for (int i = (index == 0) ? 1 : 0; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                counter += backTrack(numDigit, index + 1, used);
                used[i] = false;
            }
        }
        return counter;
    }


    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution357 s = new Solution357();
        System.out.println(s.countNumbersWithUniqueDigits(0));
        System.out.println(s.countNumbersWithUniqueDigits(1));
        System.out.println(s.countNumbersWithUniqueDigits(2));
        System.out.println(s.countNumbersWithUniqueDigits(3));
        System.out.println(s.countNumbersWithUniqueDigits(4));

    }
}
