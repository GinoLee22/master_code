package TwoPointer;

/**
 * Created by ginolee on 3/23/17.
 */
public class Solution344 {
    public String reverseString(String s) {
        if (s == null) {
            return s;
        }

        char[] sArray = s.toCharArray();
        int left = 0, right = sArray.length - 1;
        while (left < right) {
            char temp = sArray[right];
            sArray[right] = sArray[left];
            sArray[left] = temp;
            left++;
            right--;
        }
        return new String(sArray);
    }

    public static void main(String[] args) {
        Solution344 s = new Solution344();
        System.out.println("\n ----- self-testing");
        String str = "hello";
        System.out.println(s.reverseString(str));
    }
}
