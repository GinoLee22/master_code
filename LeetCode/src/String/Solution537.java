package String;



/**
 * Created by ginolee on 7/13/17.
 */
public class Solution537 {
    /**
     * idea: store the real & complex number of a in int[]. same to b
     */
    public String complexNumberMultiply(String a, String b) {
        String[] aArray = a.split("\\+"), bArray = b.split("\\+");
        int[] aDigit = new int[] {Integer.parseInt(aArray[0]), Integer.parseInt(aArray[1].substring(0, aArray[1].length() - 1))};
        int[] bDigit = new int[] {Integer.parseInt(bArray[0]), Integer.parseInt(bArray[1].substring(0, bArray[1].length() - 1))};
        int r = aDigit[0] * bDigit[0] - aDigit[1] * bDigit[1];
        int c = aDigit[0] * bDigit[1] + aDigit[1] * bDigit[0];
        return r + "+" + c + "i";
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution537 s = new Solution537();
        String a = "1+1i", b = "1+1i";
        System.out.println(s.complexNumberMultiply(a, b));
    }
}
