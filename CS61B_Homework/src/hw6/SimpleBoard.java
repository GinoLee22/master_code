/* SimpleBoard.java */
package hw6;

/**
 * Simple class that implements an 8x8 game board with three possible values
 * for each cell:  0, 1 or 2.
 * <p>
 * DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class SimpleBoard {
    private final static int DIMENSION = 8;
    private int[][] grid;

    /**
     *  Invariants:
     *  (1) grid.length == DIMENSION.
     *  (2) for all 0 <= i < DIMENSION, grid[i].length == DIMENSION.
     *  (3) for all 0 <= i, j < DIMENSION, grid[i][j] >= 0 and grid[i][j] <= 2.
     **/

    /**
     * Construct a new board in which all cells are zero.
     */

    public SimpleBoard() {
        grid = new int[DIMENSION][DIMENSION];
    }

    /**
     * Set the cell (x, y) in the board to the given value mod 3.
     *
     * @param value to which the element should be set (normally 0, 1, or 2).
     * @param x     is the x-index.
     * @param y     is the y-index.
     * @throws ArrayIndexOutOfBoundsException is thrown if an invalid index
     *                                        is given.
     **/

    public void setElementAt(int x, int y, int value) {
        grid[x][y] = value % 3;
        if (grid[x][y] < 0) {
            grid[x][y] = grid[x][y] + 3;
        }
    }

    /**
     * Get the valued stored in cell (x, y).
     *
     * @param x is the x-index.
     * @param y is the y-index.
     * @return the stored value (between 0 and 2).
     * @throws ArrayIndexOutOfBoundsException is thrown if an invalid index
     *                                        is given.
     */

    public int elementAt(int x, int y) {
        return grid[x][y];
    }

    /**
     * Returns true if "this" SimpleBoard and "board" have identical values in
     * every cell.
     *
     * @param board is the second SimpleBoard.
     * @return true if the boards are equal, false otherwise.
     */

    public boolean equals(Object board) {
        // Replace the following line with your solution.  Be sure to return false
        //   (rather than throwing a ClassCastException) if "board" is not
        //   a SimpleBoard.
        // 1st: change 2-d array to 1-d array
        int[] thisBoard = map2DTo1D(this.grid);
        int[] compareBoard = map2DTo1D(((SimpleBoard)board).grid);
        for (int index = 0; index < DIMENSION * DIMENSION; index++) {
            if (thisBoard[index] != compareBoard[index]) {
                return false;
            }
        }
        return true;
//        return false;
    }

    /**
     * Returns a hash code for this SimpleBoard.
     *
     * @return a number between Integer.MIN_VALUE and Integer.MAX_VALUE.
     */

    public int hashCode() {
        // Replace the following line with your solution.
        int hashCode = 0;
        int[] oneDim = map2DTo1D(grid);
        for (int index = 0; index < DIMENSION * DIMENSION; index++) {
            hashCode += intPower(3, index) * oneDim[index];         // 3^index * oneDim[index]
        }
        return hashCode;
//        return 99;
    }

    /**
     * self designed help function
     * static method that transfer a two-dimensional array to an one-dimensional array
     * @param twoDim
     * @return one-dimensional array
     */
    private static int[] map2DTo1D(int[][] twoDim) {           // twoDim is assumed: row == column
        int[] oneDim = new int[twoDim.length * twoDim.length];
        for (int i = 0; i < twoDim.length; i++) {
            for (int j = 0; j < twoDim[i].length; j++) {
                oneDim[i * twoDim.length + j] = twoDim[i][j];
            }
        }
        return oneDim;
    }

    /**
     * self designed help function
     * static method for printing 2D array
     * @param twoDim
     */
    private static void show2DArray(int[][] twoDim) {
        for (int i = 0; i < twoDim.length; i++) {
            for (int j = 0; j < twoDim[i].length; j++) {
                System.out.print(twoDim[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * self designed help function
     * static method for calculating the int power
     * @param base the base of power
     * @param exp the exponential term of power
     */
    private static int intPower(int base, int exp) {
        if (exp == 0) {
            return 1;
        }
        else {
            return base * intPower(base, exp - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("\n ---------- Testing of self method, map2DTo1D(), show2DArray(), intPower()");
        int[][] twoDim = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        show2DArray(twoDim);
        int[] oneDim = map2DTo1D(twoDim);
        for (int i = 0; i < 9; i++) {
            System.out.print(oneDim[i] + " ");
        }
        System.out.println("\n ---------- Result of intPower()");
        System.out.println(intPower(3, 0));
        System.out.println(intPower(3, 1));
        System.out.println(intPower(3, 2));
        System.out.println(intPower(3, 3));

        System.out.println("\n ---------- Testing of equals(), hashCode()");
        SimpleBoard sb1 = new SimpleBoard();
        SimpleBoard sb2 = new SimpleBoard();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb1.setElementAt(i, j, 1);
                sb2.setElementAt(i, j, 1);
            }
        }
        System.out.println("1st SimpleBoard & its corresponding hashCode");
        show2DArray(sb1.grid);
        System.out.println(sb1.hashCode());
        System.out.println("2nd SimpleBoard & its corresponding hashCode");
        show2DArray(sb2.grid);
        System.out.println(sb2.hashCode());
        System.out.println("Without change they should be equal: " + sb1.equals(sb2));
        sb1.setElementAt(0, 0, 0);
        System.out.println("The SimpleBoard after change & its corresponding hashCode");
        show2DArray(sb1.grid);
        System.out.println(sb1.hashCode());
        System.out.println("After changing one of the element, should not be equal: " + sb1.equals(sb2));
    }

}
