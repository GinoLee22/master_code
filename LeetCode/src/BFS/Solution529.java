package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ginolee on 7/30/17.
 */
public class Solution529 {
    /**
     * BFS algorithm
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {click[0], click[1]});
        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int curRow = curPos[0], curCol = curPos[1];
            // if it is "M", stop it & don't operate the queue
            if (board[curRow][curCol] == 'M') {
                board[curRow][curCol] = 'X';
            } else {      // operate the queue
                // find the number of mines around this click
                int numMines = findNumMines(board, curRow, curCol);
                if (numMines > 0) {
                    board[curRow][curCol] = (char) (numMines + '0');
                } else {            // all adjacent board is "E"
                    board[curRow][curCol] = 'B';
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) {
                                continue;
                            }
                            if (curRow + i < 0 || curRow + i >= board.length || curCol + j < 0 || curCol + j >= board[curRow + i].length) {
                                continue;
                            }
                            if (board[curRow + i][curCol + j] == 'E') {
                                queue.add(new int[] {curRow + i, curCol + j});
                                board[curRow + i][curCol + j] = 'B';
                            }
                        }
                    }
                }
            }
        }
        return board;
    }

    private int findNumMines(char[][] board, int row, int col) {
        int numMines = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (row + i < 0 || row + i >= board.length || col + j < 0 || col + j >= board[row + i].length) {
                    continue;
                }
                if (board[row + i][col + j] == 'M') {
                    numMines++;
                }
            }
        }
        return numMines;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution529 s = new Solution529();
        char[][] board = {{'E', 'E', 'E', 'E', 'E'}, {'E','E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        System.out.println(s.updateBoard(board, new int[] {3, 0}));
    }
}
