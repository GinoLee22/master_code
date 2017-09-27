package LintCode;

/**
 * Created by ginolee on 6/21/17.
 *
 * LintCode 447
 * Given a big sorted array with positive integers sorted by ascending order.
 * The array is so big so that you can not get the length of the whole array directly, and you can only access the kth number by ArrayReader.get(k).
 * ArrayReader.get(k) would return -1 if reach an inaccessible index
 * Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.
 * Return -1, if the number doesn't exist in the array.
 */
public class Solution447 {
    public int searchBigSortedArray(ArrayReader reader, int target) {
        /**
         * idea: use multiplication to find an index k larger than the target
         */
        // find the right bound
        int idx = 1;
        while (ArrayReader.get(idx) != -1 && ArrayReader.get(idx) < target) {
            idx *= 2;
        }
        // normal binary search
        int left = 0, right = idx;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (ArrayReader.get(mid) == target) {
                return mid;
            } else if (ArrayReader.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
