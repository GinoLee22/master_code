package BFS;

import java.util.*;

/**
 * Created by ginolee on 8/3/17.
 */
public class Solution147 {
    /**
     * really hard problem
     * 1. use BFS to construct a graph. trick: use 2 sets "visited" & "unvisited". Clear "visited" and delete from "unvisited" at each level
     * 2. use DFS to construct the answer: return all search results -> backtrack algorithm
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> graph = getGraph(beginWord, endWord, wordList);
        System.out.println(graph);
        List<String> cur = new LinkedList();
        cur.add(beginWord);
        List<List<String>> res = new LinkedList<>();
        backtrack(graph, beginWord, endWord, cur, res);
        return res;
    }

    // BFS to construct the graph
    private Map<String, Set<String>> getGraph(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> graph = new HashMap<>();
        Set<String> unvisited = new HashSet(wordList), visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curNode = queue.poll();
                // find the endWord
                if (curNode.equals(endWord)) {
                    return graph;
                }
                graph.put(curNode, new HashSet<>());
                // change the word
                for (int m = 0; m < curNode.length(); m++) {
                    char[] strArray = curNode.toCharArray();
                    for (char n = 'a'; n <= 'z'; n++) {
                        strArray[m] = n;
                        String curStr = String.valueOf(strArray);
                        if (!unvisited.contains(curStr) || curStr.equals(beginWord)) {
                            continue;
                        }
                        // contains changed string
                        queue.add(curStr);
                        visited.add(curStr);
                        graph.get(curNode).add(curStr);
                    }
                }
            }
            // after finishing each level: delete "visited" set from "unvisited" set
            unvisited.removeAll(visited);
            visited.clear();
        }
        return graph;
    }

    // backtrack to search all possible solutions
    private void backtrack(Map<String, Set<String>> graph, String curNode, String endWord, List<String> cur, List<List<String>> res) {
        if (curNode.equals(endWord)) {
            res.add(new LinkedList(cur));
            return;
        }
        if (graph.containsKey(curNode)) {
            for (String str : graph.get(curNode)) {
                cur.add(str);
                backtrack(graph, str, endWord, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("self-test of getGraph()");
        Solution147 s = new Solution147();
        String beginWord = "a", endWord = "c";
        List<String> wordList = new LinkedList(Arrays.asList(new String[]{"a", "b", "c"}));
        System.out.println(s.findLadders(beginWord, endWord, wordList));
    }
}
