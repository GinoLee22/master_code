package Math;

/**
 * Created by ginolee on 7/14/17.
 */
public class Solution168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, (char)'A' + n % 26 - 1);
            n /= 26;
        }
        return sb.toString();
    }
}
