package HashTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ginolee on 2/23/17.
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // /**
        //  * Method 1: HashSet method: if proper hash function is used, all operations are in O(1)
        //  **/
        // Set<Integer> set = new HashSet<>();
        // Set<Integer> intersection = new HashSet<>();
        // for (int num : nums1) {
        //     set.add(num);
        // }
        // for (int num : nums2) {
        //     if (set.contains(num)) {        // this operation takes O(1). So necessary to use HashSet. Direct comparison takes O(n)
        //         intersection.add(num);
        //     }
        // }
        // // change to array for interface
        // int[] result = new int[intersection.size()];
        // int idx = 0;
        // for (int num : intersection) {
        //     result[idx] = num;
        //     idx++;
        // }
        // return result;

        /**
         * Method 2: sort each array * 2-pointer (this method is much faster, about 50%. WHY?)
         **/
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
                while (p1 < nums1.length && nums1[p1] == nums1[p1 - 1]) {       // skip the duplicate
                    p1++;
                }
                while (p2 < nums2.length && nums2[p2] == nums2[p2 - 1]) {
                    p2++;
                }
            }
        }
        return Arrays.copyOfRange(result, 0, idx);          // not include idx
    }

    public static void main(String[] args) {
        System.out.println("self-testing of set");
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(0);
        set.add(100);
        System.out.println(set.toString());

        for (int elt : set) {
            System.out.println(elt);
        }

        System.out.println("self-testing");
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Solution349 s = new Solution349();
        int[] output = s.intersection(nums1, nums2);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
}
