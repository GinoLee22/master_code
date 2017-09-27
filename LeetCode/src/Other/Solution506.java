package Other;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.*;

/**
 * Created by ginolee on 7/14/17.
 */
public class Solution506 {
    /**
     * idea: 1. sort to get relative order. 2. map to get corresponding price. 3. return based on original array
     */
    public String[] findRelativeRanks(int[] nums) {
        // 1st: copy the array nums for ordering without change the original order
        Integer[] copy = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i]= nums[i];
        }
        Arrays.sort(copy, (a, b) -> (b - a));
        // 2nd: map to get corresponding price
        Map<Integer, String> map = new HashMap<>();             // (K, V) -> (score, price in string)
        for (int i = 0; i < copy.length; i++) {
            if (i == 0) {
                map.put(copy[i], "Gold Medal");
            } else if (i == 1) {
                map.put(copy[i], "Silver Medal");
            } else if (i == 2) {
                map.put(copy[i], "Bronze Medal");
            } else {
                map.put(copy[i], i + "");
            }
        }
        // 3rd
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = map.get(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution506 s = new Solution506();
        int[] nums = {3, 4, 5, 2, 1};
        System.out.println(s.findRelativeRanks(nums));
        List<Double> list = new LinkedList<>();
        list.add(3 / (double)2);
    }
}
