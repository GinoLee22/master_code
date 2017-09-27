package HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ginolee on 5/16/17.
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            // create 3 sets: can add --> valid. can't add --> invalid
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                // check ith row, col & cube
                if (board[i][j] != '.' && !row.add(board[i][j])) {      // row
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])) {      // col
                    return false;
                }
                int cubeRow = 3 * (i / 3) + j / 3, cubeCol = 3 * (i % 3) + j % 3;
                if (board[cubeRow][cubeCol] != '.' && !cube.add(board[cubeRow][cubeCol])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("hello");

    }
}
