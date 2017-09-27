package DP;

/**
 * Created by ginolee on 9/24/17.
 * Problem Description:
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        // buttom-up dp
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        // initialize buttom & right
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int col = n - 2; col >= 0; col--) {
            dp[m - 1][col] = grid[m - 1][col] + dp[m - 1][col + 1];
        }
        for (int row = m - 2; row >= 0; row--) {
            dp[row][n - 1] = grid[row][n - 1] + dp[row + 1][n - 1];
        }
        // dp construction
        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                dp[row][col] = grid[row][col] + Math.min(dp[row + 1][col], dp[row][col + 1]);
            }
        }
        return dp[0][0];
    }
}
