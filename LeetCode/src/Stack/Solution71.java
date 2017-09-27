package Stack;

import java.util.Stack;

/**
 * Created by ginolee on 7/2/17.
 */
public class Solution71 {
    public String simplifyPath(String path) {
        String[] sArray = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : sArray) {
            if (!s.equals(".") && !s.equals("..") && !s.equals("")) {
                System.out.println(s);
                stack.add(s);
            } else if (s.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
        }
        System.out.println(stack);
        String result = "";
        for (String s : stack) {
            System.out.println(s);
            result = "/" + s + result;
        }
        return result.length() == 0 ? "/" : result;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution71 s = new Solution71();
        String str = "/a/b/c/..";
        System.out.println(s.simplifyPath(str));
    }
}
