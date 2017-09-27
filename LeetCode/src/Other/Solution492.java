package Other;

/**
 * Created by ginolee on 7/17/17.
 */
public class Solution492 {
    public int[] constructRectangle(int area) {
        int squareSide = (int) Math.sqrt(area);
        while (area % squareSide != 0) {
            squareSide++;
        }
        return new int[]{squareSide, area / squareSide};
    }
}
