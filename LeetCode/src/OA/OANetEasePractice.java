package OA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ginolee on 9/8/17.
 */
public class OANetEasePractice {
    public int problem1(String s) {
        char[] strArray = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : strArray) {
            set.add(c);
        }
        if (set.size() > 2) {
            return 0;
        }
        return set.size();
    }

    public String problem2(int cnt, int[] nums) {
        // corner case
        if (nums == null || nums.length <= 1) {
            return "Possible";
        }
        Arrays.sort(nums);
        int d = nums[1] - nums[0];
        for (int i = 1; i < cnt; i++) {
            if (nums[i] - nums[i - 1] != d) {
                return "Impossible";
            }
        }
        return "Possible";
    }

    public int problem3(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] strArray = s.toCharArray();
        int curLen = 1, max = 1;
        for (int i = 1; i < strArray.length; i++) {
            if (strArray[i] != strArray[i - 1]) {
                curLen++;
            } else {
                curLen = 1;
            }
            max = Math.max(max, curLen);
        }
        return max;
    }

    /**
     * this is a typical problem of two-pointer
     */
    public int[] problem4(int[] a) {
        int[] res = new int[a.length];
        int idx = 0;
        for (int i = 0; i < a.length; i++) {
            res[idx] = a[i];
            helpProblem4(res, 0, idx);
            idx++;
        }
        return res;
    }

    private void helpProblem4(int[] input, int startIdx, int endIdx) {
        while (startIdx < endIdx) {
            int temp = input[startIdx];
            input[startIdx] = input[endIdx];
            input[endIdx] = temp;
            startIdx++;
            endIdx--;
        }
    }

    public int problem5(int x, int f, int d, int p) {
        int days = 0;
        while (d >= 0) {
            if (f > 0) {
                f--;
            } else {
                d -= p;
            }
            d -= x;
            if (d < 0) {
                return days;
            }
            days++;
        }
        return days;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing for problem1");
        OANetEasePractice oaNet = new OANetEasePractice();
        String test1 = "AABB", test2 = "AAAA", test3 = "AABBCC";
        System.out.println(oaNet.problem1(test1));
        System.out.println(oaNet.problem1(test2));
        System.out.println(oaNet.problem1(test3));

        System.out.println("\n ----- self-testing for problem2");
        int[] nums1 = new int[] {3, 1, 2}, nums2 = new int[] {3, 1, 2, 5};
        System.out.println(oaNet.problem2(3, nums1));
        System.out.println(oaNet.problem2(4, nums2));

        System.out.println("\n ---- self-testing for problem3");
        String s = "111101111";
        System.out.println(oaNet.problem3(s));

        System.out.println("\n ----- self-testing for problem4");
        int[] a = new int[] {1, 2, 3, 4};
        int[] res = oaNet.problem4(a);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

        System.out.println("\n ----- self-testing for problem5");
//        3 5 100 10
        int x = 3, f = 5, d = 2, p = 10;
        System.out.println(oaNet.problem5(x, f, d, p));
    }
}
