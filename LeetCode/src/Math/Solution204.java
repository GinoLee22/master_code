package Math;

/**
 * Created by ginolee on 9/11/17.
 */
public class Solution204 {
    public int countPrimes(int n) {
        int[] isPrime = new int[n];         // 0: is prime. 1: not prime
        isPrime[0] = 1;
        isPrime[1] = 1;

        for (int i = 2; i <= Math.sqrt(n - 1); i++) {
            if (isPrime[i] == 0) {          // if "i" is prime -> all its multiples are not primes anymore
                for (int j = 2; i * j < n; j++) {
                    isPrime[i * j] = 1;
                }
            }
        }
        // final count
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime[i] == 0) {
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution204 s = new Solution204();
        s.countPrimes(36);
    }
}
