package TwoPointer;

/**
 * Created by ginolee on 7/18/17.
 */
public class Solution633 {
    /**
     * any problem that has a target 'c' (in this case) && 2 other elements, can use 2-pointer
     */
    public boolean judgeSquareSum(int c) {
        int start = 1, end = (int) Math.sqrt(c);
        while (start <= end) {          // equal because 8 = 2^2 + 2^2
            if (start * start + end * end < c) {
                start++;
            } else if (start * start + end * end > c) {
                end--;
            } else {                    // equal exactly
                return true;
            }
        }
        return false;
    }
}
