package Basics;

/**
 * Created by ginolee on 9/14/17.
 */
class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}

public class Rehashing {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        // get the "capacity" & "size" of  the hashTable to determine if need rehashing
        int capacity = hashTable.length;
        int size = 0;
        for (int i = 0; i < capacity; i++) {
            size += getListSize(hashTable[i]);
        }

        // rehashing or not
        if (size < capacity / 10) {
            return hashTable;
        }

        capacity *= 2;
        ListNode[] newMap = new ListNode[capacity];
        for (ListNode list : hashTable) {
            ListNode cur = list;
            while (cur != null) {
                int code = hashcode(cur.val, capacity);
                if (newMap[code] == null) {
                    newMap[code] = new ListNode(cur.val);
                } else {
                    // find the tail of the bucket
                    ListNode dummy = newMap[code];
                    while (dummy.next != null) {
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(cur.val);
                }
                cur = cur.next;
            }
        }
        return newMap;
    }

    private int hashcode(int key, int capacity) {
        int newKey = key % capacity;
        return newKey < 0 ? newKey + capacity : newKey;
    }

    private int getListSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        Rehashing rh = new Rehashing();
        ListNode l1 = new ListNode(21);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(14);
        ListNode[] hashTable = new ListNode[]{null, l1, l2, null};
        rh.rehashing(hashTable);
    }
}
