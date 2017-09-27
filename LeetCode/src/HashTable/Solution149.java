package HashTable;

import java.util.*;

/**
 * Created by ginolee on 8/11/17.
 */
class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
public class Solution149 {
    /**
     * basic idea: slope as hashmap key
     */
    public int maxPoints(Point[] points) {
        Map<Double, Integer> map = new HashMap<>(); // (slope, freq)
        map.put(Double.MAX_VALUE, 0);              // vertical lines
        int max = 0;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = 1; j < points.length; j++) {
                int deltaX = points[i].x - points[j].x, deltaY = points[i].y - points[j].y;
                double slope;
                if (deltaX == 0) {              // vertical lines
                    slope = Double.MAX_VALUE;
                    map.put(slope, map.get(slope) + 1);
                } else {
                    slope = (double) deltaX / (double) deltaY;
                    map.put(slope, map.get(slope + 1));
                }
                max = Math.max(max, map.get(slope));
            }
        }
        return max;
    }
}
