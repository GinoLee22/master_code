/**
 * Created by ginolee on 12/27/16.
 */
public class lecture06 {

    private static String arrayToString(int[][] primitiveArray) {
        String output = new String();
        for (int i = 0; i < primitiveArray.length; i++) {
            for (int j = 0; j < primitiveArray[i].length; j++) {
                output += Integer.toString(primitiveArray[i][j]) + " ";
            }
            output += "\n";
        }
        return output;
    }

    private static String objectToString(Object[][] obj) {
        String output = new String();
        for (int i = 0; i < obj.length; i++) {
            for (int j = 0; j < obj[i].length; j++) {
                output += obj[i][j].toString() + " ";
            }
            output += "\n";
        }
        return output;
    }

    public static void main(String[] args) {
//        int[][] intArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] intArray = new int[3][3];
        System.out.println(arrayToString(intArray));

        System.out.println("Testing: construct an array of objects must initialize manually because Java won't automatically create");
        String[][] stringArray = new String[2][2];
//        stringArray[0][0] = "A";
//        stringArray[0][1] = "B";
//        stringArray[1][0] = "C";
//        stringArray[1][1] = "D";
//        System.out.println(objectToString(stringArray));
    }
}
