package DP;

import java.util.*;

/**
 * Created by ginolee on 9/24/17.
 */
public class Solution403 {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int m = stones.length;
        // initialize the 1st element
        map.put(stones[0], new HashSet<>());
        map.get(stones[0]).add(0);
        for (int i = 1; i < m; i++) {
            map.put(stones[i], new HashSet<>());
            for (int key : map.keySet()) {
                for (int steps : map.get(key)) {
                    // k - 1, k, k + 1 steps
                    if (steps - 1 > 0 && stones[i] == key + steps - 1) {
                        map.get(stones[i]).add(steps - 1);
                    }
                    if (stones[i] == key + steps) {
                        map.get(stones[i]).add(steps);
                    }
                    if (stones[i] == key + steps + 1) {
                        map.get(stones[i]).add((steps + 1));
                    }
                }
            }
        }
        System.out.println(map);
        return map.get(stones[m - 1]).size() != 0;
    }

    public void test() {
        int[] stones1 = new int[] {0, 1, 3, 5, 6, 8, 12, 17};
        int[] stones2 = new int[] {0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(canCross(stones1));
        System.out.println(canCross(stones2));
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution403 s = new Solution403();
        s.test();
    }
}
