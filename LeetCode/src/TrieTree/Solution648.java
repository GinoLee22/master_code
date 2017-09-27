package TrieTree;

import java.util.*;

/**
 * Created by ginolee on 8/21/17.
 */
class TrieNode{
    char c;
    Map<Character, TrieNode> children = new HashMap<>();
    boolean hasWord;

    public TrieNode() {

    }

    public TrieNode(char c) {
        this.c = c;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        Map<Character, TrieNode> curChildren = root.children;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            char curKey = wordArray[i];
            if (curChildren.containsKey(curKey)) {
                cur = curChildren.get(curKey);
            } else {
                TrieNode newNode = new TrieNode(curKey);
                curChildren.put(curKey, newNode);
                cur = newNode;
            }
            curChildren = cur.children;
            // deal with the last character
            if (i == word.length() - 1) {
                cur.hasWord = true;
            }
        }
    }
    /**
     * has prefix -> return the shortest one
     * no prefix -> return the orginal one
     */
    public String getShortestReplace(String word) {
        StringBuilder sb = new StringBuilder();
        TrieNode cur = root;
        Map<Character, TrieNode> curChildren = root.children;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            char curKey = wordArray[i];
            if (curChildren.containsKey(curKey)) {
                sb.append(curKey);
                cur = curChildren.get(curKey);
                curChildren = cur.children;
                if (cur.hasWord) {
                    return sb.toString();
                }
            } else {
                return word;
            }
        }
        return sb.toString();       // won't reach here
    }

}


class Solution648 {
    /**
     * this is typical problem of Trie because it requires to implement "startwith" method
     */
    public String replaceWords(List<String> dict, String sentence) {
        // construct the trie
        Trie trie = new Trie();
        for (String str : dict) {
            trie.insert(str);
        }
        // replacement
        StringBuilder sb = new StringBuilder();
        String[] strArray = sentence.split(" ");
        for (String word : strArray) {
            String replace = trie.getShortestReplace(word);
            sb.append(replace);
            sb.append(" ");
        }
        return sb.substring(0, sb.length()-1);
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        List<String> dict = new LinkedList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String sentence = "the cattle was rattled by the battery";
        Solution648 s = new Solution648();
        String res = s.replaceWords(dict, sentence);
        System.out.println(res);
    }
}