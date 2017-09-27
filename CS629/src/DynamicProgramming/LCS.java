package DynamicProgramming;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by ginolee on 3/1/17.
 * LCS is the short for: longest common subsequence
 */
public class LCS {

    /**
     *
     * @param string1
     * @param string2
     * @return int representing the longest
     */
    public int lcs (String string1, String string2) {
        char[] cString1 = string1.toCharArray(), cString2 = string2.toCharArray();
        int row = cString1.length + 1, column = cString2.length + 1;
        // length matrix: initially all is 0
        int[][] C = new int[row][column];
        for (int r = 0; r < cString1.length; r++) {
            for (int c = 0; c < cString2.length; c++) {
                // recursive idea: if x == y --> c[r][c] = c[r - 1][c - 1] + 1
                if (cString1[r] == cString2[c]) {
                    C[r + 1][c + 1] = C[r][c] + 1;

                } else {
                    C[r + 1][c + 1] = Math.max(C[r + 1][c], C[r][c + 1]);
                }
            }
        }
        return C[row - 1][column - 1];
    }

    public List<String> lcsString (String string1, String string2) {
        char[] cString1 = string1.toCharArray(), cString2 = string2.toCharArray();
        int row = cString1.length + 1, column = cString2.length + 1;
        // create a HashMap to store the corresponding string
        HashMap<String, String> map = new HashMap<>();

        int[][] C = new int[row][column];
        String longest;
        for (int r = 0; r < cString1.length; r++) {
            for (int c = 0; c < cString2.length; c++) {
                String key = (r + 1) + " " + (c + 1);
                if (cString1[r] == cString2[c]) {
                    C[r + 1][c + 1] = C[r][c] + 1;
                    String prevKey = r + " " + c;
                    longest = (map.get(prevKey) == null) ? Character.toString(cString1[r]) : map.get(prevKey) + Character.toString(cString1[r]);
                } else {
                    if (C[r + 1][c] > C[r][c + 1]) {
                        C[r + 1][c + 1] = C[r + 1][c];
                        String prevKey = (r + 1) + " " + c;
                        longest = (map.get(prevKey) == null) ? "" : map.get(prevKey);

                    } else {
                        C[r + 1][c + 1] = C[r][c + 1];
                        String prevKey = r + " " + (c + 1);
                        longest = (map.get(prevKey) == null) ? "" : map.get(prevKey);
                    }
                }
                map.put(key, longest);
            }
        }
        int max = C[row - 1][column - 1];
        List<String> allList = new LinkedList<>();
        // iterate the hashtable
        Set<String> set = map.keySet();
        for (String s : set) {
            if (map.get(s).length() == max) {
                allList.add(map.get(s));
            }
        }
        return allList;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        String string1 = "ABCBDAB", string2 = "BDCABA";
        LCS s = new LCS();
        System.out.println(s.lcs(string1, string2));
        System.out.println(s.lcsString(string1, string2));

    }
}
