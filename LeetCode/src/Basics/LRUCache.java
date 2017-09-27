package Basics;

/**
 * Created by ginolee on 9/14/17.
 */

/**
 * This is a classical problem that should be completedly, rapidly without any mistakes
 * Double-Linked-List for key & value
 * HashMap for O(1) search
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 1. get(): return value + move to tail
 * 2. set(): if has key -> change value and move to tail
 *           if no      -> add it and remove head
 */
public class LRUCache {
    Map<Integer, DListNode> cacheMap;
    DList cacheDList;
    int capacity;

    public LRUCache(int capacity) {
        cacheMap = new HashMap<>();
        cacheDList = new DList();
        this.capacity = capacity;
    }

    /**
     * Note: get cache change the cache list as well
     */
    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        DListNode node = cacheMap.get(key);
        cacheDList.removeNode(node);
        cacheDList.insertTail(node);
        return node.val;
    }

    /**
     * if DList.size >= capacity -> remove BOTH DLIST & HashMap
     * otherwise -> just input
     */
    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            DListNode oldNode = cacheMap.get(key);
            cacheDList.removeNode(oldNode);
            DListNode newNode = new DListNode(key, value);
            cacheDList.insertTail(newNode);
            cacheMap.put(key, newNode);
            return;
        }

        // not contains the key
        DListNode newNode = new DListNode(key, value);
        if (cacheDList.size == capacity) {      // remove the 1st listnode & add a new one
            int removeKey = cacheDList.removeFront();
            cacheMap.remove(removeKey);
        }
        cacheDList.insertTail(newNode);
        cacheMap.put(key, newNode);
    }

    public static void main(String[] args) {
        System.out.println("self-testing of Doublely-Linked-List");
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
