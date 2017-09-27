package String;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 7/13/17.
 */
public class Solution539 {
    /**
     * works as rolling sequence. 1. sort it 2. add the first element. 3. compare the difference
     */
    public int findMinDifference(List<String> timePoints) {
        // 1st: sort it based on integer
        Collections.sort(timePoints);
        // 2nd: add the 1st element to last with adding 24 hours
        String[] headTime = timePoints.get(0).split(":");
        String newStr = (Integer.parseInt(headTime[0]) + 24) + ":" + headTime[1];
        timePoints.add(newStr);
        System.out.println(timePoints);
        // 3rd: compare the difference one by on
        int minM = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size() - 1; i++) {
            String[] sArray1 = timePoints.get(i).split(":"), sArray2 = timePoints.get(i + 1).split(":");
            int res = (Integer.parseInt(sArray2[0]) - Integer.parseInt(sArray1[0])) * 60
                    + (Integer.parseInt(sArray2[1]) - Integer.parseInt(sArray1[1]));
            minM = Math.min(res, minM);
        }
        return minM;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution539 s = new Solution539();
        List<String> timePoints = new LinkedList<>();
        timePoints.add("23:00");
        timePoints.add("00:00");
        System.out.println(timePoints);
        System.out.println(s.findMinDifference(timePoints));
    }
}
