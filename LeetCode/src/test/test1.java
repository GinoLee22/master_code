package test;

import java.util.*;

/**
 * Created by ginolee on 5/15/17.
 */


public class test1 {
    class Record {
        int id;
        int score;

        public Record(int mId, int mScore) {
            id = mId;
            score = mScore;
        }
    }

    public void t() {
        Record r1 = new Record(1, 100);
    }

    public static void main(String[] args) {
        test1 ttt = new test1();
        test1.Record r1 = ttt.new Record(1, 100);
        System.out.println(r1.score);

        System.out.println(-1 << 1);
    }
}

