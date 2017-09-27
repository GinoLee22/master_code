package TwoPointer;

/**
 * Created by ginolee on 3/23/17.
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right =numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                return new int[] {left + 1, right + 1};
            }
        }
        // this question assumes: there must be exactly one solution --> won't get into this line
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        Solution167 s = new Solution167();
        System.out.println("\n ----- self-testing");
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] output = s.twoSum(numbers, target);
        System.out.println("result: [" + output[0] + " " + output[1] + "]");
    }
}
