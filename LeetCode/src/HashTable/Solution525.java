package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ginolee on 7/24/17.
 */
public class Solution525 {
    /**
     * 2 pointer + hashmap
     */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();         // (K, V): (0/1, freq)
        int start = 0, end = 0, res = 0;
        while (end < nums.length) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            end++;
            if (map.size() < 2) {
                continue;
            }
            while (Math.abs(map.get(0) - map.get(1)) > 1 && start < nums.length) {
                map.put(nums[start], map.get(nums[start]) - 1);
                start++;
            }
            res = Math.max(res, 2 * Math.min(map.get(0), map.get(1)));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution525 s = new Solution525();
        int[] nums = {0, 1, 1, 0,0};
        System.out.println(s.findMaxLength(nums));
    }
}
