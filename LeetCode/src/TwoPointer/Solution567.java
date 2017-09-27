package TwoPointer;

import java.util.*;

/**
 * Created by ginolee on 7/4/17.
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        // corner case
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        // create a map
        Map<Character, Integer> map = new HashMap<>();      // (K, V) --> (Char, freq)
        char[] s1Array = s1.toCharArray(), s2Array = s2.toCharArray();
        int start = 0, end = 0;
        for (char c : s1Array) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // reduce the map
        int counter = map.size();
        System.out.println(map);
        while (end < s2Array.length) {
            char endChar = s2Array[end];
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) {
                    counter--;
                }
            }
            end++;
            // recover the map
            while (counter == 0) {
                if (end - start == s1Array.length) {
                    System.out.println(end);
                    System.out.println(start);
                    return true;
                }
                char startChar = s2Array[start];
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0) {
                        counter++;
                    }
                }
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution567 s = new Solution567();
        String s1 = "hello", s2 = "ooolleoooleh";
        System.out.println(s.checkInclusion(s1, s2));
    }
}
