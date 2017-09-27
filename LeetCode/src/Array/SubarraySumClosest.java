package Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ginolee on 9/26/17.
 */
class Pair {
    int val;
    int idx;

    public Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

public class SubarraySumClosest {
    public int[] subarraySumCloset(int[] nums) {
        int len = nums.length;
        Pair[] pairs = new Pair[len];
        for (int i = 0; i < len; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val > o2.val) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int[] res = new int[2];
        int cls = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            int curDif = Math.abs(pairs[i].val + pairs[i - 1].val);
            System.out.println(curDif);
            if (curDif < cls) {
                cls = curDif;
                res[0] = Math.min(pairs[i - 1].idx, pairs[i].idx);
                res[1] = Math.max(pairs[i - 1].idx, pairs[i].idx);
            }
        }
        return res;
    }

    public void test() {
        int[] nums = new int[] {-3, 1, 1, -3, 5};
        int[] res = subarraySumCloset(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        SubarraySumClosest sasc = new SubarraySumClosest();
        sasc.test();
        System.out.println(4 / Integer.MIN_VALUE);
    }
}
