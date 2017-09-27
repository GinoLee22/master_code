package HashTable;

import java.util.*;

/**
 * Created by ginolee on 2/23/17.
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // actually the same as Method 2 in #349 except no need to skip duplicate
        int[] result = new int[(nums1.length > nums2.length) ? nums1.length : nums2.length];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0, idx = 0;        // use idx to record the position of intersection
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {        // they are equal
                result[idx] = nums1[p1];
                idx++;
                p1++;
                p2++;
            }
        }
        return Arrays.copyOfRange(result, 0, idx);          // not include idx
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Solution350 s = new Solution350();
        int[] output = s.intersect(nums1, nums2);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

}
