package UnionFind;

/**
 * Created by ginolee on 8/18/17.
 */

/**
 * Problem description:
 * Given n nodes in a graph labeled from 1 to n. There is no edge in the graph at beginning.
 * You need to support following methods:
 * 1. connect (a, b), an edge to connect node a and node b
 * 2. query(a, b). check if two nodes are connected.
 *
 * Example:
 * 5 // n = 5
 * query(1, 2) return false
 * connect(1, 2)
 * query(1, 3) return false
 * connect(2, 4)
 * query(1, 4), return true
 */

public class ConnectingGraph {
    private int[] father = null;

    /**
     * there are n elements
     * for initialization, point to themselves father[i] = i
     * @param n
     */
    public ConnectingGraph(int n) {
        father = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            father[i] = i;
        }
    }

    /**
     * path-compression technique
     * "find" operation in UnionFind -> find their father
     * @param x
     * @return
     */
    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }

    /**
     * connect routine: a -> b
     * this is Union operations in UnionFind
     * @param a
     * @param b
     */
    public void connect(int a, int b) {
        int roota = find(a), rootb = find(b);
        if (roota != rootb) {
            father[roota] = rootb;
        }
    }

    /**
     * find connecting or not -> whether has the same father
     * @param a
     * @param b
     * @return
     */
    public boolean query(int a, int b) {
        int roota = find(a), rootb = find(b);
        return roota == rootb;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        int n = 5;
        ConnectingGraph cg = new ConnectingGraph(n);
        System.out.println(cg.query(1, 2));
        cg.connect(1, 2);
        System.out.println(cg.query(2, 4));
        cg.connect(2, 4);
        System.out.println(cg.query(1,4));
    }

}
