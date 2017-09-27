package Math;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created by ginolee on 7/14/17.
 */
public class Solution171 {
    public int titleToNumber(String s) {
        char[] sArray = s.toCharArray();
        int result = 0;
        for (int i = 0; i < sArray.length; i++) {
            result = 26 * result + (sArray[i] - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution171 s = new Solution171();
        System.out.println(s.titleToNumber("AB"));
    }
}
