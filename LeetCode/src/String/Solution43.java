package String;

/**
 * Created by ginolee on 7/10/17.
 */
public class Solution43 {
    /**
     * key idea: use the method "multiplyOne()" & do multiplication one bit by one bit
     */
    public String multiply(String num1, String num2) {
        char[] whole1 = num1.toCharArray(), whole2 = num2.toCharArray();
        return null;
    }

    private int multiplyOne(char[] whole, char one) {
        int carrier = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = whole.length - 1; i >= 0; i--) {
            int curRes = (whole[i] - '0') * (one - '0') + carrier;
            sb.insert(0, curRes % 10);
            carrier = curRes / 10;
        }
        return 10;
    }

    public static void main(String[] args) {
        System.out.println("self-testing of multiplyOne()");
        Solution43 s = new Solution43();
        char[] whole = {'1', '2', '5'};
        char one = '0';
        System.out.println(s.multiplyOne(whole, one));
        System.out.println('(' - '0');
    }
}
