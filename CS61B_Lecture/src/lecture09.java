import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by ginolee on 12/28/16.
 */
public class lecture09 {

    private static int bsearch(int[] i, int left, int right, int findMe) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (i[mid] == findMe) {
            return mid;
        } else if (i[mid] > findMe) {
            return bsearch(i, left, mid - 1, findMe);
        } else {
            return bsearch(i, mid + 1, right, findMe);
        }
    }

    public static int bsearch(int[] i, int findMe) {
        return bsearch(i, 0, i.length, findMe);
    }

    public static int bsearchSelf(int[] i, int findMe) {
        if (i.length == 1 && i[0] != findMe) {
            return -1;          // failure code
        }
        int mid = (0 + i.length) / 2;
        if (i[mid] == findMe) {
            return mid;
        }
        else if (i[mid] > findMe) {
            return bsearchSelf(Arrays.copyOfRange(i, 0, mid), findMe);
        }
        else {
            return bsearchSelf(Arrays.copyOfRange(i, mid + 1, i.length), findMe);
        }
    }

    public static void main(String[] args) {

        System.out.println("\nTesting of cs61b binary search.");
        int[] i = {-3, -2, 0, 0, 1, 5, 5};
        System.out.println(bsearch(i, 1));
        System.out.println(bsearch(i, 5));
        System.out.println(bsearch(i, 2));

        // it's incorrect because i change the index
        System.out.println("\nTesting of self binary search.");
        System.out.println(bsearchSelf(i, 1));
        System.out.println(bsearchSelf(i, 5));
        System.out.println(bsearchSelf(i, 2));




    }
}
