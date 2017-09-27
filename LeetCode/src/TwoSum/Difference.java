package TwoSum;

/**
 * Created by ginolee on 8/25/17.
 */

import java.util.Arrays;

/**
 * Problem Description
 * Given an array of integers, find two numbers that their difference equals to a target value, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based;
 *
 * Example:
 * Given nums = [2, 7, 15, 24], and target = 5.
 * return [1, 2] (7 - 5 = 2)
 */

class selfClass {
    public int val;
    public int idx;

    // constructor
    public selfClass (int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

public class Difference {
    public int[] twoSumDifference(int[] nums, int target) {
        // construct myself data-structure
        int len = nums.length;
        selfClass[] sc = new selfClass[len];
        for (int i = 0; i < nums.length; i++) {
            sc[i] = new selfClass(nums[i], i);
        }
        // sorting based on "val" field
        Arrays.sort(sc, (a, b) -> (a.val - b.val));

        int left = 0, right = left + 1;
        target = Math.abs(target);
        while (left < nums.length && right < nums.length) {
            if (sc[right].val - sc[left].val == target) {
                return new int[] {sc[left].idx + 1, sc[right].idx + 1};
            } else if (sc[right].val - sc[left].val < target) {
                right++;
            } else {
                left++;
                right = Math.max(left + 1, right);
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Difference d = new Difference();
        int[] nums = new int[] {1, 0, 1};
        int target = 0;
        int[] res = d.twoSumDifference(nums, target);
        for (int i = 0; i < 2; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
