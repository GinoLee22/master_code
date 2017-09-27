package UnionFind;

/**
 * Created by ginolee on 8/18/17.
 */

/**
 * Problem description:
 * Given n nodes in a graph labeled from 1 to n. There is no edge in the graph at beginning.
 * You need to support following methods:
 * 1. connect (a, b), an edge to connect node a and node b
 * 2. query(a). Return the number of connected component nodes which include node a.
 *
 * Example:
 * 5 // 5
 * query(1) return 1
 * connect(1, 2)
 * query(1) return 2
 * connect(2, 4)
 * query(1), return 3
 * connect(1, 4)
 * query(1), return 3
 */
public class ConnectingGraphII {
    private int[] father = null;
    private int[] size = null;

    /**
     * initialization: father[i] = i && size[i] = 1
     * @param n
     */
    public ConnectingGraphII(int n) {
        father = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        father[x] = find(father[x]);        // path compression
        return father[x];
    }

    // This is Union Opertation in UnionFind. a -> b: size only change when connecting
    public void connect(int a, int b) {
        int roota = find(a);
        int rootb = find(b);
        if (roota != rootb) {
            father[roota] = rootb;
            size[rootb] += size[roota];
        }
    }

    public int query(int a) {
        int roota = find(a);
        return size[roota];
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        int n = 5;
        ConnectingGraphII cg = new ConnectingGraphII(n);
        System.out.println("Result of query(1) should be 1." + "Current result is:" + cg.query(1));
        System.out.println("Connect 1 & 2");
        cg.connect(1, 2);
        System.out.println("Result of query(1) should be 2." + "Current result is:" + cg.query(1));
        System.out.println("Connect 2 & 4");
        cg.connect(2, 4);
        System.out.println("Result of query(1) should be 3." + "Current result is:" + cg.query(1));
        System.out.println("Connect 1 & 4");
        cg.connect(1, 4);
        System.out.println("Result of query(1) should be 4." + "Current result is:" + cg.query(1));
    }
}
