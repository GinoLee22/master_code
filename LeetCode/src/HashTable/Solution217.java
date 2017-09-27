package HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ginolee on 3/18/17.
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {            // set.add(int) --> return true if adding is possible & false already exist
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution217 s = new Solution217();
        System.out.println("self-testing");
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 3, 4, 5, 1};
        System.out.println(s.containsDuplicate(nums1));
        System.out.println(s.containsDuplicate(nums2));


    }
}
