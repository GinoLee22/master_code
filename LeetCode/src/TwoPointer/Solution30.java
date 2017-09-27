package TwoPointer;

import BinarySearch.Interval;

import java.util.*;

/**
 * Created by ginolee on 7/4/17.
 */
public class Solution30 {
    /**
     * slicing window algorithm
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        // corner case
        if (s == null || words == null || words[0].length() > s.length()) {
            return result;
        }
        // create the map
        Map<String, Integer> map = new HashMap<>();         // (K, V): (String in words, freq)
        for (String cur : words) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        // reduce the map
        int step = words[0].length();
        for (int i = 0; i < step; i++) {
            Map<String, Integer> curMap = new HashMap<>(map);
            int counter = curMap.size(), start = i, end = i;;
            while (end + step <= s.length()) {
                String endStr = s.substring(end, end + step);
                if (curMap.containsKey(endStr)) {
                    curMap.put(endStr, curMap.get(endStr) - 1);
                    if (curMap.get(endStr) == 0) {
                        counter--;
                    }
                }
                end += step;
                // recover the map
                while (counter == 0) {
                    if (end - start == words.length * step) {
                        result.add(start);
                    }

                    String startStr = s.substring(start, start + step);
                    if (curMap.containsKey(startStr)) {
                        curMap.put(startStr, curMap.get(startStr) + 1);
                        if (curMap.get(startStr) > 0) {
                            counter++;
                        }
                    }
                    start += step;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution30 s = new Solution30();
        String str = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = {"fooo","barr","wing","ding","wing"};
        System.out.println(s.findSubstring(str, words));
    }
}
