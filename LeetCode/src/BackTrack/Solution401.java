package BackTrack;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by ginolee on 2/28/17.
 */
public class Solution401 {
    // very brilliant idea: counting the number of bits
//    public List<String> readBinaryWatch(int num) {
//        List<String> times = new LinkedList<>();
//        for (int h = 0; h < 12; h++) {
//            for (int m = 0; m < 60; m++) {
//                if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
//                    times.add(String.format("%d:%02d", h, m));
//                }
//            }
//        }
//        return times;
//    }

    // self idea: back-track
    public List<String> readBinaryWatch(int num) {
        List<String> allList = new LinkedList<>();
        int[] index = new int[10];
        int[] content = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        backTract(allList, index, content, num, 0, 0);
        return allList;
    }


    // interface: index[]: record the index of the number added to the list. content[]: contain the content of the time. start should be 0 at the very first place
    private void backTract(List<String> allList, int[] index, int[] content, int num, int start, int counter) {
        // base case:
        if (counter == num) {
            String output = getTime(content, index);
            if (output != "Error") {
                allList.add(output);
            }
        } else {
            // recursion:
            for (int i = start; i < content.length; i++) {
//                curList.add(content[i]);
                index[i] = 1;
                backTract(allList, index, content, num, i + 1, counter + 1);
//                curList.remove(curList.size() - 1);
                index[i] = 0;
            }
        }
    }

    // transfer the combination to time string. If output is invalid minutes or hours --> don't add to the allList
    private String getTime(int[] content, int[] index) {
        // hours
        int hour = 0;
        for (int h = 0; h < 4; h++) {
            if (index[h] == 1) {
                hour += content[h];
            }
            // exam
            if (hour >= 12) {       // invalid hours
                return "Error";
            }
        }
        // minutes
        int minite = 0;
        for (int m = 4; m < 10; m++) {
            if (index[m] == 1) {
                minite += content[m];
            }
            // exam
            if (minite >= 60) {     // invalid minutes
                return "Error";
            }
        }
        // format the output
        if (minite < 10) {
            return hour + ":0" + minite;
        } else {
            return hour + ":" + minite;
        }
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing");
        Solution401 s = new Solution401();
        int num = 1;
        System.out.println(s.readBinaryWatch(num));
    }
}
