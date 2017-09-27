package TrieTree;

/**
 * Created by ginolee on 8/21/17.
 */

import java.util.*;

/**
 * Leetcode: #211
 */

/**
 * TrieNode DataStructure
 */
//class TrieNode {
//    char c;
//    Map<Character, TrieNode> children = new HashMap<>();
//    boolean hasWord;
//
//    public TrieNode() {
//
//    }
//
//    public TrieNode(char c) {
//        this.c = c;
//    }
//}

class WordDictionary {
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        Map<Character, TrieNode> curChildren = cur.children;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            char curKey = wordArray[i];
            if (curChildren.containsKey(curKey)) {
                cur = curChildren.get(curKey);
            } else {        // not contains & should add
                TrieNode curNode = new TrieNode(curKey);
                curChildren.put(curKey, curNode);
                cur = curNode;
            }
            curChildren = cur.children;
            // cope with the end character
            if (i == wordArray.length - 1) {
                cur.hasWord = true;
            }
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    /**
     * DFS procedure -> use a help function
     * @param word
     * @return
     */
    public boolean search(String word) {
        return dfsFind(word, 0, root);
    }

    public boolean dfsFind(String word, int curIdx, TrieNode cur) {
        // base case: curIdx represents the last TrieNode
        if (curIdx == word.length()) {
            return cur.hasWord;
        }
        // recursion
        char c = word.charAt(curIdx);
        if (c != '.') {
            if (cur.children.containsKey(c)) {
                return dfsFind(word, curIdx + 1, cur.children.get(c));
            } else {
                return false;
            }
        } else {        // c == '.'
            boolean res = false;
            for (char curKey : cur.children.keySet()) {
                res = (res || dfsFind(word, curIdx + 1, cur.children.get(curKey)));
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        WordDictionary obj = new WordDictionary();
        String word1 = "ba", word2 = "bbb";
        obj.addWord(word1);
        obj.addWord(word2);
        System.out.println(obj.search("b.."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */