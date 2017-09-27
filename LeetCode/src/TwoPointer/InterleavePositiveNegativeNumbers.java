package TwoPointer;

/**
 * Created by ginolee on 8/27/17.
 */

/**
 * Problem Description
 * Given an array with positive and negative integers. Re-range it to interleave with positive and negative integers.
 *
 * Example
 * Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other reasonable answer.
 *
 * Note: any good solution?
 */
public class InterleavePositiveNegativeNumbers {
    /**
     * Assumption: numbers of negative == numbers of positive
     * Idea: 1st: rearrange to negatives (left), positives (right)
     *       2nd: "left" start from idex & "right" start from end -> swap
     */
    public void rerange(int[] A) {
        // 1st
        int left = 0, right = A.length - 1;
        while (left < right) {
            while (left < right && A[left] < 0) {
                left++;
            }
            while (left < right && A[right] > 0) {
                right--;
            }
            // swap
            if (left < right) {
                swap(A, left, right);
                left++;
                right--;
            }
        }
        // 2nd
        int negLen = left  - 0, posLen = A.length - left;
        if (negLen >= posLen) {
            right = left;
            left = 1;
        } else {
            right = left;
            left = 0;
        }
        while (left < right) {
            swap(A, left, right);
            left += 2;
            right++;
        }
    }

    /**
     * swap two values in an array
     */
    private void swap (int[] A, int left, int right) {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }

    public String ArrayToString(int[] nums) {
        String output = "[ ";
        for (int i = 0; i < nums.length; i++) {
            output += nums[i] + " ";
        }
        return output + "]";
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        InterleavePositiveNegativeNumbers ipn = new InterleavePositiveNegativeNumbers();
        int[] A = new int[] {-1, -1, -1, -1, 1, 1, 1, 1, 1};
        ipn.rerange(A);
        System.out.println(ipn.ArrayToString(A));
    }
}
