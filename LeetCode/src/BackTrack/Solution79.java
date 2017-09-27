package BackTrack;

/**
 * Created by ginolee on 7/3/17.
 */
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        boolean result;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtrack(board, i, j, wordArray, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int row, int col, char[] wordArray, int idx) {
        // base case 1
        if (idx == wordArray.length) {
            return true;
        }
        // base case 2
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != wordArray[idx]) {
            return false;
        }
        // recursion order: up, right, down, left
        board[row][col] = '*';              // mark it as visited
        boolean up = backtrack(board, row - 1, col, wordArray, idx + 1);
        boolean right = backtrack(board, row, col + 1, wordArray, idx + 1);
        boolean down = backtrack(board, row + 1, col, wordArray, idx + 1);
        boolean left = backtrack(board, row, col - 1, wordArray, idx + 1);
        board[row][col] = wordArray[idx];
        return up || right || down || left;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
