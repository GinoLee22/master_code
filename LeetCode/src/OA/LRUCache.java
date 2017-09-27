package OA;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ginolee on 9/18/17.
 */
class LRUCache {
    // LinkedHashMap can specify a capacity
    LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedHashMap(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return map.size() > capacity;
            }
        };
    }

    // get operation won't change the capacity
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
