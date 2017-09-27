package MicrosoftContest;

import java.io.*;
import java.util.Arrays;

/**
 * Created by ginolee on 9/7/17.
 */
public class Problem2 {

    public void staffExists() throws IOException {
        String filePath = new File("").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(filePath + "/Harmony-of-Ones_InputForSubmission_1.txt"));
        try {
            String line = null;
            int num = 0;
            while ((line = reader.readLine()) != null) {
                // self method
                int cnt = 0;
                if (num == 0) {
                    cnt = Integer.parseInt(line);
                } else {
                    String[] input = line.split("\\W");
                    System.out.println(helper(Integer.parseInt(input[0]), Integer.parseInt((input[1]))));
                }
                num++;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            reader.close();
        }
        System.out.println();
    }

    public int helper(int a, int b) {
        int count = 0;
        while(a > 0 && b > 0) {
            if(((a & 1) & (b & 1) )== 1) {
                count++;
            }
            a = a >> 1;
            b = b >> 1;
        }
        return count;
    }



    public static void main(String[] args) throws IOException{
        Problem2 p = new Problem2();
        p.staffExists();
    }

}
