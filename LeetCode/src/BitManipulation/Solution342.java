package BitManipulation;

import java.util.Arrays;

/**
 * Created by ginolee on 6/29/17.
 */
public class Solution342 {
    public boolean isPowerOfFour(int num) {
        // base case
        if (num == 1) {
            return true;
        }
        if (num % 4 != 0) {
            return false;
        }
        // recursion
        return isPowerOfFour(num / 4);
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution342 s = new Solution342();
        System.out.println(s.isPowerOfFour(16));
        System.out.println(Integer.MIN_VALUE >>> 1);

        System.out.println(Integer.highestOneBit(5));
        System.out.println(Integer.parseInt("1011111011", 2));
        System.out.println(Integer.toBinaryString(100000000));
        System.out.println(5 & -5);

        String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        System.out.println(2 << 2);
        System.out.println("ssss".substring(0,4));
    }
}
