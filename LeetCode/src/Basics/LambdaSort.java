package Basics;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 9/13/17.
 */
class human {
    public String name;
    public int age;

    public human(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class LambdaSort {
    /**
     * Comparator means:
     * -1 : o1 < o2
     * 0 : o1 == o2
     * +1 : o1 > o2
     * The general syntax of a lambda expression is:
     * () -> {}                    when lambda expressions's body has to be a block
     * OR   () -> a single statement
     */

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing of sorting using lambda statement");
        human h1 = new human("A", 20);
        human h2 = new human("Z", 30);
        human h3 = new human("Z", 15);
        List<human> humans = new LinkedList<>();
        humans.add(h1);
        humans.add(h2);
        humans.add(h3);
        System.out.println(humans.get(1).name + " " + humans.get(1).age);

        System.out.println("\n ----- sorting");

        System.out.println("\n ----- reverse comparater");
        Comparator<human> comparator = (a, b) -> a.name.compareTo(b.name);
        humans.sort(comparator.reversed());
        System.out.println(humans.get(0).name + " " + humans.get(0).age);
        System.out.println(humans.get(1).name + " " + humans.get(1).age);
        System.out.println(humans.get(2).name + " " + humans.get(2).age);

        System.out.println("\n ----- multiple condition");
        comparator = (a, b) -> {
            if (a.name.equals(b.name)) {
                return a.age - b.age;
            } else {
                return a.name.compareTo(b.name);
            }
        };
        humans.sort(comparator);
        System.out.println(humans.get(0).name + " " + humans.get(0).age);
        System.out.println(humans.get(1).name + " " + humans.get(1).age);
        System.out.println(humans.get(2).name + " " + humans.get(2).age);
    }
}
