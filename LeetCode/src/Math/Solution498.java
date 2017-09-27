package Math;


/**
 * Created by ginolee on 7/21/17.
 */
public class Solution498 {
    /**
     * useful technique in image compression: zigzag compression
     * direction [-1, 1] OR [1, -1]. This comes from the problem illustration
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        int rowSize = matrix.length, colSize = matrix[0].length;
        int row = 0, col = 0;
        int[] dir = new int[] {-1, 1},  res = new int[rowSize * colSize];
        for (int i = 0; i < rowSize * colSize; i++) {
            res[i] = matrix[row][col];
            row += dir[0];
            col += dir[1];
            if (row >= rowSize) {
                row--;
                col += 2;
                changeDirect(dir);
            }
            if (col >= colSize) {
                col--;
                row += 2;
                changeDirect(dir);
            }
            if (row < 0) {
                row = 0;
                changeDirect(dir);
            }
            if (col < 0) {
                col = 0;
                changeDirect(dir);
            }
        }
        return res;
    }

    private void changeDirect (int[] dir) {
        if (dir[0] == -1 && dir[1] == 1) {
            dir[0] = 1;
            dir[1] = -1;
        } else {
            dir[0] = -1;
            dir[1] = 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution498 s = new Solution498();
        int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        s.findDiagonalOrder(matrix);
        int[] dir = new int[] {-1, 1};
        System.out.println(dir[0]);

        System.out.println(Integer.toBinaryString(25));

    }
}
