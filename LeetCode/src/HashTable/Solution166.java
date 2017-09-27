package HashTable;

import java.util.*;

/**
 * Created by ginolee on 8/11/17.
 */
public class Solution166 {
    /**
     * if there is a repeated item --> apply hashmap
     */
    public String fractionToDecimal(int numerator, int denominator) {
        Map<Long, Integer> map = new HashMap<>();            // (quotient, idx)
        StringBuilder sb = new StringBuilder();
        // special cases: negative integer
        sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        long num = Math.abs((long) numerator), den = Math.abs((long) denominator);
        sb.append(num / den);
        if (num % den == 0) {           // no decimal
            return sb.toString();
        }
        while (num != 0) {
            long quo = num / den;
            if (!map.containsKey(quo)) {
                map.put(quo, sb.length() - 1);
                sb.append(quo);
                num = (num % den) * 10;
            } else {
                sb.insert(map.get(quo), "(");
                sb.append(")");
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution166 s = new Solution166();
        System.out.println(s.fractionToDecimal(1, 6));
        System.out.println(true ^ true);
    }
}
