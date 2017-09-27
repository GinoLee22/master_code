package Basics;

import java.util.*;

/**
 * Created by ginolee on 9/13/17.
 */
public class IteratorTest {
    /**
     *  An iterator over a collection.
     *  Iterator takes the place of Enumeration in the Java Collections Framework. Iterators differ from enumerations in two ways:
        1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
        2. Method names have been improved.
     *
     *
     */
    public static void main(String[] args) {
        System.out.println("self-testing of Iterator / ListIterator");
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");

        //          A -> B -> C -> D -> E -> F
        // "it" is before A & it.next() return the value store in list
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();
        ListIterator<String> listIt = list.listIterator();
        while (listIt.hasNext()) {
            listIt.set(listIt.next() + "+");
        }
        listIt = list.listIterator();
        while (listIt.hasNext()) {
            System.out.print(listIt.next() + " ");
        }

    }
}
