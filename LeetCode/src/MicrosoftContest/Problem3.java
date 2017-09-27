package MicrosoftContest;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

/**
 * Created by ginolee on 9/7/17.
 */
public class Problem3 {

    public void staffExists() throws IOException {
        String filePath = new File("").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(filePath + "/PracticeInput (4).txt"));
        try {
            String line = null;
            int num = 0;
            while ((line = reader.readLine()) != null) {
                // self method
                helper(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            reader.close();
        }
        System.out.println();
    }

    public static void helper(String str) {
        if(isSymmetric(str)) {
            System.out.println("Not symmetric");
        } else {
            System.out.println("Symmetric");
        }
    }

    public static boolean isSymmetric(String str) {
        if(str.equals("")) return false;

        List<List<Integer>> matrix = new ArrayList<>();

        String[] rows = str.trim().split(";");
        for(String row : rows) {
            List<Integer> rowList = new ArrayList<>();
            String[] nums = row.trim().split(",");
            for(String num : nums) {
                rowList.add(Integer.parseInt(num.trim()));
            }
            matrix.add(new ArrayList<>(rowList));
        }

        int n = matrix.size();
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(matrix.get(i).get(j) != matrix.get(j).get(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Problem3 p = new Problem3();
//        p.staffExists();

        String s1 = "foo";
        String s2 = "foo";
        System.out.println(s1 == "foo");
        System.out.println(s1.equals(s2));
    }
}
