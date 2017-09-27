package TwoSum;

/**
 * Created by ginolee on 8/25/17.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem Description
 * Design and implement a two-sum class. It should support the following operations: "add" and "find".
 * add - Add the number to an internal data structure
 * find - Find if there exits any pair of numbers which sum is equal to the value
 *
 * Example:
 * add(1); add(3); add(5);
 * find(4);     // return true
 * find(7);     // return false
 */
public class DataStructureDesign {
    /**
     * thought: it is difficult to maintain a sorted array -> use hashtable for operation "find"
     */

    // fields
    List<Integer> list;
    Map<Integer, Integer> map;          // (val, freq)

    // constructor
    public DataStructureDesign() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    // methods
    public void add(int num) {
        list.add(num);
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    public boolean find(int val) {
        for (int key : map.keySet()) {
            int cmp = val - key;
            if ((cmp == key && map.get(key) >= 2) || (cmp != key && map.containsKey(cmp))) {          // for duplicates
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        DataStructureDesign dsd = new DataStructureDesign();
        dsd.add(1);
        dsd.add(3);
        dsd.add(5);
        dsd.add(2);
        dsd.add(2);
        System.out.println(dsd.list);
        System.out.println(dsd.find(8));
        System.out.println(dsd.find(4));
    }

}
