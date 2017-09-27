package TwoPointer;

/**
 * Created by ginolee on 8/27/17.
 */

/**
 * Problem Description
 * Given a string which contains only letters. Sort it by lower case first and upper case second.
 * <p>
 * Example
 * For "abAcD", a reasonable answer is "acbAD"
 */

public class SortLettersByCase {
    public void sortLetters(char[] chars) {
        // corner case
        if (chars == null || chars.length < 2) {
            return;
        }

        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < right && Character.isLowerCase(chars[left])) {
                left++;
            }
            while (left < right && Character.isUpperCase(chars[right])) {
                right--;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
