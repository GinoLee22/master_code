package MicrosoftContest;

import java.io.*;
import java.util.Arrays;

/**
 * Created by ginolee on 9/7/17.
 */
public class Solution2 {

    public void staffExists() throws IOException {
        String filePath = new File("").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(filePath + "/Calendar-confusion_InputForSubmission_1.txt"));
        try {
            String line = null;
            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
                // self method
                String[] input = line.split(" ");
                String output = changeFormat(input[0], input[1], input[2]);
                System.out.println(output);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            reader.close();
        }
        System.out.println();
    }

    public String changeFormat(String data, String oldForm, String newForm) {
        String[] dateArray = data.split("\\W");
        String[] oldArray = oldForm.split("\\W");
        String[] newArray = newForm.split("\\W");
        // find the value of y,m,d
        int y = 0, m = 0, d = 0;
        for (int i = 0; i < 3; i++) {
            if (oldArray[i].contains("y")) {
                y = Integer.parseInt(dateArray[i]);
            } else if (oldArray[i].contains("m")) {
                m = Integer.parseInt(dateArray[i]);
            } else if (oldArray[i].contains("d")) {
                d = Integer.parseInt(dateArray[i]);
            }
        }

        // find the new separator
        String sep = "";
        for (int i = 0; i < newForm.length(); i++) {
            if (!Character.isLetter(newForm.charAt(i))) {
                sep += newForm.charAt(i);
                break;
            }
        }
        // form the new string
        String month = (m < 10) ? "0" + m : "" + m;
        String day = (d < 10) ? "0" + d : "" + d;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            if (newArray[i].contains("y")) {
                sb.append(y).append(sep);
            } else if (newArray[i].contains("m")) {
                sb.append(month).append(sep);
            } else if (newArray[i].contains("d")) {
                sb.append(day).append(sep);
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) throws IOException{
        Problem1 p = new Problem1();
        p.staffExists();
    }

}
