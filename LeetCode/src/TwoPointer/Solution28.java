package TwoPointer;

/**
 * Created by ginolee on 3/24/17.
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }

        char[] lArray = haystack.toCharArray(), sArray = needle.toCharArray();
        for (int i = 0; i < haystack.length(); i++) {
            int longI = i, shortI = 0;
            while (shortI < needle.length() && longI < haystack.length()) {
                if (lArray[longI] == sArray[shortI]) {
                    if (shortI == needle.length() - 1) {
                        return i;
                    }
                    longI++;
                    shortI++;
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution28 s = new Solution28();
        System.out.println("\n ----- self-testing");
        String haystack1 = "abcabcd";
        String needle1 = "abcd";
//        String needle1 = "abcde";
        String haystack2 = "mississippi";
        String needle2 = "a";
        String haystack3 = "mississippi";
        String needle3 = "issipi";


        System.out.println(s.strStr(haystack1, needle1));
        System.out.println(s.strStr(haystack2, needle2));
        System.out.println(s.strStr(haystack3, needle3));
    }
}
