package test;

/**
 * Created by ginolee on 8/18/17.
 */
public class testConstructor {
    private char property1;
    private int property2;

    public testConstructor () {

    }

    public testConstructor(char str, int i) {
        property1 = str;
        property2 = i;
    }

    public static void main(String[] args) {
        System.out.println("self-testing");
        testConstructor tc = new testConstructor();
        System.out.println(tc.property1);
        System.out.println(tc.property2);
        System.out.println('\u0000');
    }
}
