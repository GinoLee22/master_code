package BasicAlgorithm;

/**
 * Created by ginolee on 8/3/17.
 */
public class sortArray {
    public void insertionSort(int[] input) {
        // corner case
        if (input == null) {
            return;
        }
        // insertion sort algorithm:
        for (int i = 1; i < input.length; i++) {
            int j = i;
            while (j > 0 && input[j - 1] > input[j]) {
                // swap input[j - 1], input[j]
                int temp = input[j - 1];
                input[j - 1] = input[j];
                input[j] = temp;
                j = j - 1;
            }
        }
        // print the result
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }

    public void mergeSort(int[] input, int left, int right) {
        if (left >= right) {            // when there is only one element --> no sorting needed
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(input, left, mid);
        mergeSort(input, mid + 1, right);
        merge(input, left, mid, right);
    }

    // array[left] - array[mid] & array[mid + 1] - array[right] are already sorted
    private void merge(int[] array, int left, int mid, int right) {
        // create 2 arrays: 1. [left, mid]. 2. [mid + 1, right]
        int l1 = mid - left + 1, l2 = right - mid;
        int[] A = new int[l1], B = new int[l2];
        for (int i = 0; i < A.length; i++) {
            A[i] = array[left + i];
        }
        for (int i = 0; i < B.length; i++) {
            B[i] = array[left + i + l1];
        }
        // merge operation
        int idx1 = 0, idx2 = 0, idx = left;
        while (idx1 < A.length && idx2 < B.length) {
            if (A[idx1] < B[idx2]) {
                array[idx] = A[idx1];
                idx1++;
            } else {
                array[idx] = B[idx2];
                idx2++;
            }
            idx++;
        }
        while (idx1 < A.length) {
            array[idx] = A[idx1];
            idx1++;
            idx++;
        }
        while (idx2 < B.length) {
            array[idx] = B[idx2];
            idx2++;
            idx++;
        }
    }

    private String arrayToString(int[] input) {
        String output = "[ ";
        for (int i = 0; i < input.length; i++) {
            output += input[i] + " ";
        }
        return output + "]";
    }

    public static void main(String[] args) {
        System.out.println("self-testing of insertionSort()");
        sortArray test = new sortArray();
        System.out.println("insertionSort() with input: null");
        int[] input1 = null;
        test.insertionSort(input1);
        System.out.println("insertionSort() with input: {}");
        int[] input2 = {};
        test.insertionSort(input2);
        System.out.println("insertionSort() with input: {1}");
        int[] input3 = {1};
        test.insertionSort(input3);
        System.out.println("insertionSort() with input: {5, 4, 3, 2, 1}");
        int[] input4 = {5, 4, 3, 2, 1};
        test.insertionSort(input4);

        System.out.println("\n ----- self-testing of merge()");
        int[] array = new int[]{0, 2, 5, 1, 3, 4};
        test.merge(array, 0, 2, 5);
        System.out.println(test.arrayToString(array));

        System.out.println("\n ----- self-testing of mergeSort()");
        System.out.println("mergeSort() with input: {5, 4, 3, 2, 1}");
        int[] input5 = new int[] {12, 11, 13, 5, 6, 7};
        test.mergeSort(input5, 0, 5);
        System.out.println(test.arrayToString(input5));

    }
}
