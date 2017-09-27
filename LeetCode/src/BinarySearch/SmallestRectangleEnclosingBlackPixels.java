package BinarySearch;

/**
 * Created by ginolee on 8/28/17.
 */

/**
 * Problem Description
 * An image is represented by a binary matrix with 0 as white pixel and 1 as a black pixel. The black pixels are connected, i.e. there is only one black region.
 * Pixels are connected horizontally & vertically. Given the location [x, y] of one of the black pixels, return the area of the smallest (axis-aligned) rectangle
 * that encloses all black pixels.
 *
 * Example:
 * For example, given the following image:
 * [
 *  "0010"
 *  "0110"
 *  "0100"
 *  ]
 *  and x = 0, y = 2, return 6.
 */
public class SmallestRectangleEnclosingBlackPixels {
    /**
     * Idea: find left, right, up & down boundaries
     * Take left boundary as an example: find the first index that there is a 1 in the column
     */
    private static int COLUMN = 0;
    private static int ROW = 1;
    public int minArea(char[][] image, int x, int y) {
        int leftBound = findLeftBound(image, x, y);
        int rightBound = findRightBound(image, x, y);
        int upBound = findUpBound(image, x, y);
        int lowBound = findLowBound(image, x, y);
        return (rightBound - leftBound + 1) * (lowBound - upBound + 1);
    }

    /**
     * if there is a 1 in the row/column -> return true. Otherwise, false
     */
    private boolean check(char[][] image, int direct, int row, int col) {
        if (direct == COLUMN) {
            for (int r = 0; r < image.length; r++) {
                if (image[r][col] == '1') {
                    return true;
                }
            }
        } else {            // direct == ROW
            for (int c = 0; c < image[0].length; c++) {
                if (image[row][c] == '1') {
                    return true;
                }
            }
        }
        return false;
    }

    // find the 1st index that is 1
    private int findLeftBound(char[][] image, int row, int col) {
        int left = 0, right = col;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(image, COLUMN, row, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    // find the last index that is 1
    private int findRightBound(char[][] image, int row, int col) {
        int left = col, right = image[0].length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(image, COLUMN, row, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (check(image, COLUMN, row, right)) {
            return right;
        }
        return left;
    }

    private int findUpBound(char[][] image, int row, int col) {
        int left = 0, right = col;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(image, ROW, mid, col)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int findLowBound(char[][] image, int row, int col) {
        int left = row, right = image.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(image, ROW, mid, col)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (check(image, ROW, right, col)) {
            return right;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        SmallestRectangleEnclosingBlackPixels sreb = new SmallestRectangleEnclosingBlackPixels();
        char[][] image = new char[][] {{'0', '0', '1', '0'}, {'0', '1', '1', '0'}, {'0', '1', '0', '0'}};
        System.out.println(sreb.minArea(image, 0, 2));
    }
}
