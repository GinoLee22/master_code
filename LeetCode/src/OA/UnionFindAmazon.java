package OA;

import java.util.*;

/**
 * Created by ginolee on 9/21/17.
 */

class Connection {
    String city1;
    String city2;
    int cost;

    public Connection(String a, String b, int c) {
        city1 = a;
        city2 = b;
        cost = c;
    }
}

public class UnionFindAmazon {
    Map<String, String> father;

    public UnionFindAmazon(ArrayList<Connection> connections) {
        father = new HashMap<>();
        for (Connection c : connections) {
            String city1 = c.city1;
            String city2 = c.city2;
            if (!father.containsKey(city1)) {
                father.put(city1, city1);
            }
            if (!father.containsKey(city2)) {
                father.put(city2, city2);
            }
        }
    }

    public String find(String x) {
        if (father.get(x).equals(x)) {
            return x;
        }
        father.put(x, find(father.get(x)));
        return father.get(x);
    }

    // a -> b
    public boolean union(String a, String b) {
        String roota = find(a);
        String rootb = find(b);
        if (roota.equals(rootb)) {
            return false;
        }
        father.put(roota, rootb);
        return true;
    }
}
