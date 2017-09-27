package OA;

import java.util.*;

/**
 * Created by ginolee on 9/25/17.
 */
class Order {
    int id;
    double price;

    public Order(int mId, double mPrice) {
        id = mId;
        price = mPrice;
    }
}
public class OAAkunaP2 {
    Queue<Order> maxPQ;
    Map<Integer, Order> map;            // (id, order)

    public OAAkunaP2() {
        maxPQ = new PriorityQueue<>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if (o1.price < o2.price) {
                    return 1;
                } else if (o1.price > o2.price) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        map = new HashMap<>();
    }

    public double add(int ID, double price) {
        Order order = new Order(ID, price);
        maxPQ.offer(order);
        map.put(ID, order);
        return get_high_price();
    }

    public double sell(int ID) {
        // exception? Assumption says won't take the corner case
        if (!map.containsKey(ID)) {
            return -1;
        }
        Order order = map.get(ID);
        maxPQ.remove(order);
        map.remove(ID);
        return get_high_price();
    }

    public double get_high_price() {
        if (maxPQ.size() == 0) {
            return -1;
        }
        return maxPQ.peek().price;
    }

    public void test() {
        System.out.println("\n ----- self-testing");

        System.out.println("\n ----- 4 add order");
        add(1, 10.5);
        add(2, 100.5);
        add(3, 20.5);
        add(4, 30.5);
        System.out.println("The maximum price should be 100.5. Test Result is:" + get_high_price());

        System.out.println("\n ----- 5 sell orders");
        sell(2);
        System.out.println("The maximum price should be 30.5. Test Result is:" + get_high_price());
        sell(1);
        System.out.println("The maximum price should be 30.5. Test Result is:" + get_high_price());
        sell(4);
        System.out.println("The maximum price should be 20.5. Test Result is:" + get_high_price());
        sell(3);
        System.out.println("The maximum price should be -1. Test Result is:" + get_high_price());
    }

    public static void main(String[] args) {
        OAAkunaP2 p2 = new OAAkunaP2();
        p2.test();
    }
}
