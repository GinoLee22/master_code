package OA;

/**
 * Created by ginolee on 9/10/17.
 */
public class UnionFind {
    private int[] father;
    private int size;

    // constructor
    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        size = n;
    }

    // method
    public int find(int x) {
        // base case
        if (father[x] == x) {
            return x;
        }
        // recursion with path compression
        father[x] = find(father[x]);
        return father[x];
    }

    // path: a -> b
    public void union(int a, int b) {
        int roota = find(a);
        int rootb = find(b);
        if (roota != rootb) {
            father[roota] = rootb;
            size--;             // every union will reduce the size
        }
    }

    public int returnSize() {
        return size;
    }
}
