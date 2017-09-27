package BinarySearch;

/**
 * Created by ginolee on 8/15/17.
 */
public class Solution367 {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("self-testing of overflow");
        Solution367 s = new Solution367();
        s.isPerfectSquare(Integer.MAX_VALUE);
    }
}
