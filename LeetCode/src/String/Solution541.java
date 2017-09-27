package String;

/**
 * Created by ginolee on 7/9/17.
 */
public class Solution541 {
    public String reverseStr(String s, int k) {
        int start = 0, end = k - 1;
        char[] sArray = s.toCharArray();
        while (end <= s.length() - 1) {
            swap(sArray, start, end);
            start += 2 * k;
            end = start + k - 1;
        }
        if (start < s.length() - 1) {
            swap(sArray, start, s.length() - 1);
        }
        return new String(sArray);
    }

    private void swap(char[] input, int start, int end) {
        while (start < end) {
            char temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution541 s = new Solution541();
        String str = "abcdefg";
        int k = 2;
        System.out.println(s.reverseStr(str, k));
        System.out.println(str.substring(1));
    }
}
