package BFS;

import java.util.*;

/**
 * Created by ginolee on 7/5/17.
 */
public class Solution542 {
    public int[][] updateMatrix(int[][] matrix) {
        // 1st step: create a "visited" mask to record the visited elements --> false: not visited
        int m = matrix.length, n = matrix[0].length;
        boolean[][] mask = new boolean[m][n];
        // 2nd step: add "0"s first & then "1"s
        Queue<int[]> queue = new LinkedList<>();            // element is position: [row, col]
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 0) {
                    queue.add(new int[] {row, col});
                    mask[row][col] = true;
                }
            }
        }
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();
                int curRow = curPos[0], curCol = curPos[1];
                // find adjacent elements with value 1. order: up --> right --> down --> left
                if(curRow - 1 >= 0 && mask[curRow - 1][curCol] == false && matrix[curRow - 1][curCol] == 1) {
                    queue.add(new int[] {curRow - 1, curCol});
                    matrix[curRow - 1][curCol] = depth;
                    mask[curRow - 1][curCol] = true;
                }
                if (curCol + 1 < n && mask[curRow][curCol + 1] == false && matrix[curRow][curCol + 1] == 1) {
                    queue.add(new int[] {curRow, curCol + 1});
                    matrix[curRow][curCol + 1] = depth;
                    mask[curRow][curCol + 1] = true;
                }
                if (curRow + 1 < m && mask[curRow + 1][curCol] == false && matrix[curRow + 1][curCol] == 1) {
                    queue.add(new int[] {curRow + 1, curCol});
                    matrix[curRow + 1][curCol] = depth;
                    mask[curRow + 1][curCol] = true;
                }
                if (curCol - 1 >=0 && mask[curRow][curCol - 1] == false && matrix[curRow][curCol - 1] == 1) {
                    queue.add(new int[] {curRow, curCol - 1});
                    matrix[curRow][curCol - 1] = depth;
                    mask[curRow][curCol - 1] = true;
                }
            }
            depth++;
        }
        return matrix;
    }
}
