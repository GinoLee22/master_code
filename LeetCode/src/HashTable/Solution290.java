package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ginolee on 3/19/17.
 */
public class Solution290 {
    public boolean wordPattern(String pattern, String str) {
        // similar to #205 Isomorphic String
        char[] pArray = pattern.toCharArray();
        String[] sArray = str.split(" ");
        if (pArray.length != sArray.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pArray.length; i++) {           // here: assume lengths are the same
            // contain the same key --> check if value are the same
            if (map.containsKey(pArray[i])) {
                if (!map.get(pArray[i]).equals(sArray[i])) {
                    return false;
                }
            } else {        // not contain the key --> check if value is already in the "values"
                if (map.containsValue(sArray[i])) {
                    return false;
                } else {    // no same value --> add the dictionary
                    map.put(pArray[i], sArray[i]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution290 s = new Solution290();
        System.out.println("\n ----- self-testing");
        String pattern1 = "abba";
        String pattern2 = "abbc";
        String str = "dog cat cat dog";
        System.out.println(s.wordPattern(pattern1, str));
        System.out.println(s.wordPattern(pattern2, str));

    }
}
