package Basics;

/**
 * Created by ginolee on 9/14/17.
 */

/**
 * two fields
 * 1. sentinal
 * 2. size
 */
class DList {
    DListNode sentinel;
    int size;

    public DList() {
        sentinel = new DListNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void insertTail(DListNode newNode) {
        // tail actually: 4 operations here
        newNode.next = sentinel;
        sentinel.prev.next = newNode;
        newNode.prev = sentinel.prev;
        sentinel.prev = newNode;
        size++;
    }

    public void removeNode(DListNode node) {
        DListNode prevNode = node.prev;
        prevNode.next = node.next;
        node.next.prev = prevNode;
        size--;
    }

    // return the key
    public int removeFront() {
        int res = sentinel.next.key;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return res;
    }

    @Override
    public String toString() {
        String output = "[ ";
        DListNode cur = sentinel;
        while (cur.next != sentinel) {
            output += "(" + cur.next.key + ", " + cur.next.val + ") ";
            cur = cur.next;
        }
        return output + "]";
    }
    public static void main(String[] args) {
        System.out.println("self-test of DList");
        DList dl = new DList();
        System.out.println(dl);
        DListNode node1 = new DListNode(1, 2);
        DListNode node2 = new DListNode(2, 3);
        dl.insertTail(node1);
        System.out.println(dl + " size: " + dl.size);
        dl.insertTail(node2);
        System.out.println(dl + " size: " + dl.size);
//        System.out.println(dl.sentinel.next.val);
//        dl.removeNode(dl.sentinel.next);
        dl.removeFront();
        System.out.println(dl + " size: " + dl.size);
    }
}
