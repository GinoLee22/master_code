package Array;

/**
 * Created by ginolee on 2/22/17.
 */
public class Solution48 {

    public void rotate(int[][] matrix) {
        // 1st step: transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 2nd step: inverse horizontally
        // flipping: i --> length - 1 - i
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = temp;
            }
        }
    }

    public static void imagePrint(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j <image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing of 2-dimensional array");
        int[][] image = new int[4][4];
        int add = 1;
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                image[i][j] = add;
                add++;
            }
        }
        // this 2D array is: [0 1 2 3] [1 2 3 4] [2 3 4 5]
        System.out.println(image[0][2]);
        System.out.println(image[1][0]);

        System.out.println("self-testing");
        Solution48 s = new Solution48();
        System.out.println("Original Image");
        imagePrint(image);
        System.out.println("Rotated Image");
        s.rotate(image);
        imagePrint(image);
    }
}
