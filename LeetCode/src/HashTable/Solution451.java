package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ginolee on 3/19/17.
 * 1st: create a hashtable <Character, Frequency>
 * 2nd: create an array, whose index is corresponding frequency & contains a list of characters with same frequency
 * 3rd: convert this array to a string
 */
public class Solution451 {
    public String frequencySort(String s) {
        // 1st step:
        char[] sArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (char c : sArray) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }
        // 2nd step:
        List<Character>[] charList = dict2ListArray(map, maxFreq);
        return list2String(charList);
    }

    private List<Character>[] dict2ListArray(Map<Character, Integer> map, int max) {
        List<Character>[] charList = new List[max + 1];
        for (char c : map.keySet()) {
            int freq = map.get(c);
            if (charList[freq] == null) {
                charList[freq] = new ArrayList<>();
            }
            charList[freq].add(c);
        }
        return charList;
    }

    private String list2String(List<Character>[] charList) {
        StringBuilder sb = new StringBuilder();
        for (int i = charList.length - 1; i > 0; i--) {
            List<Character> curList = charList[i];
            if (curList != null) {
                for (char c : curList) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution451 s = new Solution451();
        System.out.println("\n ----- self-testing of list");

        System.out.println("\n ----- self-testing of dict2ListArray()");
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('c', 2);
        map.put('b', 3);
        map.put('d', 3);
        int max = 3;
        List<Character>[] charList = s.dict2ListArray(map, max);
        for (int i = 0; i < charList.length; i++) {
            if (charList[i] != null) {
                System.out.println(charList[i].toString());
            } else {
                System.out.println("Empty");
            }
        }

        System.out.println("\n ----- self-testing of list2String()");
        System.out.println(s.list2String(charList));

        System.out.println("\n ----- self-testing");
        String input = "accbbbddd";
        System.out.println(s.frequencySort(input));

    }
}
