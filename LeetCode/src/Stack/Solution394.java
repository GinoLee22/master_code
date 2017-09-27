package Stack;

import java.util.Stack;

/**
 * Created by ginolee on 9/13/17.
 */
public class Solution394 {
    public String decodeString(String s) {
        char[] sArray = s.toCharArray();
        Stack<Integer> intStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int curNum = 0;
        StringBuilder res = new StringBuilder();
        for (char c : sArray) {
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + c - '0';
            } else if (Character.isLetter(c)) {
                res.append(c);
            } else if (c == '[') {
                intStack.push(curNum);
                resStack.push(res.toString());
                curNum = 0;
                res.setLength(0);
            } else if (c == ']') {
                int rep = intStack.pop();
                String level = res.toString();
                for (int i = 0; i < rep - 1; i++) {
                    res.append(level);
                }
                res.insert(0, resStack.pop());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution394 s = new Solution394();
        System.out.println(s.decodeString("3[a2[c]]"));
        System.out.println(s.decodeString("3[bc]2[c]"));
    }
}
