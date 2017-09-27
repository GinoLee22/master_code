package DP;

/**
 * Created by ginolee on 7/14/17.
 */
public class Solution264 {
    /**
     * DP --> recursion expression
     * dp[0] = 1
     * dp[1] = min(dp[0] * 2, dp[0] * 3, dp[0] * 5) --> dp[1] = dp[0] * 2 --> next value must > dp[0] * 2 --> dp[1] * 2
     * dp[2] = min(dp[1] * 2, dp[0] * 3, dp[0] * 5) --> dp[2] = dp[0] * 3 --> next value must > dp[0] * 3 --> dp[1] * 3
     * dp[3] = min(dp[1] * 2, dp[1] * 3, dp[0] * 5)
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[idx2] * 2, Math.min(dp[idx3] * 3, dp[idx5] * 5));
            if (dp[i] == dp[idx2] * 2) {
                idx2++;
            }
            if (dp[i] == dp[idx3] * 3) {
                idx3++;
            }
            if (dp[i] == dp[idx5] * 5) {
                idx5++;
            }
        }
        return dp[n - 1];
    }
}
