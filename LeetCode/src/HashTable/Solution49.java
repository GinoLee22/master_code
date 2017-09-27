package HashTable;

import num1.Solution;

import java.util.*;

/**
 * Created by ginolee on 2/28/17.
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {                     // can be replaced by: for (String s : strs)
            char[] cArray = strs[i].toCharArray();
            Arrays.sort(cArray);
            String key = String.valueOf(cArray);
            // if contain key --> add the list. if not contain --> add key
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution49 s = new Solution49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(s.groupAnagrams(strs));
    }
}
