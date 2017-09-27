package HashTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by ginolee on 3/17/17.
 */
public class Solution500 {
    public String[] findWords(String[] words) {
        // create a hashtable --> with distinct index
        String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < keyboard.length; i++) {
            char[] charArray = keyboard[i].toCharArray();
            for (char c : charArray) {
                m.put(c, i);
            }
        }
        // examine the input
        List<String> result = new LinkedList<>();
        for (String w : words) {
            boolean isOneLine = true;
            char[] wordChar = w.toLowerCase().toCharArray();
            int firstIndex = m.get(wordChar[0]);
            for (int i = 1; i < wordChar.length; i++) {
                if (m.get(wordChar[i]) != firstIndex) {
                    isOneLine = false;
                    break;                              // once it's not in 1 line, no need to compare further
                }
            }
            // add to the list
            if (isOneLine) {
                result.add(w);
            }
        }
        return result.toArray(new String[0]);           // what's this mean?
    }

    public static void main(String[] args) {
        Solution500 s = new Solution500();
        System.out.println("self-testing");
        String[] input = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(s.arrayToString(s.findWords(input)));
    }

    private String arrayToString(String[] stringArray) {
        String output = "[ ";
        for (String s : stringArray) {
            output += (s + " ");
        }
        return output + "]";
    }
}
