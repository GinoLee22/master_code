package TwoPointer;

/**
 * Created by ginolee on 8/24/17.
 */

/**
 * self-designed remove duplicates
 * [1, 2, 2, 3, 3, 3, 4, 5, 5] -> [1, 4]
 */
public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            while (right + 1 < nums.length && nums[right] == nums[right + 1]) {     // right pointer always keep the last duplicate element
                right++;
            }
            if (right == 0 || nums[right - 1] != nums[right]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        RemoveDuplicate rd = new RemoveDuplicate();
        int[] nums = new int[] {1, 2, 2, 3, 3, 3, 4, 5};
        int len = rd.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
