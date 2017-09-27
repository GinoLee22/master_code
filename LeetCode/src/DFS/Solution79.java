package DFS;

import java.util.Arrays;

/**
 * Created by ginolee on 8/3/17.
 */
public class Solution79 {
    /**
     * search problem in a graph --> typical DFS problem
     */
    private int[] deltRow = new int[] {-1, 0, 1, 0};
    private int[] deltCol = new int[] {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (dfs(board, word, 0, row, col, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int curIdx, int row, int col, boolean[][] visited) {
        // base case (2)
        if (curIdx == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || word.charAt(curIdx) != board[row][col]) {
            return false;
        }
        // recursion: direction: up -> right -> down -> left
        visited[row][col] = true;
        boolean res = false;
        for (int i = 0; i < 4; i++) {
            int curRow = row + deltRow[i], curCol = col + deltCol[i];
            res = (res || dfs(board, word, curIdx + 1, curRow, curCol, visited));
        }
        visited[row][col] = false;
        return res;
    }


    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution79 s = new Solution79();
//        char[][] board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "ABCCED";
        char[][] board = new char[][] {{'a'}};
        String word = "a";
        System.out.println(s.exist(board, word));

        String str = "eat";
        char[] sArray = str.toCharArray();
        Arrays.sort(sArray);
        System.out.println(sArray[0]);
    }
}
