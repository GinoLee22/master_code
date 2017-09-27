package HashTable;

/**
 * Created by ginolee on 3/19/17.
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        // key idea: use an array of length 26 to record the time or appearance
        // in "s": add the number. in "t": minus the number. Finally check if all equal to 0
        int[] alphabet = new int[26];               // this is HashMap
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (char sChar : sArray) {
            alphabet[sChar - 'a']++;
        }
        for (char tChar : tArray) {
            alphabet[tChar - 'a']--;
        }
        for (int value : alphabet) {
            if (value != 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing of self-increment of array element");
        int[] testing = {1, 2, 3, 4, 5};
        testing[3]++;
        System.out.println(testing[3]);
        int[] empty = new int[5];
        System.out.println("\n ----- the value of uninitialized array is " + empty[3]);

        Solution242 s = new Solution242();
        System.out.println("\n ----- self-testing");
        String s1 = "anagram";
        String t1 = "nagaram";
        String s2 = "rat";
        String t2 = "car";
        System.out.println(s.isAnagram(s1, t1));
        System.out.println(s.isAnagram(s2, t2));
    }
}
