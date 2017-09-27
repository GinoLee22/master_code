package HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ginolee on 2/25/17.
 */
public class Solution202 {

    public boolean isHappy(int n) {
        // idea: if can add n into set --> do 'squareSum'. if can't add --> return false
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.add(n)) {
                n = digitSquareSum(n);
            } else {
                return false;
            }
        }
        return true;
    }

    private int digitSquareSum(int n) {
        int result = 0;
        while (n != 0) {
            result += Math.pow((n % 10), 2);
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution202 s = new Solution202();
        System.out.println("\n ----- self-testing of digitSquareSum()");
        System.out.println(s.digitSquareSum(19));
        System.out.println(s.digitSquareSum(82));
        System.out.println(s.digitSquareSum(100));

        System.out.println("\n ----- self-testing of HashSet()");
        // it will return true if adding is a new integer, otherwise not.
        Set<Integer> set = new HashSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(2));
        System.out.println(set.add(3));
        System.out.println(set.add(1));

        System.out.println("\n ----- self-testing");
        System.out.println("Should be true: " + s.isHappy(19));
        System.out.println("Should be false: " + s.isHappy(16));


    }
}
