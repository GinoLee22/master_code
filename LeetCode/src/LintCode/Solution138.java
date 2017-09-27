package LintCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ginolee on 6/14/17.
 */
public class Solution138 {
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here

        int len = nums.length;

        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                ans.add(map.get(sum) + 1);
                ans.add(i);
                return ans;
            }

            map.put(sum, i);
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution138 s = new Solution138();
        int[] nums = {-3, 1, 2, -3, 4};
        System.out.println(s.subarraySum(nums));


    }
}
