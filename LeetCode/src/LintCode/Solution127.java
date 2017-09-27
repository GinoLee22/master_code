package LintCode;

import java.util.*;

/**
 * Created by ginolee on 7/25/17.
 */

class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;

    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
};

public class Solution127 {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<>();           // final result to record graph nodes with indegree 0
        Map<DirectedGraphNode, Integer> map = new HashMap<>();          // (K, V): (preference of node, freq)
        Queue<DirectedGraphNode> queue = new LinkedList<>();            // for BFS
        // add all nodes except node with indegree == 0 to hashmap to record its freq
        for (DirectedGraphNode root : graph) {
            for (DirectedGraphNode curNode : root.neighbors) {
                map.put(curNode, map.getOrDefault(curNode, 0) + 1);
            }
        }
        // find out all graph nodes with indegree 0
        for (DirectedGraphNode root : graph) {
            if (!map.containsKey(root)) {
                queue.add(root);
                res.add(root);
            }
        }
        // BFS
        while (!queue.isEmpty()) {
            DirectedGraphNode curNode = queue.poll();
            for (DirectedGraphNode curNeighbor : curNode.neighbors) {
                map.put(curNeighbor, map.get(curNeighbor) - 1);
                if (map.get(curNeighbor) == 0) {
                    queue.add(curNeighbor);
                    res.add(curNeighbor);
                }
            }
        }
        return res;
    }
}
