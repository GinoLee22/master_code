package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ginolee on 5/18/17.
 */
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        // 2 false scenario. 1st: same key --> different value. 2nd: different key --> same value
        Map<Character, Character> map = new HashMap<>();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (int i = 0; i < sArray.length; i++) {           // s & t have the same length
            // same key --> check if values are the same
            if (map.containsKey(sArray[i])) {
                if (!map.get(sArray[i]).equals(tArray[i])) {
                    return false;
                }
            } else {
                // different key --> check if values already in the dictionary
                if (map.containsValue(tArray[i])) {
                    return false;
                } else {
                    map.put(sArray[i], tArray[i]);
                }
            }
        }
        return true;
    }
}
