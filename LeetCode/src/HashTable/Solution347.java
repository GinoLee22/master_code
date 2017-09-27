package HashTable;

import java.util.*;

/**
 * Created by ginolee on 3/20/17.
 */
public class Solution347 {
//    public List<Integer> topKFrequent(int[] nums, int k) {
////        // create a hashmap
////        Map<Integer, Integer> map = new HashMap<>();
////        for (int elt : nums) {
////            map.put(elt, map.getOrDefault(elt, 0) + 1);
////        }
////
////        // create an array to store element based on frequency (frequency is the index)
////        List<Integer>[] listArray = new List[nums.length + 1];
////        for (int key : map.keySet()) {
////            int frequency = map.get(key);
////            if (listArray[frequency] == null) {
////                listArray[frequency] = new LinkedList<>();
////            }
////            listArray[frequency].add(key);
////        }
////
////        // operate to the final result
////        List<Integer> result = new LinkedList<>();
////        for (int i = nums.length; i >= 0 && result.size() < k; i--) {
////            if (listArray[i] != null) {
////                result.addAll(listArray[i]);
////            }
////        }
////        return result.subList(0, k);
//
//        /**
//         * Idea: use priority queue
//         */
//        // 1st: create a map to record the frequency
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            int freq = map.getOrDefault(num, 0);        // if containsKey --> get value; otherwise: 0
//            map.put(num, freq + 1);
//        }
//
//        // 2nd: use a priority queue to record the most frequent k elements
//        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            pq.offer(entry);
//            if (pq.size() > k) {
//                pq.poll();
//            }
//        }
//
//        // 3rd: create a list to return the most frequent term
//        List<Integer> result = new LinkedList<>();
//        while (!pq.isEmpty()) {
//            result.add(0, pq.poll().getKey());          // 0: means the index
//        }
//        return result;
//
//    }
    /**
     * This is a typical problem of "bucket sort" -> "array index" representing the corresponding index
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 1st: create a hashmap to represent the frequency, (num, freq)
        int maxFreq = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(num));
        }
        // 2nd: bucket sort
        List<Integer>[] bucket = new LinkedList[maxFreq + 1];
        // Integer[] bucket = new Integer[maxFreq + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            bucket[freq].add(key);
        }
        // 3rd: select the first k element
        List<Integer> res = new LinkedList<>();
        for (int i = bucket.length - 1; i > 0 && k >= 0; i--) {
            if (bucket[i] == null) {
                continue;
            }
            res.addAll(bucket[i]);
            k -= res.size();
        }
        return res;         // according to the problem assumption, won't get here
    }

    public static void main(String[] args) {
        int testing = '0';
        System.out.println(testing);
    }
}
