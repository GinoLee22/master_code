package Interview;

import java.util.*;

/**
 * Created by ginolee on 2/26/17.
 * OA of liveRamp
 */

public class liveRamp {
    /**
     * 1st one
     */
    public String timeLine(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> curList = new LinkedList<>();
        Arrays.sort(nums);
        String maxTime = "";
        boolean[] used = new boolean[4];
        backTrack(output, curList, nums, used);
        // compare the time: 1st should exam if it is valid
        int maxHour = Integer.MIN_VALUE, maxMinute = Integer.MIN_VALUE;
        for (int i = 0; i < output.size(); i++) {
            List<Integer> singleTime = output.get(i);
            int curHour = 10 * singleTime.get(0) + singleTime.get(1);
            int curMinute = 10 * singleTime.get(2) + singleTime.get(3);
            if (curHour < 24 && curMinute < 60) {
                // time comparing
                if (curHour > maxHour) {
                    // update current time
                    maxHour = curHour;
                    maxMinute = curMinute;
                    maxTime = maxHour + ":" + maxMinute;
                } else if (curHour == maxHour && curMinute > maxMinute) {
                    // update current time
                    maxMinute = curMinute;
                    maxTime = maxHour + ":" + maxMinute;
                }
            }
        }
        System.out.println(output);
        // scale the output
        if (maxHour == Integer.MIN_VALUE || maxMinute == Integer.MIN_VALUE) {
            return "not possible";
        } else {
            return maxTime;
        }
    }

    // interface: the size of output & nums is 4 & within 0~9; used[i] is initialized to false
    private void backTrack(List<List<Integer>> output, List<Integer> curList, int[] nums, boolean[] used) {
        // base case:
        if (curList.size() == 4) {
            // assign the output
            output.add(new LinkedList(curList));
        } else {
            // recursion
            for (int i = 0; i < 4; i++) {
                // cope with the duplicate
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                curList.add(nums[i]);
                // backTrack part
                backTrack(output, curList, nums, used);
                curList.remove(curList.size() - 1);
                used[i] = false;
            }
        }
    }

    /**
     * 2nd one
     */
    // the output is an int[] with length 2, the 1st index && the 2nd index
    public List<Integer> minLength(int[] nums) {
        // find the 1st index
        int first = 0, last = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                first = i;
                break;
            }
        }
        // find the 2nd index
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                last = i;
                break;
            }
        }
        // find the maximum & minimum
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = first; i <= last; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        // find the true index
        for (int i = 0; i < first; i++) {
            if (nums[i] > min) {
                first = i;
                break;
            }
        }
        for (int i = nums.length - 1; i > last; i--) {
            if (nums[i] < max) {
                last = i;
                break;
            }
        }
        List<Integer> l = new LinkedList<>();
        l.add(first);
        l.add(last);
        return l;
    }

    public static void main(String[] args) {
        System.out.println("self-testing oa1");
        liveRamp oa = new liveRamp();
        int[] nums1 = {0, 2, 0, 4};
        int[] nums2 = {9, 9, 9, 9};

        System.out.println(oa.timeLine(nums1));
        System.out.println(oa.timeLine(nums2));

        System.out.println("self-testing of subarray");
        int[] whole = {1, 2, 3, 4, 5};
        int[] subarray = Arrays.copyOfRange(whole, 2, 4);
        for (int i = 0; i < subarray.length; i++) {
            System.out.println(subarray[i]);
        }

        System.out.println("self-testing oa2");
        int[] nums3 = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        int[] nums4 = {0, 1, 15, 25, 6, 7, 30, 40, 50};
        System.out.println(oa.minLength(nums3));
        System.out.println(oa.minLength(nums4));
    }
}
