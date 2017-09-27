package hw6.dict;

/**
 * Created by ginolee on 1/5/17.
 */
public class help {
    public static boolean isPrime(int n) {
        for (int divisor = 2; divisor < n; divisor++) {
            if (n % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
        System.out.println(isPrime(13));
        System.out.println(isPrime(17));
        System.out.println(isPrime(91));
        System.out.println(isPrime(97));
        System.out.println(isPrime(16908799));

    }
}
