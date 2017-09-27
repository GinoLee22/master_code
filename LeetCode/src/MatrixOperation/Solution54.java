package MatrixOperation;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 9/10/17.
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;
        int len = matrix.length * matrix[0].length;
        int[][] delt = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] curDir = delt[0];
        int cnt = 0, global = 0;
        int curRow = 0, curCol = 0;
        List<Integer> res = new LinkedList<>();
        while (global < len) {
            if (curRow > rowEnd) {
                curRow -= curDir[0];
                cnt++;
                curDir = delt[cnt % 4];
                colEnd -= 1;
            } else if (curRow < rowStart) {
                curRow -= curDir[0];
                cnt++;
                curDir = delt[cnt % 4];
                colStart += 1;
            } else if (curCol > colEnd) {
                curCol -= curDir[1];
                cnt++;
                curDir = delt[cnt % 4];
                rowStart += 1;
            } else if (curCol < colStart) {
                curCol -= curDir[1];
                cnt++;
                curDir = delt[cnt % 4];
                rowEnd -= 1;
            } else {    // correct
                global++;
                res.add(matrix[curRow][curCol]);
            }
            curRow += curDir[0];
            curCol += curDir[1];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution54 s = new Solution54();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(s.spiralOrder(matrix));

        System.out.println(Integer.MAX_VALUE);
    }

}
