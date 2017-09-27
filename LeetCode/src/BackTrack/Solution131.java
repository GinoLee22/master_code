package BackTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 8/1/17.
 */
public class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        // corner case
        if (s == null || s.length() == 0) {
            return res;
        }
        List<String> cur = new LinkedList<>();
        backtrack(s, 1, cur, res);
        return res;
    }

    private void backtrack(String curStr, int cut, List<String> cur, List<List<String>> res) {
        // base case
        if ((isPalindrome(curStr.substring(0, cut)) && isPalindrome(curStr.substring(cut, curStr.length())))) {
            res.add(new LinkedList(cur));
            return;
        }
        for (int i = 1; i < curStr.length(); i++) {
            cur.add(curStr.substring(0, cut));
            backtrack(curStr.substring(cut, curStr.length()), i, cur, res);
            cur.remove(cur.size() - 1);
        }
    }

    private boolean isPalindrome(String str) {
        char[] strArray = str.toCharArray();
        int start = 0, end = strArray.length - 1;
        while (start < end) {
            if (strArray[start] != strArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution131 s = new Solution131();
        String str = "aab";
        System.out.println(s.isPalindrome(str));
        System.out.println(s.partition(str));
    }
}
