package Math;

/**
 * Created by ginolee on 7/19/17.
 */
public class Solution400 {
    /**
     * idea? NO. List the possibilities and find the routine
     */
    public int findNthDigit(int n) {
        long count = 9;
        int numDigit = 1, start = 0;
        while (n > numDigit * count) {
            start += count;
            n -= numDigit * count;
            numDigit++;
            count *= 10;
        }
        start += (n - 1) / numDigit + 1;
        System.out.println(start);
        String str = Integer.toString(start);
        return Character.getNumericValue(str.charAt((n - 1) % numDigit));
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution400 s = new Solution400();
        System.out.println(s.findNthDigit(200));
        System.out.println(Integer.MAX_VALUE);
    }
}
