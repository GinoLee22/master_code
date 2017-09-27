package UnionFind;

/**
 * Created by ginolee on 8/22/17.
 */
public class Solution547 {
    /**
     * this problem is not a 2D matrix problem because row & col are related
     * but could solved by UnionFind
     */
    private int[] father;
    private int size;

    public void initialize(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        size = n;
    }

    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }

    // routine: a -> b
    public void connect(int a, int b) {
        int roota = find(a);
        int rootb = find(b);
        if (roota != rootb) {
            father[roota] = father[rootb];
            size--;
        }
    }

    public int findCircleNum(int[][] M) {
        // initialize
        int m = M.length;      // m: num of students
        initialize(m);
        // connect
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (M[i][j] == 1) {
                    connect(j, i);
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Solution547 s = new Solution547();
        int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(s.findCircleNum(M));
    }
}
