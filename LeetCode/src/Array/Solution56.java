package Array;

import BinarySearch.Interval;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by ginolee on 7/7/17.
 */


public class Solution56 {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        // sort based on the start
        intervals.sort((a, b) -> (a.start - b.start));
        Iterator<Interval> it = intervals.listIterator();
        Interval cur = it.next();
        return null;
    }

    public static void main(String[] args) {
        System.out.println("self-testing of Java Iterator");
        System.out.println("Original List");
        List<Integer> ls = new LinkedList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        System.out.println(ls);
        System.out.println("list iterator");
        ListIterator<Integer> it = ls.listIterator();
        System.out.println(it.next());


    }
}
