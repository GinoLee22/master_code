package BinarySearch;

import java.util.*;

/**
 * Created by ginolee on 6/7/17.
 */

public class Solution436 {
    public int[] findRightInterval(Interval[] intervals) {
        /**
         * idea:
         * Brute force --> take O(n^2)
         * To optimize --> binary search based on start interval, so need to sort it based on start interval
         */
        // 1st step: fill the hashmap
        Map<Integer, Integer> startsMap = new HashMap<>();      // (K,V): (start interval, origin index)
        for (int i = 0; i < intervals.length; i++) {
            startsMap.put(intervals[i].start, i);
        }
        // 2nd step: sort origin "intervals"
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        // 3rd step: binary search
        int[] result = new int[intervals.length];
        for (Interval i : intervals) {
            int curEnd = i.end;
            int idx = binarySearch(intervals, curEnd);
            if (idx < intervals.length) {
                result[startsMap.get(i.start)] = startsMap.get(intervals[idx].start);
            } else {
                result[startsMap.get(i.start)] = -1;
            }
        }
        return result;
    }

    /**
     * interface: 2 inputs: sorted intervals, minimun start
     * return the index of smallest start point larger than minimum start
     * Note: the index can equal to the length of array --> should be considered as -1 in this problem
     * eg1: [1 3 5 7], minStart = 3 (should be strictly larger than 3), should return index 2 with value 5
     */
    private int binarySearch(Interval[] intervals, int minStart) {
        int left = 0, right = intervals.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid].start < minStart) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;                // Note here: left should be in range of [0, length]
    }
}
