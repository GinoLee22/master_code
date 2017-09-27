package BinarySearch;

/**
 * Created by ginolee on 8/15/17.
 */
public class Solution440 {
    public int arrangeCoins(int n) {
        int left = 1, right = n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long curSum = (mid + 1) * mid / 2;
            if (curSum == n) {
                return (int) mid;
            } else if (curSum < n) {
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }
}
