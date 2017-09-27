package HashTable;

/**
 * Created by ginolee on 3/18/17.
 */
public class Solution204 {
    public int countPrimes(int n) {
        /**
         * clear explanation: https://www.youtube.com/watch?v=eKp56OLhoQs
         */
        // initially assume all number prime except 0, 1
        int [] primes = new int[n];
        for (int i = 2; i <= n - 1; i++) {
            primes[i] = 1;
        }
        // Sieve of Evalosthenes --> in the final array: primes is 1 & otherwise 0
        for (int i = 2; i <= Math.sqrt(n - 1); i++) {
            if (primes[i] == 1) {
                // all the multiple of primes number can't be prime anymore
                for (int j = 2; j * i <= n - 1; j++) {
                    primes[j * i] = 0;
                }
            }
        }
        // counting: Note: can't do this counting in previous loop because Sieve of Evalosthenes doesn't go through them all
        int count = 0;
        for (int i = 2; i <= n - 1; i++) {
            if (primes[i] == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution204 s = new Solution204();
        System.out.println("\n ----- self-testing");
        System.out.println(s.countPrimes(0));
        System.out.println(s.countPrimes(1));
        System.out.println(s.countPrimes(2));
        System.out.println(s.countPrimes(3));
        System.out.println(s.countPrimes(13));
    }
}
