package OA;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ginolee on 9/9/17.
 */
public class OATwoSigma {
    /**
     *  problem 1: friend circle -> typical problem of UnionFind
     */

    private int[] father;
    private int size;

    public void initiailize(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        size = n;
    }

    public int find(int x) {
        // base cse
        if (father[x] == x) {
            return x;
        }
        // recursion with path compression
        father[x] = find(father[x]);
        return father[x];
    }

    // direction: a -> b
    public void union(int a, int b) {
        int roota = find(a);
        int rootb = find(b);
        if (roota != rootb) {
            father[roota] = rootb;
            size--;
        }
    }


    public int findCircleNum(String[][] friends) {
//        int m = friends.length, n = friends[0].length;
//        initiailize(m);
//        for (int row = 0; row < m; row++) {
//            for (int col = 0; col < n; col++) {
//                if (friends[row][col].equals("y")) {
//                    union(row, col);
//                }
//            }
//        }
//        return size;

        // use the UnionFind class
        int m = friends.length, n = friends[0].length;
        UnionFind uf = new UnionFind(m);
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (friends[row][col].equals("y")) {
                    uf.union(row, col);
                }
            }
        }
        return uf.returnSize();
    }

    /**
     * problem 2: longest chain -> typical problem of BFS (BFS is relative difficult to optimize because it gets the final result only when complete the research)
     * DFS is another solution and it is better than BFS because it is buttum up -> could use memory search to record the duplicate answer
     */
    public int longestChain(String[] strArray) {
        Set<String> set = new HashSet<>();
        int longest = 0;
        for (String str : strArray) {
            set.add(str);
        }
        // maintain the longest of every string in strArray

        // BFS solution
//        for (String str : strArray) {
//            int curLongest = bfs(str, set);
//            longest = Math.max(longest, curLongest);
//        }
//        return longest;

        // DFS solution
        return dfs("abcd", set);
    }

    private int bfs(String curStr, Set<String> set) {
        Queue<String> queue = new LinkedList<>();
        Set<String> curSet = new HashSet<>(set);
        queue.add(curStr);
        curSet.remove(curStr);
        int level = 0;
        while (!queue.isEmpty()) {
            System.out.println(queue);
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String levelStr = queue.poll();
                // remove the character from idx 0 -> end
                int len = levelStr.length();
                for (int j = 0; j < len; j++) {
                    String newStr = levelStr.substring(0, j) + levelStr.substring(j + 1, len);
                    if (curSet.contains(newStr)) {
                        curSet.remove(newStr);              // remove from the diction to save time -> {aab, ab}
                        queue.add(newStr);
                    }
                }
            }
        }
        return level;
    }

    private int dfs(String curStr, Set<String> set) {
        // base case: set doesn't contain curStr
        if (!set.contains(curStr)) {
            return 0;
        }
        // recursion
        int len = curStr.length();
        int levelMax = 0;
        for (int i = 0; i < len; i++) {
            String newStr = curStr.substring(0, i) + curStr.substring(i + 1, len);
            levelMax = Math.max(dfs(newStr, set), levelMax);
        }
        return levelMax + 1;
    }

    /**
     * problem 3
     * the maximum value is: 255 * 255 * 3 = 195075 -> "int" is enough
     */
    private final int[] RED = changeRGB("111111110000000000000000");
    private final int[] GREEN = changeRGB("000000001111111100000000");
    private final int[] BLUE = changeRGB("000000000000000011111111");
    private final int[] WHITE = changeRGB("111111111111111111111111");
    private final int[] BLACK = changeRGB("000000000000000000000000");

    public String problem3(String rgbStr) {
        int[] color = changeRGB(rgbStr);
        String[] colors = new String[] {"Red", "Green", "Blue", "White", "Black"};
        int min = Integer.MAX_VALUE;
        String res = "";
        // euclidean distance
        int[][] allColor = new int[5][3];
        allColor[0] = RED;
        allColor[1] = GREEN;
        allColor[2] = BLUE;
        allColor[3] = WHITE;
        allColor[4] = BLACK;
        for (int i = 0; i < allColor.length; i++) {
            int curDist = euDist(color, allColor[i]);
            // update
            if (curDist < min) {
                min = curDist;
                res = colors[i];
            } else if (curDist == min) {
                return "Ambiguous";
            }
        }
        return res;
    }

    private int[] changeRGB(String rgbStr) {
        return new int[] {Integer.parseInt(rgbStr.substring(0, 8), 2),
                Integer.parseInt(rgbStr.substring(8, 16), 2),
                Integer.parseInt(rgbStr.substring(16, 24), 2)
        };
    }

    private int euDist(int[] color, int[] standard) {
        int res = 0;
        for (int i = 0; i < color.length; i++) {
            res += (color[i] - standard[i]) * (color[i] - standard[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing of problem1");
        OATwoSigma oa = new OATwoSigma();
        String[][] friends = new String[][] {{"y", "n", "y", "y"}, {"n", "y", "y", "n"}, {"y", "y", "y", "n"}, {"y", "n", "n", "y"}};
        System.out.println(oa.findCircleNum(friends));

        System.out.println("\n ----- self-testing of problem2");
        String[] strArray = new String[] {"a", "abcd", "bcd", "abd", "cd", "c"};
        System.out.println(oa.longestChain(strArray));

        System.out.println("\n ----- self-testing of problem3");
//        int[] color = oa.changeRGB("000000001111111100000110");
        String rgbStr = "000000001111111100000110";
        System.out.println(oa.problem3(rgbStr));

        System.out.println(Integer.MAX_VALUE);
    }
}
