package UnionFind;

/**
 * Created by ginolee on 8/22/17.
 */

/**
 * Problem description:
 * Given n nodes in a graph labeled from 1 to n. There is no edge in the graph at beginning.
 * You need to support following methods:
 * 1. connect (a, b), an edge to connect node a and node b
 * 2. query(). Return the number of connected component in the graph.
 *
 * Example:
 * 5 // 5
 * query() return 5
 * connect(1, 2)
 * query() return 4
 * connect(2, 4)
 * query(), return 3
 * connect(1, 4)
 * query(), return 3
 */

public class ConnectingGraphIII {
    private int[] father;
    private int size;

    // initialization
    public ConnectingGraphIII(int n) {
        father = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            father[i] = i;
        }
        size = n;
    }

    // find
    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }

    // union: routine a <- b
    public void connect(int a, int b) {
        int roota = find(a);
        int rootb = find(b);
        if (roota != rootb) {
            father[rootb] = roota;
            size--;
        }
    }

    public int query() {
        return size;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        ConnectingGraphIII cg3 = new ConnectingGraphIII(5);
        System.out.println(cg3.query());
        cg3.connect(1, 2);
        System.out.println(cg3.query());
        cg3.connect(2, 4);
        System.out.println(cg3.query());
        cg3.connect(1, 4);
        System.out.println(cg3.query());
    }
}
