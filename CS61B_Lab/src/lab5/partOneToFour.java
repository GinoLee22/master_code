package lab5;

/**
 * Created by ginolee on 1/1/17.
 */
public class partOneToFour {

    public static void main(String[] args) {
        System.out.println("\n ---------- Testing: Assign subclass directly to superclass");
        People[] peopleArray1;
        Friend[] friendArray1 = new Friend[4];
        friendArray1[0] = new Friend("HanBing", 25);
        friendArray1[1] = new Friend("LuXing", 24);
        friendArray1[2] = new Friend("ChenJia", 24);
        friendArray1[3] = new Friend("ZhaoAnda", 23);
        peopleArray1 = friendArray1;
        friendArray1 = (Friend[]) peopleArray1;
        for (People p : peopleArray1) {
            System.out.println(p.toString());
        }

        System.out.println("\n ---------- Testing: Assign superclass (directly) to subclass && Override method");
        People[] peopleArray2 = new Friend[4];          // here: must be Fiend[4] not People[4] or ClassCastException
//        People[] peopleArray2 = new People[4];
        Friend[] friendArray2;

//        peopleArray2[0] = new People("HanBing", 25);
//        peopleArray2[1] = new People("LuXing", 24);
//        peopleArray2[2] = new People("ChenJia", 24);
//        peopleArray2[3] = new People("ZhaoAnda", 23);

        peopleArray2[0] = new Friend("HanBing", 25);
        peopleArray2[1] = new Friend("LuXing", 24);
        peopleArray2[2] = new Friend("ChenJia", 24);
        peopleArray2[3] = new Friend("ZhaoAnda", 23);
        friendArray2 = (Friend[]) peopleArray2;

        // The following code of the application should not change whatever. Only the constructors change
        for (People p : peopleArray2) {
            System.out.println(p.toString());
        }

        System.out.println("\n ---------- Testing: same name && same value final constant.");
        System.out.println(People.constant);
        System.out.println(Friend.constant);

        System.out.println("\n ---------- Testing of method override");
        Friend fd1 = new Friend("ZhangYuqing", 24);
        People p1 = (People) fd1;
        System.out.println((p1.toString()));
    }
}
