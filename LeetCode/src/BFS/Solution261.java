package BFS;

import java.util.*;

/**
 * Created by ginolee on 7/28/17.
 */
public class Solution261 {
    /**
     * idea: 1. judgement: edges of tree == number of nodes - 1
     2. use BFS to find one union --> size == n --> true. Otherwise, false
     */
    public boolean validTree(int n, int[][] edges) {
        // corner case
        if (edges == null || edges.length != n - 1) {
            return false;
        }

        Map<Integer, Set<Integer>> graph = getGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            for (int neighbor : graph.get(curNode)) {
                queue.add(neighbor);
                set.add(neighbor);
            }
        }
        return set.size() == n;
    }

    // create a graph based on edges
    private Map<Integer, Set<Integer>> getGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}
