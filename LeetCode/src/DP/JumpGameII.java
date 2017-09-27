package DP;

/**
 * Created by ginolee on 9/24/17.
    Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Your goal is to reach the last index in the minimum number of jumps.

    Example
    Given array A = [2,3,1,1,4]
    The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */

/**
 * Idea: use "Integer.MAX_VALUE" to indicate unreachable
 */
public class JumpGameII {
    public int jump(int[] A) {
        int m = A.length;
        int[] dp = new int[m];
        // construction
        dp[0] = 0;
        for (int i = 1; i < m; i++) {
            dp[i] = Integer.MAX_VALUE;              // initialize
            for (int j = 0; j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[m - 1];
    }

    public void test() {
        int[] A = new int[] {2, 3, 1, 1, 4};
        System.out.println(jump(A));
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        JumpGameII jg2 = new JumpGameII();
        jg2.test();
    }
}
