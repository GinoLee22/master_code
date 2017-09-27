package MicrosoftContest;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ginolee on 9/7/17.
 */
public class Problem6 {

    public void staffExists() throws IOException {
        String filePath = new File("").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(filePath + "/Moon-Box_InputForSubmission_1.txt"));
        try {
            String line = null;
            String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "";
            int cnt = 0;
            while ((line = reader.readLine()) != null) {
                // self method
                if (cnt == 0) {
                    s1 = line;
                } else if (cnt == 1) {
                    s2 = line;
                } else if (cnt == 2) {
                    s3 = line;
                } else if (cnt == 3) {
                    s4 = line;
                } else {
                    s5 = line;
                }
                cnt++;
            }
            help(s1, s2, s3, s4, s5);


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            reader.close();
        }
        System.out.println();
    }

    public void help(String s1, String s2, String s3, String s4, String s5) {
        int len = s1.length();
        StringBuilder sb= new StringBuilder();
        int[] mask = new int[] {1, 1, 1, 1, 1};
        for (int i = 0; i < len; i++) {
            char[] curLevel = new char[5];
            curLevel[0] = s1.charAt(i);
            curLevel[1] = s2.charAt(i);
            curLevel[2] = s3.charAt(i);
            curLevel[3] = s4.charAt(i);
            curLevel[4] = s5.charAt(i);

            Map<Character, Integer> map = new HashMap<>();
            for (char c : curLevel) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int max = 0;
            char right = '0';           // right character
            for (Character key : map.keySet()) {
                if (map.get(key) > 0) {
                    max = map.get(key);
                    right = key;
                }
            }
            sb.append(right);
            for (int m = 0; m < 5; m++) {
                if (curLevel[m] != right) {
                    mask[m] = 0;
                }
            }
        }
        // counting
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (mask[i] == 1) {
                cnt++;
            }
        }
        // print
        System.out.println(sb.toString());
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException{
        Problem6 p = new Problem6();
        p.staffExists();
//        String s1 = "Alpha Bravo Charlie";
//        String s2 = "Alpha Bravo Charlie";
//        String s3 = "Alpha Bravo Charlie";
//        String s4 = "Alppa Bravo Charlie";
//        String s5 = "Alpha Bravo Charlie";
//        p.help(s1,s2,s3,s4,s5);
    }

}
