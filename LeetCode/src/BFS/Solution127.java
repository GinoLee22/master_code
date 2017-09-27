package BFS;

import java.util.*;

/**
 * Created by ginolee on 7/3/17.
 */
public class Solution127 {
    /**
     * find the shortest path --> typical BFS structure
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String str : wordList) {
            dict.add(str);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String curNode = queue.poll();
                // check the result
                if (curNode.equals(endWord)) {
                    return level;
                }
                // change the word
                for (int m = 0; m < curNode.length(); m++) {
                    char[] wordArray = curNode.toCharArray();
                    for (char n = 'a'; n <= 'z'; n++) {
                        wordArray[m] = n;
                        String curStr = String.valueOf(wordArray);
                        if (!dict.contains(curStr)) {
                            continue;
                        }
                        dict.remove(curStr);
                        queue.add(curStr);
                    }
                }
            }
        }
        return -1;  // won't be here
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution127 s = new Solution127();
        String beginWord = "hit", endWord = "cog";
        String[] strArray = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(strArray);
        System.out.println(s.ladderLength(beginWord, endWord, wordList));
    }
}
