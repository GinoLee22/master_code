package test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 9/3/17.
 */
public class FindMode {
    public List<Integer> mode(int[] nums) {
        int count = 1, freq = 1;
        List<Integer> res = new LinkedList<>();
        res.add(nums[0]);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                count = 1;
            } else {
                count++;
                if (count > freq) {
                    freq = count;
                    res.clear();
                    res.add(nums[i]);
                } else if (count == freq) {
                    res.add(nums[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("self-test");
        FindMode fm = new FindMode();
        int[] nums = new int[] {1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3};
        System.out.println(fm.mode(nums));
    }
}
