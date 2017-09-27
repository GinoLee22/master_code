package DFS;

/**
 * Created by ginolee on 8/22/17.
 */
public class Solution531 {
    // direction: up -> right -> down -> left. row: idx 0, col: idx 1
    private int[][] delt = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    /**
     * graph problem + keep checking in one direction -> typical DFS problem
     * @param picture
     * @return
     */
    public int findLonelyPixel(char[][] picture) {
        int numOfLone = 0;
        for (int row = 0; row < picture.length; row++) {
            for (int col = 0; col < picture[0].length; col++) {
                if (picture[row][col] == 'W') {
                    continue;
                }
                if (isBlackLone(picture, row, col)) {
                    numOfLone++;
                }
            }
        }
        return numOfLone;
    }

    private boolean isBlackLone(char[][] picture, int row, int col) {
        // base case (2)
        if (row < 0 || row >= picture.length || col < 0 || col >= picture[0].length) {
            return true;
        }
        if (picture[row][col] == 'B') {
            return false;
        }
        // recursion
        boolean res = true;
        for (int i = 0; i < 4; i++) {
            int curRow = row + delt[i][0], curCol = col + delt[i][0];
            res = (res && isBlackLone(picture, curRow, curCol));
        }
        return res;
    }

//    /**
//     * my question is How to solve this problem by dfs?
//     */
//    public int findLonelyPixel(char[][] picture) {
//        int numLone = 0;
//        for (int row = 0; row < picture.length; row++) {
//            for (int col = 0; col < picture[row].length; col++) {
//                if (picture[row][col] == 'W') {
//                    continue;
//                }
//                if (dfs(picture, row - 1, col, new int[] {-1, 0}) && dfs(picture, row + 1, col, new int[] {1, 0})
//                        && dfs(picture, row, col - 1, new int[] {0, -1}) && dfs(picture, row, col + 1, new int[] {0, 1})) {
//                    numLone++;
//                }
//            }
//        }
//        return numLone;
//    }
//
//    // use dfs to find if current pixel is lonely. Only change row, col is fixed
//    private boolean dfs(char[][] picture, int row, int col, int[] increase) {
//        // base case
//        if (row < 0 || row >= picture.length || col < 0 || col >= picture[0].length) {
//            return true;
//        } else if (picture[row][col] == 'B') {
//            return false;
//        }
//        // recursion
//        return dfs(picture, row + increase[0], col + increase[1], increase);
//    }
}
