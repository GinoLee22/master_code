package BackTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 2/27/17.
 */
public class Solution60 {
    public String getPermutation(int n, int k) {
        /*
         * comment use n = 4, k = 17 as an example
         */
        // step 1: construct facotrial array
        int[] factorial = new int[n];
        factorial[0] = 1;
        int sum = 1;
        for (int i = 1; i < n; i++) {       // factorial [1, 1, 2, 6]
            sum *= i;
            factorial[i] = sum;
        }
        // step 2: create the number list   // numbers [1, 2, 3, 4]. After adding to final result, number should be removed
        List<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        // step 3: core
        String result = "";
        k--;            // to avoid corner case such as k = 12
        for (int i = n - 1; i >= 0; i--) {
            int idx = k / factorial[i];
            result += numbers.get(idx);
            System.out.println(numbers);
            numbers.remove(idx);
            k %= factorial[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution60 s = new Solution60();
        System.out.println(s.getPermutation(5, 1));
    }
}
