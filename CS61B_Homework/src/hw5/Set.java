/* Set.java */
package hw5;

import hw5.list.*;

import java.util.Objects;

/**
 * A Set is a collection of Comparable elements stored in sorted order.
 * Duplicate elements are not permitted in a Set.
 **/
public class Set {
  /* Fill in the data fields here. */
    List lst;

    /**
     * Set ADT invariants:
     *  1)  The Set's elements must be precisely the elements of the List.
     *  2)  The List must always contain Comparable elements, and those elements
     *      must always be sorted in ascending order.
     *  3)  No two elements in the List may be equal according to compareTo().
     **/

    /**
     * Constructs an empty Set.
     * <p>
     * Performance:  runs in O(1) time.
     **/
    public Set() {
        // Your solution here.
        // construct the Set using DList
        lst = new DList();
    }

    /**
     * cardinality() returns the number of elements in this Set.
     * <p>
     * Performance:  runs in O(1) time.
     **/
    public int cardinality() {
        // Replace the following line with your solution.
//        return 0;
        return lst.length();
    }

    /**
     * insert() inserts a Comparable element into this Set.
     * <p>
     * Sets are maintained in sorted order.  The ordering is specified by the
     * compareTo() method of the java.lang.Comparable interface.
     * <p>
     * Performance:  runs in O(this.cardinality()) time.
     **/
    public void insert(Comparable c) throws  InvalidNodeException{
        // Your solution here.

        // if it is an empty set
        if (lst.isEmpty()) {
            lst.insertBack(c);
            return;
        }
        // if c larger than all the elements in Set
        if (c.compareTo((lst.back().item())) > 0) {
            lst.back().insertAfter(c);
            return;
        }
        // c is smaller than or equal to the largest element
        ListNode currentNode = lst.front();    // initially it is the 1st node
        while (c.compareTo(currentNode.item()) > 0) {
            currentNode = currentNode.next();
        }
        // here: currentNode.item() >= c
        if (c.compareTo(currentNode.item()) == 0) {       // unique element --> no action
            return;
        }
        else {      // currentNode.item() > c
            currentNode.insertBefore(c);
        }
    }

    /**
     * union() modifies this Set so that it contains all the elements it
     * started with, plus all the elements of s.  The Set s is NOT modified.
     * Make sure that duplicate elements are not created.
     * <p>
     * Performance:  Must run in O(this.cardinality() + s.cardinality()) time.
     * <p>
     * Your implementation should NOT copy elements of s or "this", though it
     * will copy _references_ to the elements of s.  Your implementation will
     * create new _nodes_ for the elements of s that are added to "this", but
     * you should reuse the nodes that are already part of "this".
     * <p>
     * DO NOT MODIFY THE SET s.
     * DO NOT ATTEMPT TO COPY ELEMENTS; just copy _references_ to them.
     **/
    public void union(Set s) throws InvalidNodeException{
        // Your solution here.
        ListNode a = s.lst.front();
        ListNode b = lst.front();

        while (a.isValidNode()) {
            if (((Comparable) (a.item())).compareTo(b.item()) < 0) {
                b.insertBefore(a.item());
                a = a.next();
            }
            else if (((Comparable) (a.item())).compareTo(b.item()) == 0) {
                a = a.next();
                b = (b.next()).isValidNode() ? b.next() : b;
            }
            else {
                if (!(b.next()).isValidNode()) {
                    b.insertAfter(a.item());
                }
                else {
                    b = b.next();
                }
            }
        }
    }

    /**
     * intersect() modifies this Set so that it contains the intersection of
     * its own elements and the elements of s.  The Set s is NOT modified.
     * <p>
     * Performance:  Must run in O(this.cardinality() + s.cardinality()) time.
     * <p>
     * Do not construct any new ListNodes during the execution of intersect.
     * Reuse the nodes of "this" that will be in the intersection.
     * <p>
     * DO NOT MODIFY THE SET s.
     * DO NOT CONSTRUCT ANY NEW NODES.
     * DO NOT ATTEMPT TO COPY ELEMENTS.
     **/
    public void intersect(Set s) throws InvalidNodeException{
        // Your solution here.
        ListNode a = s.lst.front();
        ListNode b = lst.front();

        while (b.isValidNode()) {
            if (((Comparable) (b.item())).compareTo(a.item()) < 0) {
                b = b.next();
                b.prev().remove();
            }
            else if (((Comparable) (b.item())).compareTo(a.item()) == 0) {
                b = b.next();
                a = (a.next()).isValidNode() ? a.next() : a;
            }
            else {
                if (!a.next().isValidNode()) {
                    b.remove();
                }
                else {
                    a = a.next();
                }
            }
        }
    }

    /**
     * toString() returns a String representation of this Set.  The String must
     * have the following format:
     * {  } for an empty Set.  No spaces before "{" or after "}"; two spaces
     * between them.
     * {  1  2  3  } for a Set of three Integer elements.  No spaces before
     * "{" or after "}"; two spaces before and after each element.
     * Elements are printed with their own toString method, whatever
     * that may be.  The elements must appear in sorted order, from
     * lowest to highest according to the compareTo() method.
     * <p>
     * WARNING:  THE AUTOGRADER EXPECTS YOU TO PRINT SETS IN _EXACTLY_ THIS
     * FORMAT, RIGHT UP TO THE TWO SPACES BETWEEN ELEMENTS.  ANY
     * DEVIATIONS WILL LOSE POINTS.
     **/
    public String toString() {
        // Replace the following line with your solution.
//        return "";
        return lst.toString();
    }

    public static void main(String[] argv) throws InvalidNodeException{
        Set s = new Set();
        s.insert(new Integer(3));
        s.insert(new Integer(4));
        s.insert(new Integer(3));
        System.out.println("Set s = " + s);

        Set s2 = new Set();
        s2.insert(new Integer(4));
        s2.insert(new Integer(5));
        s2.insert(new Integer(5));
        System.out.println("Set s2 = " + s2);

//        s.intersect(s2);
//        System.out.println("Set s.intersect(s2), s = " + s);

        Set s3 = new Set();
        s3.insert(new Integer(5));
        s3.insert(new Integer(3));
        s3.insert(new Integer(8));
        System.out.println("Set s3 = " + s3);

        s.union(s2);
        System.out.println("After s.union(s2), s = " + s);

        s.intersect(s3);
        System.out.println("After s.intersect(s3), s = " + s);

        System.out.println("s.cardinality() = " + s.cardinality());
        // You may want to add more (ungraded) test code here.
    }
}
