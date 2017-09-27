package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ginolee on 3/18/17.
 */
public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();        // key: nums[i] --> value: index
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                // have duplicate number
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            // always update because when have the same key but length larger than k --> have to check next with current
            // eg: [1 0 1 1]. procedure: [(1, 0), (0, 1)] --> [(1,2), (0, 1)]
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution219 s = new Solution219();
        System.out.println("self-testing");
        int[] nums1 = {1, 2, 3, 4, 5, 1};
        int[] nums2 = {1, 0, 1, 1};
        int k = 1;
        System.out.println(s.containsNearbyDuplicate(nums1, k));
        System.out.println(s.containsNearbyDuplicate(nums2, k));


    }
}
