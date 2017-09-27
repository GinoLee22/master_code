package DP;

import Array.Solution56;

/**
 * Created by ginolee on 7/14/17.
 */
public class Solution132 {
    /**
     * DP graphical illustration
     */
    public int minCut(String s) {
        // initialization
        int[] dp = new int[s.length() + 1];
        dp[0] = -1;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // get the isPalindrome matrix for optimization
        boolean[][] palindrome = isPalindrome(s);
        // dp recursion: dp[i] = min(dp[j] + 1) where j = 0 ~ i (inclusive & j means: previous j characters)
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (palindrome[j][i - 1]) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[s.length()];
    }

    // DP idea as well Graphical illustration
    private boolean[][] isPalindrome(String s) {
        // initialize the diagonal: i == j
        boolean[][] result = new boolean[s.length()][s.length()];
        char[] sArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            result[i][i] = true;
        }
        // dp recursion: sArray[i] == sArray[j] && (i + 1 > j - 1 || isPalindrome(i + 1, j - 1))
        for (int row = s.length() - 2; row >= 0; row--) {
            for (int col = s.length() - 1; col > row; col--) {
                if (sArray[row] == sArray[col] && (row + 1 > col - 1 || result[row + 1][col - 1])) {
                    result[row][col] = true;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        System.out.println(Math.pow(3, 19));
        System.out.println(Integer.MAX_VALUE);
    }
}
