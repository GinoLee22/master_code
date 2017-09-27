package OA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ginolee on 9/17/17.
 */
public class OnsiteAmazon {
    /**
     *
     * @param input [1, 2, 3, 4, 5, 6, 7, 8]
     * @param direction [left, left, right]
     * @return [8, 1, 4, 5, 6, 3, 2, 7] transpose
     */
    public void flip(int[] input, String[] direction) {
        List<List<Integer>> res =  new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int num : input) {
            cur.add(num);
        }
        res.add(new ArrayList<Integer>(cur));
//        System.out.println(res);
        // flip
        int rowSize = res.size();
        for (int i = 0; i < 2; i++) {
            cur.clear();
            for (int row = 0; row < rowSize; row++) {

                int colSize = res.get(0).size() / 2;
                for (int col = 0; col < colSize; col++) {
                    cur.add(0, res.get(0).get(0));
                    res.get(0).remove(0);
                }
            }
//            res.addAll(cur);
        }
    }

    public void matrixPrint(int[][] matrix) {
        String output = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        OnsiteAmazon osAmazon = new OnsiteAmazon();
        int[] input = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        String[] direction = new String[] {"left", "left", "right"};
//        int[] input = new int[] {1, 2, 3, 4};
//        String[] direction = new String[] {"left", "left"};
        osAmazon.flip(input, direction);
    }
}
