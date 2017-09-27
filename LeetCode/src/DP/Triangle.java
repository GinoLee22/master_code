package DP;

/**
 * Created by ginolee on 9/24/17.
 * Problem Description:
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * Example
    Given the following triangle:

    [
    [2],
    [3,4],
    [6,5,7],
    [4,1,8,3]
    ]

    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Triangle {
    public int minimumTotal(int[][] triangle) {
        // corner case
        if (triangle == null || triangle.length == 0 || triangle[0].length == 0) {
            return 0;
        }

        int m = triangle.length, n = triangle[m - 1].length;
        int[][] dp = new int[m][n];
        // initialize
        for (int col = 0; col < n; col++) {
            dp[m - 1][col] = triangle[m - 1][col];
        }
        // dp recursion function
        for (int row = m - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[row][col] = triangle[row][col] + Math.min(dp[row + 1][col], dp[row + 1][col + 1]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Triangle t = new Triangle();
        int[][] triangle = new int[][] {{1}, {2, 3}};
        System.out.println(t.minimumTotal(triangle));
    }
}
