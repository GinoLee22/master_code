package HashTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by ginolee on 2/28/17.
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();          // key: char --> value: integer index
        int prev = 0, max = 0;                                  // prev: previous index.    max: longest length
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            // keep mind: always have to update "max" because the special case: [a b c b z z z z z a] because the contained value may not be included by "prev"
            if (map.containsKey(cur)) {
                prev = Math.max(prev, map.get(cur) + 1);        // prev index can't go back
            }
            max = Math.max(max, i - prev + 1);
            map.put(cur, i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("self-testing of HashMap");
        HashMap<Character, Integer> m = new HashMap<>();
        m.put('a', 1);
        System.out.println(m);
        m.put('a', 2);
        System.out.println(m);


        System.out.println("self-testing");
        Solution3 s = new Solution3();
        String string1 = "abcabcbb";
        String string2 = "bbbbb";
        String string3 = "pwwkew";
        String string4 = "c";
        String string5 = "tmmzuxt";

        System.out.println(s.lengthOfLongestSubstring(string1));
        System.out.println(s.lengthOfLongestSubstring(string2));
        System.out.println(s.lengthOfLongestSubstring(string3));
        System.out.println(s.lengthOfLongestSubstring(string4));
        System.out.println(s.lengthOfLongestSubstring(string5));

    }
}
