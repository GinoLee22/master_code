package HashTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by ginolee on 5/28/17.
 */
public class Solution599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();        // (K, V) --> (String, index)
        List<String> result = new LinkedList<>();
        int min = Integer.MAX_VALUE;                        // record minimum value of index sum
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        // determine if str in list2 contained by dictionary
        for (int i = 0; i < list2.length; i++) {
            int idx = map.getOrDefault(list2[i], -1);           // if no key --> return -1
            if (idx != -1) {                // overlapping scenario
                if (i + idx < min) {
                    result = new LinkedList<>();
                }
                result.add(list2[i]);
            }
        }
//        return result.toArray(new String[0]);
        return null;
    }
}
