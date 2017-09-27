package Interview;

import num17.Solution;

/**
 * Created by ginolee on 2/23/17.
 */
public class kthMax {

    public int[] findkthMax (int[] nums) {
        // create the first kth element that store the maximums
        int k = 3;
        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > output[0]) {
                output[2] = output[1];
                output[1] = output[0];
                output[0] = nums[i];
            } else if (nums[i] > output[1]) {
                output[2] = output[1];
                output[1] = nums[i];
            } else if (nums[i] > output[2]) {
                output[2] = nums[i];
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        int[] input = {3, 2, 1, 5, 6, 4};
        kthMax s = new kthMax();
        int[] output = s.findkthMax(input);
        for (int i = 0; i < 3; i++) {
            System.out.println(output[i]);
        }
    }

}
