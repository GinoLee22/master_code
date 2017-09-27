package HashTable;

/**
 * Created by ginolee on 3/18/17.
 */
public class Solution389 {
    public char findTheDifference(String s, String t) {
        int sumS = 0, sumT = 0;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (char c : sArray) {
            sumS += (int)c;             // note: "(int)c" takes much less time than "c - 'a'"
        }
        for (char c : tArray) {
            sumT += (int)c;
        }
        return (char)(sumT - sumS);
    }

    public static void main(String[] args) {
        Solution389 s = new Solution389();
        System.out.println("\n ----- self-testing");
        String string1 = "abcd";
        String string2 = "abcde";
        System.out.println(s.findTheDifference(string1, string2));
        

    }
}
