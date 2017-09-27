package OA;

import TwoPointer.InterleavePositiveNegativeNumbers;

import java.util.*;
import java.util.Map;

/**
 * Created by ginolee on 9/9/17.
 */
public class OANetEase {
    public String problem1(int i) {
        StringBuilder sb = new StringBuilder();
        while (i > 0) {
            if (i % 2 == 0) {
                i = (i - 2) / 2;
                sb.insert(0, 2);
            } else {
                i = (i - 1) / 2;
                sb.insert(0, 1);
            }
        }
        return sb.toString();
    }

    public double problem2(String input) {
        char[] strArray = input.toCharArray();
        int curCnt = 1, num = 1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 1; i < strArray.length; i++) {
            if (strArray[i] == strArray[i - 1]) {
                curCnt++;
            } else {
                curCnt = 1;
                num++;
            }
            // update the map
            char curKey = strArray[i];
            int prevCnt;
            if (!map.containsKey(curKey)) {
                prevCnt = 0;
                map.put(curKey, 0);
            } else {
                prevCnt = map.get(curKey);
            }
            map.put(curKey, Math.max(prevCnt, curCnt));
        }
        // calculate the res
        double res = 0;
        for (int i = 0; i < strArray.length; i++) {
            if (i == 0 || strArray[i] != strArray[i - 1]) {
                res += map.get(strArray[i]);
            }
        }
//        System.out.println(res);
        return res / num;
    }

    // for problem 3
    public int problem3(int numOfPar, String curPar) {
        List<String> pos = generateParenthesis(numOfPar);
        char[] curParArray = curPar.toCharArray();
        int max = 0, res = 0;
        for (String s : pos) {
            // skip duplication
            if (s.equals(curPar)) {
                continue;
            }
            char[] sArray = s.toCharArray();
            int longest = lcs(curParArray, sArray, curParArray.length, sArray.length);
            if (longest > max) {
                max = longest;
                res = 1;
            } else if (longest == max) {
                res++;
            }
        }
        return res;
    }

    public int lcs(char[] X, char[] Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X[m - 1] == Y[n - 1])
            return 1 + lcs(X, Y, m - 1, n - 1);
        else
            return Math.max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
    }

    public List<String> generateParenthesis(int n) {
        String cur = "";
        List<String> res = new LinkedList<>();
        backtrack(n, n, cur, res);
        return res;
    }

    private void backtrack(int numLeft, int numRight, String cur, List<String> res) {
        // base case
        if (numLeft == 0 && numRight == 0) {
            res.add(new String(cur));
            return;
        }
        // recursion
        if (numLeft > 0) {
            cur += "(";
            backtrack(numLeft - 1, numRight, cur, res);
            cur = cur.substring(0, cur.length() - 1);
        }
        if (numRight > numLeft) {
            cur += ")";
            backtrack(numLeft, numRight - 1, cur, res);
            cur = cur.substring(0, cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("\n ------ self-testing of problem1");
        OANetEase oaNet = new OANetEase();
        System.out.println(oaNet.problem1(9));

        System.out.println("\n ------ self-testing of problem2");
        String input = "aaabbaaac";
        System.out.println(oaNet.problem2(input));

        System.out.println("\n ------ self-testing of problem3");
        char[] X = "(())()".toCharArray(), Y = "()(())".toCharArray();
        System.out.println(oaNet.lcs(X, Y, X.length, Y.length));
        System.out.println(oaNet.generateParenthesis(3));
        System.out.println(oaNet.problem3(3, "(())()"));
    }
}
