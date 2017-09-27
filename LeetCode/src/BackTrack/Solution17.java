package BackTrack;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ginolee on 3/4/17.
 */
public class Solution17 {
    // BFS problem
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new LinkedList<>();
        }

        String[] stringMap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> output = new LinkedList<>();
        char[] cArray = digits.toCharArray();
        output.add("");
        for (int i = 0; i < digits.length(); i++) {
            int curNumb = Character.getNumericValue(cArray[i]);
            while (output.peek().length() == i) {
                String curString = output.poll();
                for (char c : stringMap[curNumb].toCharArray()) {
                    output.add(curString + c);
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution17 s = new Solution17();
        String digits = "23";
        System.out.println(s.letterCombinations(digits));
    }

}
