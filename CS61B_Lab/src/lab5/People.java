package lab5;

/**
 * Created by ginolee on 1/1/17.
 */
public class People {

    // field
    public static final String constant = "HelloWorld!";
    protected String mName;
    protected int mAge;

    // constructor
    public People(String name, int age) {
        mName = name;
        mAge = age;
    }

    // method
    public String toString() {
        return mName + " " + mAge;
    }

    public static void main(String[] args) {

    }
}
