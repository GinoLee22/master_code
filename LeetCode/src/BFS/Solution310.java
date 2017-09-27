package BFS;

import java.util.*;

/**
 * Created by ginolee on 7/31/17.
 */
public class Solution310 {
    /**
     * use Topological Sort --> stop criteria: indegree <= 2
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = getGraph(n, edges);
        // find the total indegrees & indregrees corresponds to each index
        int allDegree = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int node : graph.keySet()) {
            allDegree += graph.get(node).size();
            if (graph.get(node).size() == 1) {
                queue.add(node);
            }
        }
        // Topological sort & all degrees
        List<Integer> res = new LinkedList<>();
        while (allDegree > 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curNode = queue.poll();
                int anotherNode = graph.get(curNode).iterator().next();
                graph.get(curNode).remove(anotherNode);
                graph.get(anotherNode).remove(curNode);
                allDegree -= 2;
                if (graph.get(anotherNode).size() == 1) {
                    queue.add(anotherNode);
                }
            }
            res = (LinkedList) queue;
        }
        return res;
    }

    // create a graph using adjacency list
    private Map<Integer, Set<Integer>> getGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}
