package BFS;

import num1.Solution;

import java.awt.*;
import java.util.*;

/**
 * Created by ginolee on 6/29/17.
 */
public class Solution130 {
    public void solve(char[][] board) {
        // corner case
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        // find edge "O"s
        Queue<Point> queue = new LinkedList<>();            // use a point to record the row & col index
        int m = board.length;
        int n = board[0].length;
        // first & last column
        for (int row = 0; row < m; row++) {
            if (board[row][0] == 'O') {
                queue.add(new Point(row, 0));
            }
            if (board[row][n - 1] == 'O') {
                queue.add(new Point(row, n - 1));
            }
        }
        // first & last row
        for (int col = 0; col < n; col++) {
            if (board[0][col] == 'O') {
                queue.add(new Point(0, col));
            }
            if (board[m - 1][col] == 'O') {
                queue.add(new Point(m - 1, col));
            }
        }
        // BFS to find all 'O' connecting to the edges
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int row = cur.x, col = cur.y;
            System.out.println(row);
            System.out.println(col);
            // check the 4 points around it, if they are 'O'
            board[row][col] = '+';              // here: mark them to '+' is actually to mark them as visited
            System.out.println(board[row][col]);
            if (row - 1 >= 0 && board[row - 1][col] == 'O') {       // up
                queue.add(new Point(row - 1, col));
            }
            if (col + 1 < n && board[row][col + 1] == 'O') {        // right
                queue.add(new Point(row, col + 1));
            }
            if (row + 1 < m && board[row + 1][col] == 'O') {        // down
                queue.add(new Point(row + 1, col));
            }
            if (col - 1 >= 0 && board[row][col - 1] == 'O') {       // left
                queue.add(new Point(row, col - 1));
            }
        }

        // print current board
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                System.out.println(board[row][col]);
            }
            System.out.println();
        }
        // loop the 2D array to change
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == '+') {
                    board[row][col] = 'O';
                }
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        Solution130 s = new Solution130();
        s.solve(board);
        System.out.println(board[3][1]);

        System.out.println("test of lengths of 2D arrays");
        int[][] grid = {{},{},{}};
        System.out.println(grid.length);
        System.out.println(grid[0].length);
    }
}
