package HashTable;

import java.util.*;

/**
 * Created by ginolee on 7/7/17.
 */
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

public class Solution130 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // corner case
        if (node == null) {
            return null;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();          // queue to hold original nodes
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();        // original nodes --> new created nodes
        queue.add(node);
        map.put(node.label, new UndirectedGraphNode(node.label));
        // BFS
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    map.put(cur.label, new UndirectedGraphNode(cur.label));
                    queue.add(neighbor);
                }
                map.get(cur.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return map.get(node.label);
    }
}
