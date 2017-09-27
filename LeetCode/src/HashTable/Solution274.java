package HashTable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ginolee on 5/25/17.
 */
public class Solution274 {
    public int hIndex(int[] citations) {
        Integer[] copy = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            copy[i] = citations[i];
        }
        Arrays.sort(copy, (a, b) -> (b - a));
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] < i + 1) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution274 s = new Solution274();
        int[] citations = {3, 0, 6, 1, 5};

        System.out.println(s.hIndex(citations));
    }
}
