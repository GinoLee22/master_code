/**
 * Created by ginolee on 12/27/16.
 */
public class lecture05 {

    private static int[][] pascalTriangle(int n) {
        int[][] pt = new int[n][];
        for (int i = 0; i < n; i++) {
            pt[i] = new int[i + 1];
            pt[i][0] = 1;               // 1st element of a row
            for (int j = 1; j < i; j++) {
                pt[i][j] = pt[i - 1][j - 1] + pt[i - 1][j];
            }
            pt[i][i] = 1;           // last element of a row
        }
        return pt;
    }

    private static String ptToString(int[][] pt) {
        String output = "";
        for (int i = 0; i < pt.length; i++){
            for (int j = 0; j <= pt[i].length - 1; j++) {
                output += Integer.toString(pt[i][j]) + " ";
            }
            output += "\n";
        }
        return output;
    }
    public static void main(String[] args) {
        // practices of arrays
        System.out.println("Practise of Arrays: " + "\n" + "1st Practise: ");
        char[] cArray= new char[4];
        cArray[0] = 'b';
        cArray[1] = 'l';
        cArray[2] = 'u';
        cArray[3] = 'e';
        System.out.println(cArray[1]);

        System.out.println("2nd Practise: ");
        int[][] pt = pascalTriangle(10);
        System.out.println(ptToString(pt));

    }
}
