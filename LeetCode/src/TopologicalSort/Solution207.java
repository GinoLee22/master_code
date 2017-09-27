package TopologicalSort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ginolee on 6/29/17.
 */
public class Solution207 {
    /**
     * topological sort using BFS
     * 1. Create adjacency matrix && record the indegree
     * 2. add all 0 indegree into a queue
     * 3. reduce the indegree one by one
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1st step: create adjacency matrix && indegree
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1], next = prerequisites[i][0];
            if (matrix[pre][next] == 0) {
                indegree[next]++;           // this is to handle duplicate pairs
            }
            matrix[pre][next] = 1;
        }
        // 2nd step: add to a queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        // 3rd step: reduce the indegree of each index --> if (count < numCourses) --> have circles
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int course = queue.poll();
            // reduce of the indegrees this couse associated with
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] == 1) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution207 s = new Solution207();
        int numCourses = 2;
        int[][] prerequisites = new int[][] {{1, 0}, {0, 1}};
        System.out.println(s.canFinish(numCourses, prerequisites));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 1);
    }
}
