package String;

/**
 * Created by ginolee on 7/9/17.
 */
public class Solution38 {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = getString(result);
        }
        return result;
    }

    private String getString(String prevStr) {
        String result = "";
        char[] sArray = prevStr.toCharArray();
        int counter = 1;
        for (int i = 0; i < sArray.length; i++) {
            if (i == sArray.length - 1 || sArray[i] != sArray[i + 1]) {     // it reach the end of the array
                result += counter + Character.toString(sArray[i]);
                counter = 1;
            } else {            // current character not equal to previous one
                counter++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution38 s = new Solution38();
        System.out.println(s.countAndSay(2));

    }
}
