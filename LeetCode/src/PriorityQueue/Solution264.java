package PriorityQueue;

import java.util.*;

/**
 * Created by ginolee on 9/14/17.
 */
public class Solution264 {
    /**
     * idea is very similar to "prime number"
     * 1   2   3   4   5   6   7   8   9 ... 14
     * T   T   T   T   T   T   F             F
     * if isUgly[i] == T -> isUgly[i * 2 || 3 || 5] == T
     * if isUgly[i] == F -> isUgly[i * 2 || 3 || 5] == F
     * However it is difficulty to dynamic processing using an array -> PriorityQueue
     * Note: 1. add an hashtable to check duplications
     *       2. the nth popped out element in priorityqueue is the result
     */
    public int nthUglyNumber(int n) {
        Queue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        pq.add((long) 1);
        set.add((long) 1);
        int[] multies = new int[] {2, 3, 5};
        long res = 1;
        for (int i = 0; i < n; i++) {
            res = pq.poll();
            for (int mult : multies) {
                long newUgly = mult * res;
                if (set.contains(newUgly)) {
                    continue;
                }
                pq.add(newUgly);
                set.add(newUgly);
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution264 s = new Solution264();
        System.out.println(s.nthUglyNumber(10));
    }
}
