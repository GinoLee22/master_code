package Basics;

/**
 * Created by ginolee on 9/13/17.
 */
public class SelfArrayList {
    /**
     * objects: designed to "Object" type due to generic
     * idx: always points to the next position to add
     */

    Object[] objects;
    int idx;

    public SelfArrayList() {
        objects = new Object[10];
        idx = 0;
    }

    public void add(Object obj) {
        if (idx < objects.length) {
            objects[idx] = obj;
        } else {        // re-allocate the space
            Object[] newArray = new Object[objects.length * 2];
            for (int i = 0; i < objects.length; i++) {
                newArray[i] = objects[i];
            }
            newArray[idx] = obj;
            objects = newArray;
        }
        idx++;
    }

    @Override
    public String toString() {
        String output = "[ ";
        for (int i = 0; i < idx; i++) {
            output += (objects[i] + " ");
        }
        return output + "]";
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        SelfArrayList sal = new SelfArrayList();
        sal.add("1");
        sal.add("1");
        sal.add("1");
        sal.add("1");
        System.out.println(sal.toString());

        sal.add("1");
        sal.add("1");
        sal.add("1");
        sal.add("1");
        sal.add("1");
        sal.add("1");
        System.out.println(sal.toString());

        sal.add("1");
        System.out.println(sal.toString());

    }
}
