package BackTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 2/25/17.
 */
public class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> output = new LinkedList<>();
        String parenthesis = "";
        backTrack(output, parenthesis, n, 0, 0);
        return output;
    }

    private void backTrack(List<String> output, String parenthesis, int numParen, int left, int right) {
        // base case:
        if (parenthesis.length() == 2 * numParen) {
            output.add(new String(parenthesis));
        } else {
            // recursion:
            if (left < numParen) {
                backTrack(output, parenthesis + "(", numParen, left + 1, right);
            }
            if (right < left) {
                backTrack(output, parenthesis + ")", numParen, left, right + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution22 s = new Solution22();
        System.out.println(s.generateParenthesis(3));
    }
}
