package TrieTree;
import java.util.*;

/**
 * Created by ginolee on 8/21/17.
 */

/**
 * LeetCode: #208
 * DataStructure TrieNode in Trie
 * 3 properties: current character
 *               children (stored in hashmap)
 *               hasWord: if it is the end of word
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
//
//}
//
//public class Trie {
//    private TrieNode root;
//
//    /** Initialize your data structure here. */
//    public Trie() {
//        root = new TrieNode();
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        TrieNode cur = root;
//        Map<Character, TrieNode> curChildren = root.children;
//        char[] wordArray = word.toCharArray();
//        // checking procedure: 1. curChildren contain the character? 2. move the pointers (cur & curChildren)
//        for (int i = 0; i < wordArray.length; i++) {
//            char curKey = wordArray[i];
//            if (curChildren.containsKey(curKey)) {
//                cur = curChildren.get(curKey);
//            } else {
//                TrieNode curNode = new TrieNode(curKey);
//                curChildren.put(curKey, curNode);
//                cur = curNode;
//            }
//            curChildren = cur.children;
//            // deal with the boolean
//            if (i == wordArray.length - 1) {
//                cur.hasWord = true;
//            }
//        }
//    }
//
//    /**
//     * return TrieNode representing the end of str. If no -> return null
//     * @param word
//     * @return
//     */
//    public TrieNode searchWordNodePos(String word) {
//        TrieNode cur = root;
//        Map<Character, TrieNode> curChildren = root.children;
//        char[] wordArray = word.toCharArray();
//        for (int i = 0; i < wordArray.length; i++) {
//            char curKey = wordArray[i];
//            if (curChildren.containsKey(curKey)) {
//                cur = curChildren.get(curKey);
//                curChildren = cur.children;
//            } else {
//                return null;
//            }
//        }
//        return cur;
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        TrieNode endNode = searchWordNodePos(word);
//        if (endNode == null) {
//            return false;
//        }
//        return endNode.hasWord;
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        TrieNode endNode = searchWordNodePos(prefix);
//        return endNode != null;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Trie DataStructure self-testing");
//        Trie obj = new Trie();
//        System.out.println("Trie contains 'aa', 'abc', 'bb'");
//        String word1 = "aa", word2 = "abc", word3 = "bb";
//        obj.insert(word1);
//        obj.insert(word2);
//        obj.insert(word3);
//        System.out.println("Trie contains 'aa' should return true. Result is: " + obj.search(word1));
//        System.out.println("Trie contains 'abc' should return true. Result is: " + obj.search(word2));
//        System.out.println("Trie contains 'bb' should return true. Result is: " + obj.search(word3));
//        System.out.println("Trie contains 'bc' should return false. Result is: " + obj.search("bc"));
//        System.out.println("Trie contains prefix 'ab' should return true. Result is: " + obj.startsWith("ab"));
//        System.out.println("Trie contains prefix 'zz' should return false. Result is: " + obj.startsWith("zz"));
//
//
//    }
//}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
