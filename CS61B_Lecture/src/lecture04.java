/**
 * Created by ginolee on 12/27/16.
 */
public class lecture04 {

    public static String recurOneToX(int x) {
        if(x < 1) {
            return "";
        }
        else {
//            return recurOneToX(x - 1) + "\n" +Integer.toString(x);
            return Integer.toString(x) + "\n" + recurOneToX(x - 1);
        }
    }

    public static void main(String[] args) {
        // testing of primitive type: int, long
        System.out.println("testing of primitive type: int, long.");
        long l = 999999999999L;
        System.out.println((int)l);

        // testing of recursive method
        System.out.println("testing of recursive method");
        System.out.println(recurOneToX(10));
    }
}
