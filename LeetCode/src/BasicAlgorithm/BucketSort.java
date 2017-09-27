package BasicAlgorithm;

/**
 * Created by ginolee on 8/23/17.
 */
public class BucketSort {
    // assume nums ranging from [0, max]
    public void bucketSort(int[] nums) {
        // find the maximum
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        // bucket sort
        int[] bucket = new int[max + 1];
        for (int num : nums) {
            bucket[num]++;
        }
        int idx = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                nums[idx] = i;
                idx++;
            }
        }
    }
}
