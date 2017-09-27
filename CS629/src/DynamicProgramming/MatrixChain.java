package DynamicProgramming;

/**
 * Created by ginolee on 3/2/17.
 */
public class MatrixChain {

    /**
     *
     * @param seq is the dimension of all the matrices
     * @param S is a matrix of each stop point [i, j]. S is initialized to all 0 and valid only when row >= 0 & column >=1
     * @return
     */
    public int[][] dpMatrixChain(int[] seq, int[][] S){
        // create a matrix to record the optimal numbers of matrix mults
        int n = seq.length - 1;
        int[][] M = new int[n][n];
        for (int i = 0; i < n; i++) {
            M[i][i] = 0;
        }
        // dp: diagonal
        for (int d = 1; d < n; d++) {
            for (int row = 0; row < n - d; row++) {
                int column = row + d;
                M[row][column] = Integer.MAX_VALUE;
                for (int k = row; k < column; k++) {
                    int curMults = M[row][k] + M[k + 1][column] + seq[row] * seq[k + 1] * seq[column + 1];
                    if (curMults < M[row][column]) {
                        // update the M matrix and the stop matrix S
                        M[row][column] = curMults;
                        S[row][column] = k;
                    }
                }
            }
        }
        return M;
    }

    /**
     * return the optimal operation of matrix chain. start, end mean --> A[start] * A[start + 1] * ... * A[end]
     * @param S
     * @param start
     * @param end
     * @return
     */
    public String matrixChainVisualize(int[][] S, int start, int end) {
        String output = "";
        // base case:
        if (start == end) {
            output += "A[" + start + "]";
        } else {        // recursion:
            int k = S[start][end];
            output += "(" + matrixChainVisualize(S, start, k) + matrixChainVisualize(S, k + 1, end) + ")";
        }
        return output;
    }

    // visualize the matrix
    public String printMatrix (int[][] matrix) {
        String output = "";
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                output += matrix[row][column] + " ";
            }
            output += "\n";
        }
        return  output;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing of printMax()");
        MatrixChain s = new MatrixChain();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(s.printMatrix(matrix));

        System.out.println("\n ----- self-testing of dpMatrixChain()");
        int[] seq = {3, 8, 20, 15, 11, 2, 17};
//        int[] seq = {30, 1, 40, 10, 25};
        int[][] S = new int[seq.length - 1][seq.length - 1];
        System.out.println(s.printMatrix(s.dpMatrixChain(seq, S)));
        System.out.println("\n ----- the stop matrix");
        System.out.println(s.printMatrix(S));
        System.out.println("\n ----- visualize the matrix chain");
        int end = seq.length - 2;
        System.out.println(s.matrixChainVisualize(S, 0, end));
    }
}
