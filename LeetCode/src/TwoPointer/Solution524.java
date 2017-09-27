package TwoPointer;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 3/26/17.
 */
public class Solution524 {
    public String findLongestWord(String s, List<String> d) {
        if (s == null || d == null) {
            return "";
        }

        Collections.sort(d, (a, b) -> a.compareTo(b));
        String result = "";
        char[] sArray = s.toCharArray();
        for (String elt : d) {
            char[] dArray = elt.toCharArray();
            int sIndex = 0, dIndex = 0;
            while (dIndex < dArray.length) {
                // check if it is out of "String s"
                if (sIndex >= s.length()) {
                    break;
                }
                if (sArray[sIndex] == dArray[dIndex]) {
                    dIndex++;
                }
                sIndex++;
            }
            // not exit
            if (sIndex >= s.length() && dIndex < elt.length()) {
                result = (result.length() > 0) ? result : "";
            } else {
                result = (elt.length() > result.length()) ? elt : result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution524 s = new Solution524();
        System.out.println("\n ----- self-testing of looping in the list");
        List<String> l = new LinkedList<>();
        l.add("a");
        l.add("b");
        l.add("c");
        for (String elt : l) {
            System.out.println(elt.toString());
        }

        System.out.println("\n ----- self-testing of sorting");
        List<String> unSorted = new LinkedList<>();
        unSorted.add("ba");
        unSorted.add("ab");
        unSorted.add("a");
        unSorted.add("b");
        System.out.println(unSorted);
        Collections.sort(unSorted, (a, b) -> a.compareTo(b));
        System.out.println(unSorted);

        System.out.println("\n ----- self-testing");
        String input1 = "abpcplea";
        List<String> d1 = new LinkedList<>();
        d1.add("ale");
        d1.add("apple");
        d1.add("monkey");
        d1.add("plea");
        System.out.println(s.findLongestWord(input1, d1));


        String input2 = "abpcplea";
        List<String> d2 = new LinkedList<>();
        d2.add("a");
        d2.add("b");
        d2.add("c");
        System.out.println(s.findLongestWord(input2, d2));

        String input3 = "aaa";
        List<String> d3 = new LinkedList<>();
        d3.add("aaa");
        d3.add("aa");
        d3.add("a");
        System.out.println(s.findLongestWord(input3, d3));
    }
}
