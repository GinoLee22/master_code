package TwoSum;

/**
 * Created by ginolee on 8/25/17.
 */

import java.util.Arrays;

/**
 * Problem Description
 * Given an array of integers, how many three numbers can be found in the array
 * so that we can build a triangle whose three edges length is the three numbers that we find?
 *
 * Example:
 * Given array S = [3, 4, 6, 7] return 3. They are
 * [3, 4, 6], [3, 6, 7], [4, 6, 7]
 * Given array S= [4, 4, 4, 4] return 4. They are
 * [4(1), 4(2), 4(3)], [4(1), 4(2), 4(4)], [4(1), 4(3), 4(4)], [4(1), 4(3), 4(4)]
 */
public class TriangleCount {
    /**
     * thought: pin one of the numbers, then select the rest two -> typical two-pointer
     */
    public int triangleCount(int S[]) {
        Arrays.sort(S);
        int res = 0;
        for (int i = 2; i < S.length; i++) {
            int left = 0, right = i - 1;
            // valid construction: a <= b <= c --> a + b > c
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        TriangleCount tc = new TriangleCount();
//        int[] S = new int[] {3, 4, 6, 7};
        int[] S = new int[] {4, 4, 4, 4};
        System.out.println(tc.triangleCount(S));
    }
}
