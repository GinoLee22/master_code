package DP;

import java.util.*;

/**
 * Created by ginolee on 9/24/17.
 */
public class Solution354 {
    /**
     * same problem of longest increasing sub-array if sorted
     */
    public int maxEnvelopes(int[][] envelopes) {
        // corner case
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        // sort the array based on 1st element, then 2nd element
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int m = envelopes.length, maxLen = 1;
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(dp[i], maxLen);
                }
            }
        }
        return maxLen;
    }

    public void test() {
        int[][] envelops = new int[][] {{5,4}, {6,4}, {6,7}, {2,3}};
        System.out.println(maxEnvelopes(envelops));
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution354 s = new Solution354();
        s.test();
    }
}
