package BFS;

import num1.Solution;

import java.awt.*;
import java.util.*;

/**
 * Created by ginolee on 6/29/17.
 */
public class Solution200 {
    public int numIslands(char[][] grid) {
        // corner case. Note: 2D array {{}, {}, {}} --> lengths are (3, 0)
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    bfsFill(grid, row, col);
                    count++;
                }
            }
        }
        return count;
    }

    // all the input char[row][col] should be '1'
    private void bfsFill(char[][] grid, int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col));
        int m = grid.length, n = grid[0].length;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int curRow = cur.x, curCol = cur.y;
            grid[row][col] = '0';                                               // mark it as already read
            if (curRow - 1 >= 0 && grid[curRow - 1][curCol] == '1') {           // up
                queue.add(new Point(curRow - 1, curCol));
            }
            if (curCol + 1 < n && grid[curRow][curCol + 1] == '1') {            // right
                queue.add(new Point(curRow, curCol + 1));
            }
            if (curRow + 1 < m && grid[curRow + 1][curCol] == '1') {            // down
                queue.add(new Point(curRow + 1, curCol));
            }
            if (curCol - 1 >= 0 && grid[curRow][curCol - 1] == '1') {           // left
                queue.add(new Point(curRow, curCol - 1));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution200 s = new Solution200();
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(s.numIslands(grid));
    }
}
