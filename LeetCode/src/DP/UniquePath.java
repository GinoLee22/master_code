package DP;

/**
 * Created by ginolee on 9/24/17.
 * Problem Description:
 * A robot is located at the top-left corner of a m x n grid.
   The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
   How many possible unique paths are there?

   Example
   Given m = 3 and n = 3, return 6.
   Given m = 4 and n = 5, return 35.

 */
public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // initialize the top & left
        for (int col = 0; col < n; col++) {
            dp[m - 1][col] = 1;
        }
        for (int row = 0; row < m; row++) {
            dp[row][n - 1] = 1;
        }
        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                dp[row][col] = dp[row + 1][col] + dp[row][col + 1];
            }
        }
        return dp[0][0];
    }
}
