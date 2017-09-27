package Math;

/**
 * Created by ginolee on 7/20/17.
 */
public class Solution592 {
    public String fractionAddition(String expression) {
        return null;
    }

    // Computes gcd using Euclidean algorithm
    public int gcd(int x, int y) {
        if (x == 0) {
            return y;
        } else if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution592 s = new Solution592();
        String str = "-1/2+1/2";
        String[] sArray = str.split("(?=[-+])");
        for (int i = 0; i < sArray.length; i++) {
            System.out.println(sArray[i]);
        }

        System.out.println(Integer.parseInt("-1"));

        System.out.println(s.gcd(6, -1));
    }
}
