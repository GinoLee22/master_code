package TwoPointer;

/**
 * Created by ginolee on 3/22/17.
 */
public class Solution345 {
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }

        String vowels = "aeiouAEIOU";
        char[] sArray = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !vowels.contains(sArray[left] + "")) {
                left++;
            }
            while (left < right && !vowels.contains(sArray[right] + "")) {
                right--;
            }
            char temp = sArray[right];
            sArray[right] = sArray[left];
            sArray[left] = temp;
            left++;
            right--;
        }
        return new String(sArray);
    }

    public static void main(String[] args) {
        Solution345 s = new Solution345();
        System.out.println("\n ----- self-testing");
        String input = "leetcode";
        System.out.println(s.reverseVowels(input));
    }
}
