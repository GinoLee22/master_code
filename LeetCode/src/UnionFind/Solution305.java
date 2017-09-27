package UnionFind;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 8/18/17.
 */
public class Solution305 {
    private int[] father = null;
    private boolean[] island = null;
    private int count = 0;
    private int[] deltRow = new int[] {-1, 0, 1, 0};
    private int[] deltCol = new int[] {0, 1, 0, -1};

    public void initialize(int m, int n) {      // m: numRow, n: numCol
        father = new int[m * n];
        island = new boolean[m * n];
        for (int i = 0; i < m * n; i++) {
            father[i] = i;
        }
    }

    // UnionFind: find operation with path compression
    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }

    // UnionFind: union operation
    public void union(int row, int col, int m, int n) {
        // every new island -> regard it as new: count++
        int curIdx = row * n + col;
        count++;
        island[curIdx] = true;
        // union with direction: up -> right -> down -> left
        for (int i = 0; i < 4; i++) {
            int curRow = row + deltRow[i], curCol = col + deltCol[i];
            if (curRow < 0 || curRow >= m || curCol < 0 || curCol >= n) {
                continue;
            }
            int adjIdx = curRow * n + curCol;
            if (island[adjIdx]) {           // UnionFind only happen when adjacent position are island
                int rootCur = find(curIdx);
                int rootAdj = find(adjIdx);
                if (rootCur != rootAdj) {
                    father[rootCur] = rootAdj;
                    count--;
                }
            }
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        // initialization
        List<Integer> res = new LinkedList<>();
        initialize(m, n);

        for (int[] position : positions) {
            int row = position[0], col = position[1];
            union(row, col, m, n);
            res.add(count);
        }
        return res;
    }
}
