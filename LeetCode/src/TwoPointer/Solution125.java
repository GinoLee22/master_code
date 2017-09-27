package TwoPointer;

/**
 * Created by ginolee on 3/23/17.
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        // special condition
        if (s == null || s.length() == 0) {
            return true;
        }

        // pre-processing of input string
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        // two pointer algorithm
        char[] sArray = actual.toCharArray();
        int left = 0, right = sArray.length - 1;
        while (left < right) {
            if (sArray[left] != sArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution125 s = new Solution125();
        System.out.println("\n ----- self-testing of string regex");
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        System.out.println(s1.replaceAll("[^A-Za-z0-9]", "").toLowerCase());
        System.out.println(s2.replaceAll("[^A-Za-z0-9]", "").toLowerCase());

        System.out.println("\n ----- self-testing");
        System.out.println(s.isPalindrome(s1));
        System.out.println(s.isPalindrome(s2));
    }
}
