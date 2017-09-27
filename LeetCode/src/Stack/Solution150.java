package Stack;

import BinarySearch.Interval;

import java.util.Stack;

/**
 * Created by ginolee on 7/2/17.
 */
public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            int a, b;
            switch(token) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b + a);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b * a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b / a);
                    break;
                default:
                    stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }


}
