package OA;

/**
 * Created by ginolee on 9/15/17.
 */

import javax.xml.transform.Result;
import java.awt.*;
import java.awt.geom.Point2D;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

/**
 * Very Important. Have to 100% understand & no mistake
 */
public class OAAmazon {
    /**
     * Problem 1
     * window sum
     */
    public ArrayList<Integer> getWindowSum(ArrayList<Integer> list, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        // corner case
        if (list == null || list.size() < k) {
            return res;
        }

        int curSum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i < k) {                // get the sum of size k in the first place
                curSum += list.get(i);
                if (i == k - 1) {
                    res.add(curSum);
                }
            } else {                    // add next element & minus the head element
                curSum = curSum + list.get(i) - list.get(i - k);
                res.add(curSum);
            }
        }
        return res;
    }

    /**
     * Problem 2
     * rotate matrix
     * Problem Description: "m * n" matrix. flag == 1 -> clock-wise. flag == 0 -> counter clock-wise
     * Solution: 0 -> flip vertically. 1 -> flip horizontally
     */
    public int[][] rotate(int[][] matrix, int flag) {
        int m = matrix.length, n = matrix[0].length;
        int[][] transpose = new int[n][m];
        flip(matrix, flag);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                transpose[row][col] = matrix[col][row];
            }
        }
        return transpose;
    }

    /**
     * flip the matrix
     *
     * @param matrix
     * @param flag   0 -> counter clock-wise, flip horizontally
     */
    public void flip(int[][] matrix, int flag) {
        int m = matrix.length, n = matrix[0].length;            // m: num of row. n: num of col
        if (flag == 1) {            // flip horizontally
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n / 2; col++) {
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[row][n - col - 1];
                    matrix[row][n - col - 1] = temp;
                }
            }
        } else {                    // flip vertically
            for (int row = 0; row < m / 2; row++) {
                for (int col = 0; col < n; col++) {
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[m - row - 1][col];
                    matrix[m - row - 1][col] = temp;
                }
            }
        }
    }

    public void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Problem 3
     * get K Closest Points
     * typical problem of PriorityQueue
     * Note: key is the distance
     */
    public Point[] getKClosest(Point[] points, int k) {
        Queue<Point> minHeap = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                double d1 = getDistance(p1, new Point(0, 0));
                double d2 = getDistance(p2, new Point(0, 0));
                if (d1 < d2) {
                    return -1;
                } else if (d1 > d2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        // add points
        for (Point p : points) {
            minHeap.offer(p);
        }
        // closest k
        Point[] res = new Point[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }

    private double getDistance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    /**
     * Problem 4
     * LRU Cache Miss
     * Use LinkedHashMap to realize LRU Cache
     * Definition of miss:
     */
    public int countMiss(int[] arr, int size) {
        int miss = 0;
        // corner case
        if (arr == null) {
            return miss;
        }
        // true: access-order. false: insertion-order
        LinkedHashMap<Integer, Boolean> cacheMap = new LinkedHashMap<Integer, Boolean>(size, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Boolean> eldest) {
                return this.size() > size;
            }
        };
        for (int num : arr) {
            if (cacheMap.get(num) == null) {
                miss++;
                cacheMap.put(num, true);
            }
        }
        return miss;
    }

    /**
     * Problem 5
     * BST Min Path Sum from root to leaf
     */
    public int minPathSum(TreeNode root) {
        // corncer case
        if (root == null) {
            return 0;
        }

        // base case
        if (root.left == null && root.right == null) {
            return root.val;
        }
        // recursion: 3 conditions
        if (root.left == null) {
            return root.val + minPathSum(root.right);
        }
        if (root.right == null) {
            return root.val + minPathSum(root.left);
        }
        int leftSum = minPathSum(root.left);
        int rightSum = minPathSum(root.right);
        return root.val + Math.min(leftSum, rightSum);

    }

    /**
     * Problem 6
     * Insert Cycle List
     * two condition: 1. insert the min value
     * 2. insert middle value
     */
    public ListNode insert(ListNode arb, int val) {
        // corner case
        ListNode newNode = new ListNode(val);
        if (arb == null) {
            return newNode;
        }

        ListNode cur = arb;
        while (cur.next != arb) {
            // middle value
            if (val >= cur.val && val <= cur.next.val) {
                break;
            }
            // min value
            if (val < cur.val && (cur.val > cur.next.val)) {
                break;
            }
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        return newNode;
    }

    /**
     * Problem 7
     * Company Tree: fina a subtree with maximum average sum. Return this average sum and its corresponding tree-node
     */
    class ReturnType {
        int sum;
        int num;

        public ReturnType(int sum, int num) {
            this.sum = sum;
            this.num = num;
        }
    }

    private TreeNode maxAvgRoot = null;
    private double maxAvg = Double.MIN_VALUE;

    public TreeNode getMaxAvgSubtree(TreeNode root) {
        // corner case
        if (root == null) {
            return null;
        }
        help(root);
        return maxAvgRoot;
    }

    private ReturnType help(TreeNode root) {
        // base case
        if (root == null) {
            return new ReturnType(0, 0);
        }
        // recursion
        ReturnType left = help(root.left);
        ReturnType right = help(root.right);
        // traverse part
        int curSum = left.sum + right.sum + root.val;
        int curNum = left.num + right.num + 1;
        double curAvg = (double) curSum / (double) curNum;
        if (curAvg > maxAvg) {
            maxAvg = curAvg;
            maxAvgRoot = root;
        }
        return new ReturnType(curSum, curNum);
    }

    /**
     * High Five: description: https://yeqiuquan.blogspot.com/2017/03/lintcode-613-high-five.html
     */
    class Record {
        int id, score;

        public Record(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }

    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, PriorityQueue<Integer>> recordMap = new HashMap<>();           // (id, all scores)
        Map<Integer, Double> scoreMap = new HashMap<>();
        // 1st: add all results to PriorityQueue
        for (Record record : results) {
            int curId = record.id, curScore = record.score;
            if (!recordMap.containsKey(curId)) {
                recordMap.put(curId, new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer s1, Integer s2) {
                        if (s1 < s2) {
                            return 1;
                        } else if (s1 > s2) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }));
            }
            recordMap.get(curId).offer(curScore);
        }
        // 2nd: calculate the average
        for (int key : recordMap.keySet()) {
            double highFiveSum = 0;
            PriorityQueue<Integer> curPQ = recordMap.get(key);
            for (int i = 0; i < 5; i++) {
                highFiveSum += curPQ.poll();
            }
            scoreMap.put(key, highFiveSum / (double) 5);
        }
        return scoreMap;
    }

    public void testHighFive() {
        Record r1 = new Record(1, 100);
        Record r2 = new Record(1, 95);
        Record r3 = new Record(1, 98);
        Record r4 = new Record(1, 92);
        Record r5 = new Record(1, 89);
        Record r6 = new Record(1, 97);
        Record r7 = new Record(1, 99);
        Record[] results = new Record[] {r1, r2, r3, r4, r5, r6, r7};
        System.out.println(highFive(results));
    }

    /**
     * City Connection
     * typical problem of UnionFind
     */
    public ArrayList<Connection> getLowCost(ArrayList<Connection> connections) {
        ArrayList<Connection> res = new ArrayList<>();
        // 1st: according to Kruskal's Algorithm, sort the connections
        Collections.sort(connections, new Comparator<Connection>() {
            @Override
            public int compare(Connection c1, Connection c2) {
                if (c1.cost < c2.cost) {
                    return -1;
                } else if (c1.cost > c2.cost) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        // 2nd: construct an UnionFind & union operations
        UnionFindAmazon ufa = new UnionFindAmazon(connections);
        for (Connection c : connections) {
            String city1 = c.city1;
            String city2 = c.city2;
            if (ufa.union(city1, city2)) {
                res.add(c);
            }
        }

        // 3rd: sort the result
        Collections.sort(res, new Comparator<Connection>() {
            @Override
            public int compare(Connection c1, Connection c2) {
                if (c1.city1.equals(c1.city2)) {
                    return c1.city2.compareTo(c2.city2);
                }
                return c1.city1.compareTo(c2.city1);
            }
        });

        // 4th: need to check the correctness: number of edges = number of nodes - 1
        return ufa.father.size() - 1 == res.size() ? res : null;
    }

    public void testCityConnection() {
        Connection c1 = new Connection("A", "D", 1);
        Connection c2 = new Connection("A", "B", 3);
        Connection c3 = new Connection("D", "B", 3);
        Connection c4 = new Connection("B", "C", 1);
        Connection c5 = new Connection("C", "D", 1);
        Connection c6 = new Connection("E", "D", 6);
        Connection c7 = new Connection("C", "E", 5);
        Connection c8 = new Connection("C", "F", 4);
        Connection c9 = new Connection("E", "F", 2);
        ArrayList<Connection> connections = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9));
//        ArrayList<Connection> connections = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5, c9));
        ArrayList<Connection> res = getLowCost(connections);
//        System.out.println(res);
        for (Connection c : res) {
            System.out.println(c.city1 + "->" + c.city2 + " with cost: " + c.cost);
        }
    }

    /**
     * Order Dependency
     * typical problem of topological sort
     */
    class Course {
        String course = "";
        public Course(String str) {
            course = str;
        }
    }

    class Dependency {
        Course cur;
        Course pre;
        public Dependency(Course cur, Course pre) {
            this.cur = cur;
            this.pre = pre;
        }
    }

    public List<Course> find(List<Dependency> list) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> indegree = new HashMap<>();        // (K, V): (course, indegree)
        Map<String, Set<String>> graph = new HashMap<>();       // construct the graph using Adjacency List
        for (Dependency d : list) {
            String curCourse = d.cur.course;
            String preCourse = d.pre.course;
            // construct the graph
            if (!graph.containsKey(preCourse)) {
                graph.put(preCourse, new HashSet<>());
            }
            if (!graph.containsKey(curCourse)) {
                graph.put(curCourse, new HashSet<>());
            }
            graph.get(preCourse).add(curCourse);
            // construct the indegree
            if (!indegree.containsKey(preCourse)) {
                indegree.put(preCourse, 0);
            }
            indegree.put(curCourse, indegree.getOrDefault(curCourse, 0) + 1);
        }
        System.out.println(graph);
        System.out.println(indegree);
        // topological sort using BFS
        Queue<String> queue = new LinkedList<>();
        for (String course : indegree.keySet()) {
            if (indegree.get(course) == 0) {
                queue.add(course);
            }
        }
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            res.add(cur);
            for (String neighbor : graph.get(cur)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        System.out.println(res);
        System.out.println(indegree);
        return null;
    }

    public void testOrderDependency() {
        Course A = new Course("A");
        Course B = new Course("B");
        Course C = new Course("C");
        Course D = new Course("D");
        Dependency d1 = new Dependency(B, A);
        Dependency d2 = new Dependency(C, A);
        Dependency d3 = new Dependency(D, B);
        Dependency d4 = new Dependency(D, C);
        List<Dependency> list = new ArrayList<>(Arrays.asList(d1, d2, d3, d4));
        find(list);
    }

    /**
     * overlap rectangular
     * Two self-design interface: 1. rectangle (top-left + bottom-right) + point
     */
    class Rectangle {
        Point topLeft;
        Point bottomRight;

        public Rectangle(Point p1, Point p2) {
            topLeft = p1;
            bottomRight = p2;
        }
    }

    boolean isOverlap(Rectangle r1, Rectangle r2) {
        // compare horizontally
        if (r1.bottomRight.x < r2.topLeft.x || r2.bottomRight.x < r1.topLeft.x) {
            return false;
        }
        // compare vertically
        if (r1.bottomRight.y < r2.topLeft.y || r2.bottomRight.y < r1.topLeft.y) {
            return false;
        }
        return true;
    }

    /**
     * Gray Code
     */
    public int check(byte a, byte b) {
        byte x = (byte) (a ^ b);
        return (x & (x - 1)) == 0 ? 1 : -1;
    }

    private List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                res.add(res.get(size - j - 1) | 1 << i);
            }
        }
        return res;
    }

    private void isSuccesive() {
        List<Integer> res8 = grayCode(8);
        for (int i = 0; i < res8.size() - 1; i++) {
            int neighbor = res8.get(i) ^ res8.get(i + 1);
            System.out.println(neighbor & (neighbor - 1));
        }
    }

    /**
     * Four Integer
     */
    public int[] makeLargest(int a, int b, int c, int d) {
        int[] res = new int[]{a, b, c, d};
        swap(res, 0, 1);
        swap(res, 2, 3);
        swap(res, 0, 3);
        return res;
    }

    private void swap(int[] input, int idx1, int idx2) {
        int temp = input[idx1];
        input[idx1] = input[idx2];
        input[idx2] = temp;
    }

    /**
     * Rotate String
     * Given two words, if the 2nd word is the round rotation of 1st word
     * eg: abc, cab -> yes
     * ab, aa   -> no
     */
    public boolean isRoundRotated(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        return (s1 + s1).indexOf(s2) >= 0;
    }

    /**
     * Remove Vowels
     */
    public String removeVowel(String s) {
        StringBuilder sb = new StringBuilder();
        char[] sArray = s.toCharArray();
        String vowels = "aeiouAEIOU";
        for (char c : sArray) {
            if (vowels.indexOf(c) != -1) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * Closest Two Sum
     */
    public double[] find(double[] weights, double target) {
        // corner case
        if (weights == null) {
            return null;
        }

        Arrays.sort(weights);
        Double min = null;
        double[] res = new double[2];
        int start = 0, end = weights.length - 1;
        while (start < end) {
            double curSum = weights[start] + weights[end];
            if (curSum > target) {
                end--;
            } else {        // curSum <= target
                if (min == null || min > target - curSum) {
                    min = target - curSum;
                    res[0] = weights[start];
                    res[1] = weights[end];
                    start++;
                }
            }
        }
        return (min == null) ? null : res;
    }

    /**
     * Reverse Half Linked List
     */
    public ListNode reverseHalf(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0), slow = dummy, fast = dummy;
        dummy.next = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Now: slow points to mid point
        fast = slow.next;
        while (fast.next != null) {
            ListNode temp = slow.next;
            slow.next = fast.next;
            fast.next = fast.next.next;
            slow.next.next = temp;
        }
        return dummy.next;
    }


    /**
     * numOfValidParenthesis
     * typical problem of Stack
     */
    public int numParentheses(String str) {
        char[] sArray = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : sArray) {
            if (c == '(') {
                stack.push(')');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return -1;
                }
            }
        }
        return stack.isEmpty() ? str.length() / 2 : -1;
    }

    /**
     * GCD
     * remember the recursive way to find gcd of two positive integer
     */
    public int gcd(int[] arr) {
        // corner case
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = arr[0];
        for (int num : arr) {
            res = gcd(res, num);
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * Round-Robin algorithm (very important)
     * https://www.youtube.com/watch?v=aWlQYllBZDs, this video is self-contained
     * Node: it is pretty straight-forward to implement this algorithm by PriorityQueue but it is not linear time. So, just linkedlist to deal with arrive time
     */
    class Process {
        int arrTime;
        int exeTime;

        public Process(int arrTime, int exeTime) {
            this.arrTime = arrTime;
            this.exeTime = exeTime;
        }
    }

    public float roundRobin(int[] aTime, int[] eTime, int q) {
        int len = aTime.length;
        Queue<Process> queue = new LinkedList<>();
        int curTime = 0, wait = 0;
        int idx = 0;            // loop the input array
        while (!queue.isEmpty() || idx < len) {
            if (queue.isEmpty()) {
                queue.add(new Process(aTime[idx], eTime[idx]));
                curTime = aTime[idx];                                       // this code is to re-initialize the curTime
                idx++;
            } else {
                Process curProcess = queue.poll();
                wait += curTime - curProcess.arrTime;
                curTime += Math.min(curProcess.exeTime, q);
                for (; idx < len && aTime[idx] <= curTime; idx++) {         // add process within the executing time
                    queue.add(new Process(aTime[idx], eTime[idx]));
                }
                if (curProcess.exeTime > q) {
                    queue.add(new Process(curTime, curProcess.exeTime - q));
                }
            }
        }
        return (float) wait / (float) len;
    }

    /**
     * Shorted job first
     * typical problem of PriorityQueue
     */
    public double calWaitingTime(int[] aTime, int[] eTime) {
        int len = aTime.length;
        int curTime = 0, wait = 0;
        int idx = 0;
        PriorityQueue<Process> pq = new PriorityQueue<>(new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {
                if (p1.exeTime == p2.exeTime) {
                    return p1.arrTime - p2.arrTime;
                }
                return p1.exeTime - p2.exeTime;
            }
        });
        while (!pq.isEmpty() || idx < len) {
            if (pq.isEmpty()) {
                pq.offer(new Process(aTime[idx], eTime[idx]));
                curTime = aTime[idx];
                idx++;
            } else {
                Process curProcess = pq.poll();
                wait += curTime - curProcess.arrTime;
                curTime += curProcess.exeTime;
                while (idx < len && aTime[idx] < curTime) {
                    pq.offer(new Process(aTime[idx], eTime[idx]));
                    idx++;
                }
            }
        }
        return (double) wait / (double) len;
    }


    public static void main(String[] args) {
        OAAmazon amazon = new OAAmazon();
        System.out.println("\n ----- self-testing of Problem 1: window sum");
        Integer[] array1 = new Integer[]{1, 2, 3, 4, 5};
        Integer[] array2 = new Integer[0];
        ArrayList<Integer> list1 = new ArrayList(Arrays.asList(array1));            // remember here: Arrays.asList() must be applied to Integer type
        ArrayList<Integer> list2 = new ArrayList(Arrays.asList(array2));
        System.out.println(list1);
        System.out.println(amazon.getWindowSum(list1, 2));
        System.out.println(amazon.getWindowSum(list1, 6));
        System.out.println(amazon.getWindowSum(list2, 2));

        System.out.println("\n ----- self-testing of Problem 2: rotate matrix");
        int[][] matrix = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        int[][] newMatrix = amazon.rotate(matrix, 1);
        amazon.printMatrix(newMatrix);

        System.out.println("\n ----- self-testing of Problem 3: kNearestPoints");
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(0, 0);
        Point[] points = new Point[]{p1, p2, p3, p4};
        Point[] res = amazon.getKClosest(points, 4);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

        System.out.println("\n ----- self-testing of Problem 4: LRU Cache miss");
        int[] arr = new int[0];
        System.out.println(amazon.countMiss(arr, 3));

        System.out.println("\n ----- self-testing of Problem 5: minPathSum");
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(6);
        root.left.right = new TreeNode(3);
        System.out.println(amazon.minPathSum(root));
        System.out.println("\n ----- self-testing of numOfValidParenthesis");
        String str = "((()())";
        System.out.println(amazon.numParentheses(str));


        System.out.println("\n ----- self-testing of GrayCode");
//        amazon.isSuccesive();
        System.out.println(amazon.check((byte) (Integer.parseInt("10001000", 2)), (byte) (Integer.parseInt("10001001", 2))));
        System.out.println(amazon.check((byte) (Integer.parseInt("10001000", 2)), (byte) (Integer.parseInt("10011001", 2))));

        System.out.println("\n ----- self-testing of Remove Vowels");
        System.out.println(amazon.removeVowel("HelloWorld"));

        System.out.println("\n ----- self-testing of Closest Two Sum");
        double[] weights = new double[]{0, 1, 2, 4, 5};
        double[] closestTwoSum = amazon.find(weights, 2.2);
        for (double d : closestTwoSum) {
            System.out.print(d + " ");
        }

        System.out.println("\n ----- self-testing of Reverse Half Linked List");
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        System.out.println(ListNode.toString(head));
        ListNode newHead = amazon.reverseHalf(head);
        System.out.println(ListNode.toString(newHead));

        System.out.println("\n ----- self-testing of HighFive");
        amazon.testHighFive();

        System.out.println("\n ----- self-testing of City Connection");
        amazon.testCityConnection();

        System.out.println("\n ----- self-testing of Order Dependency");
        amazon.testOrderDependency();
    }
}
