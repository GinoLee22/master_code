package lab5;

import com.sun.tools.hat.internal.util.ArraySorter;

import java.util.Arrays;

/**
 * Created by ginolee on 1/1/17.
 */
public class Friend extends People implements Comparable {

    // field inherits from superclass
    public static final String constant = "helloworld!";


    // constructor: There is no zero-parameter constructor in superclass so must declare one
    public Friend (String name, int age) {
        super(name, age);
    }

    @Override
    public int compareTo (Object obj) {
        // 1st: CAST the object to class Friend
        Friend f = (Friend) obj;
        if (this.mAge < f.mAge) {
            return -1;
        }
        else if (this.mAge == f.mAge) {
            return 0;
        }
        else {
            return 1;
        }
    }

    // method
    public String toString() {
        return mName + " is one of my best friends. He (She) is " + mAge + " years old.";
    }

    public static void main(String[] args) {
        System.out.println("\n ---------- Testing of subclass \"Friend\". ");
        Friend fd1 = new Friend("HanBing", 25);
        Friend fd2 = new Friend("LuXing", 24);
        Friend fd3 = new Friend("ChenJia", 24);
        Friend fd4 = new Friend("ZhaoAnda", 23);
        System.out.println(fd1.toString());
        System.out.println(fd2.toString());
        System.out.println(fd3.toString());
        System.out.println(fd4.toString());

        System.out.println("\n ---------- Testing of static field.");
        System.out.println(constant);

        System.out.println("\n ---------- Testing of comparable interface.");
        System.out.println(fd2.compareTo(fd1));
        System.out.println(fd2.compareTo(fd4));

        System.out.println("\n ---------- Testing of sorting library implemented by comparable interface");
        Friend[] friendArray = {fd2, fd4, fd3, fd1};
        System.out.println("Result before sorting.");
        for (Friend f : friendArray) {
            System.out.println(f.toString());
        }
        System.out.println("Result after sorting.");
        Arrays.sort(friendArray);
        for (Friend f : friendArray) {
            System.out.println(f.toString());
        }


    }
}
