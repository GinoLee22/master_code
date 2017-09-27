package HashTable;

/**
 * Created by ginolee on 3/20/17.
 */
public class Solution463 {
    public int islandPerimeter(int[][] grid) {
        /**
         * key idea: perimeter = 4 * numIsland - neighbours * 2
         *           neighbours = 2 * (right-neighbour + down-neighbour)
         */
        int island = 0, neighbour = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    island++;
                    // right neighbour
                    if (c < grid[r].length - 1 && grid[r][c + 1] == 1) {
                        neighbour++;
                    }
                    // down neighbour
                    if (r < grid.length - 1 && grid[r + 1][c] == 1) {
                        neighbour++;
                    }
                }
            }
        }
        return 4 * island - 2 * neighbour;
    }

    public static void main(String[] args) {
        Solution463 s = new Solution463();
        System.out.println("\n ----- self-testing");
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(s.islandPerimeter(grid));
    }

}
