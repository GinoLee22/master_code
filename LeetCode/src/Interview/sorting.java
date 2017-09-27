package Interview;

/**
 * Created by ginolee on 2/23/17.
 */
public class sorting {

    public void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int left, int right) {
        // base case: do nothing
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        // copy an array
        int[] help = new int[nums.length];
        for (int i = left; i <= right; i++) {
            help[i] = nums[i];
        }
        // merge
        int i = left, j = mid + 1, k =left;
        while (i <= mid && j <= right) {
            if (help[i] < help[j]) {
                nums[k] = help[i];
                i++;
            } else {
                nums[k] = help[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            nums[k] = help[i];
            k++;
            i++;
        }
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        sorting s = new sorting();
        System.out.println("self-testing of merge()");
        int[] m1 = {1, 2, 100, 2, 4, 6};
        s.merge(m1, 0, 2, 5);
        s.printArray(m1);
        System.out.println("self-testing of mergeSort()");
        int[] m2 = {3, 2, 5, 1, 7, 9, 100, 0, 4};
        s.mergeSort(m2);
        s.printArray(m2);
    }
}
