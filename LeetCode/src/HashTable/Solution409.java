package HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ginolee on 3/18/17.
 */
public class Solution409 {
    public int longestPalindrome(String s) {
        char[] sArray = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char c : sArray) {
            if (set.contains(c)) {              // if character is already in the set --> remove it & add 1 to count
                set.remove(c);
                count++;
            } else {
                set.add(c);
            }
        }
        // if set is not empty: add 1 to final result because one unique character can be put into middle
        return 2 * count + (set.isEmpty() ? 0 : 1);
    }

    public static void main(String[] args) {
        Solution409 s = new Solution409();
        System.out.println("\n ----- self-testing");
        String input = "abbbcccc";
        System.out.println(s.longestPalindrome(input));
    }
}
