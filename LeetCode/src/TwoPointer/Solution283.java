package TwoPointer;

/**
 * Created by ginolee on 3/22/17.
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        /**
         * 2-pointer: 1 for the none-zero index, the other for the looping
         */
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        // padding 0
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    private static String arrayToString(int[] nums) {
        String output = "[ ";
        for (int i = 0; i < nums.length; i++) {
            output += nums[i] + " ";
        }
        return output + "]";
    }

    public static void main(String[] args) {
        Solution283 s = new Solution283();
        System.out.println("\n ----- self-testing");
        int[] nums = {0, 1, 0, 3, 12};
        s.moveZeroes(nums);
        System.out.println(arrayToString(nums));
    }
}
