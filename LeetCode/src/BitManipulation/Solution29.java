package BitManipulation;

import com.sun.tools.corba.se.idl.InterfaceGen;
import num1.Solution;

/**
 * Created by ginolee on 6/21/17.
 */
public class Solution29 {
    public int divide(int dividend, int divisor) {
        /**
         * idea: bit manipulate (anything can't use "*","/","%" --> use bit manipulate)
         * Corner case: 1. divisor == 0
         *              2. dividend / divisor == MIN_VALUE
         * Detailed explain on notes
         */
        // deal with overflow
        if ((dividend == Integer.MIN_VALUE && divisor == -1) || divisor == 0) {
            return Integer.MAX_VALUE;
        }

        // deal with sign
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        long divisorLong = Math.abs((long) divisor), remainder = Math.abs((long) dividend), result = 0;
        while (remainder >= divisorLong) {
            long mult = 1, divisorTemp = divisorLong;
            while (remainder >= divisorTemp << 1) {
                divisorTemp = divisorTemp << 1;
                mult = mult << 1;
            }
            remainder -= divisorTemp;
            result += mult;
        }
        return isNegative ? (int) -result : (int) result;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution29 s = new Solution29();
        int dividend = Integer.MIN_VALUE, divisor = 1;
        System.out.println(s.divide(dividend, divisor));
    }
}
