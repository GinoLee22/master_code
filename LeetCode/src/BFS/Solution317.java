package BFS;

import javax.xml.bind.SchemaOutputResolver;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ginolee on 7/29/17.
 */
public class Solution317 {
    /**
     * idea: BFS to add all 0s and record a level num. When cames to 1, add to total distance. When 2, skip it
     * implement: need a "visited" hashmap to record the visied node.
     check every node on the graph
     */
    private static int EMPTY = 0;
    private static int BUILDING = 1;
    private static int OBSTACLE = 2;

    public int shortestDistance(int[][] grid) {
        int res = Integer.MAX_VALUE;
        // corner case
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int numBuilding = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == BUILDING) {
                    numBuilding++;
                }
            }
        }

        int[][] visitedNum = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == EMPTY) {
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    int curDist = bfsDist(grid, row, col, visited, visitedNum);
                    if (visitedNum[row][col] == numBuilding && curDist < res) {
                        res = curDist;
                    }
                }
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    // only when grid[row][col] == '0', trigger this method
    private int bfsDist(int[][] grid, int row, int col, boolean[][] visited, int[][] visitedNum) {
        int dist = 0, level = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        visited[row][col] = true;
        // create a direction order using loop: up -> right -> down -> left
        int[] deltRow = new int[] {-1, 0, 1, 0}, deltCol = new int[] {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int curRow = curPos[0] + deltRow[j], curCol = curPos[1] + deltCol[j];
                    // exception for out of index
                    if (curRow < 0 || curRow >= grid.length || curCol < 0 || curCol >= grid[curRow].length || visited[curRow][curCol]) {
                        continue;
                    }
                    if (grid[curRow][curCol] == OBSTACLE) {
                        continue;
                    } else if (grid[curRow][curCol] == BUILDING) {
                        visitedNum[row][col]++;
                        dist += level;
                        visited[curRow][curCol] = true;
                    } else {
                        queue.add(new int[] {curRow, curCol});
                        visited[curRow][curCol] = true;
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution317 s = new Solution317();
        int[][] grid = new int[][] {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        System.out.println(s.shortestDistance(grid));
    }
}
