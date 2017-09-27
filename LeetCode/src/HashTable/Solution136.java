package HashTable;

import num1.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ginolee on 2/28/17.
 */
public class Solution136 {
    // hashtable method
//    public int singleNumber(int[] nums) {
//        // create the hashmap
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i : nums) {
//            if (!map.containsKey(i)) {
//                map.put(i, 0);
//            }
//            map.put(i, map.get(i) + 1);
//        }
//        // find the counter with only 1
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 1) {
//                return entry.getKey();
//            }
//        }
//        return -1;          // not gonna happening
//    }

    // smart solution

    public int singleNumber(int[] nums) {
        // use 2 properties of XOR: 1. N ^ N = 0 & 0 ^ N = N. 2. commutative
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution136 s = new Solution136();
        int[] nums1 = {1, 2, 2, 3, 3, 4, 4, 5, 5};
        int[] nums2 = {1, 1, 2, 2, 3, 4, 4, 5, 5};
        System.out.println(s.singleNumber(nums1));
        System.out.println(s.singleNumber(nums2));
    }

}
