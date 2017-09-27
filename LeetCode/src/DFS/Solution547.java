package DFS;

/**
 * Created by ginolee on 7/5/17.
 */
public class Solution547 {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int counter = 0;
        for (int row = 0; row < M.length; row++) {
            if (visited[row] == 0) {
                dfs(M, visited, row, row);
                counter++;
            }
        }
        return counter;
    }

    private void dfs(int[][] M, int[] visited, int row, int col) {
        // base case
        if (col >= M[row].length || M[row][col] == 0) {
            return;
        }
        // recursion
        visited[col] = 1;
        dfs(M, visited, row, col + 1);
    }
}
