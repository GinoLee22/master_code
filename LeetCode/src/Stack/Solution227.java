package Stack;

import java.util.Stack;

/**
 * Created by ginolee on 9/12/17.
 */
public class Solution227 {
    public int calculate(String s) {
        char[] sArray = s.toCharArray();
        int res = 0, curNum = 0;
        char ope = '+';
        Stack<Integer> stack = new Stack<>();
        for (char c : sArray) {
            if (Character.isDigit(c)) {
                curNum = 10 * curNum + c - '0';
            } else if (c == '+' || c == '-') {
                if (ope == '+') {
                    stack.push(curNum);
                } else if (ope == '-') {
                    stack.push(-curNum);
                } else if (ope == '*' || ope == '/') {
                    res = (ope == '*') ? res * curNum : res / curNum;
                    stack.push(res);
                    res = 0;
                }
                curNum = 0;
                ope = c == '+' ? '+' : '-';
            } else if (c == '*' || c =='/') {
                if (ope == '+' || ope == '-') {
                    res = curNum;
                } else {
                    res = (ope == '*') ? res * curNum : res / curNum;
                }
                curNum = 0;
                ope = c == '*' ? '*' : '/';
            }
        }
        System.out.println(stack);
        int sum = 0;
        for (int val : stack) {
            sum += val;
        }
        System.out.println(ope);
        if (ope == '*' || ope == '/') {
            return sum + (ope == '*' ? res * curNum : res / curNum);
        }
        return sum + (ope == '+' ? curNum : -curNum);
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution227 s = new Solution227();
        System.out.println(s.calculate("3 + 2 * 2"));

    }
}
