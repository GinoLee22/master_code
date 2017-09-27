package UnionFind;

import java.util.*;

/**
 * Created by ginolee on 8/22/17.
 */
public class Solution128 {
    private int[] father;
    private int[] size;
    private int max;

    public void initialize(int n) {
        father = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
            size[i] = 1;
        }
        max = 0;
    }

    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }

    // routine: a -> b
    public void union(int a, int b) {
        int roota = find(a);
        int rootb = find(b);
        if (roota != rootb) {
            father[roota] = rootb;
            size[rootb] += size[roota];
            max = Math.max(max, size[rootb]);
        }
    }

    public int longestConsecutive(int[] nums) {
        // initialize UnionFind
        initialize(nums.length);

        Map<Integer, Integer> map = new HashMap<>();        // (value, index)
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            map.put(nums[i], i);
            // check "n - 1" & "n + 1"
            int small = nums[i] - 1;
            if (map.containsKey(small)) {
                union(i, map.get(small));
            }
            int large = nums[i] + 1;
            if (map.containsKey(large)) {
                union(i, map.get(large));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution128 s = new Solution128();
        int[] nums = new int[] {100, 4, 200, 1, 3, 2};
        System.out.println(s.longestConsecutive(nums));
    }
}
