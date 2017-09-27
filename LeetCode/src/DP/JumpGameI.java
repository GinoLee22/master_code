package DP;

/**
 * Created by ginolee on 9/24/17.
 * Problem Description:
 *
    Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Determine if you are able to reach the last index.

    Example
    A = [2,3,1,1,4], return true.
    A = [3,2,1,0,4], return false.
 */
public class JumpGameI {
    public boolean canJump(int[] A) {
        int m = A.length;
        boolean[] dp = new boolean[m];
        dp[0] = true;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + A[j] >= i) {
                    dp[i] = true;
                }
            }
        }
        return dp[m - 1];
    }
}
