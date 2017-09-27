package ClosestPair;

/**
 * Created by GinoLee on 2017/2/12.
 */

import java.awt.geom.Point2D;
import java.util.Comparator;

public class XComparator implements Comparator<Point2D> {

    public int compare(Point2D a, Point2D b) {
        if (a.getX() == b.getX())
            return 0;
        if  (a.getX() > b.getX())
            return 1;
        else
            return -1;
    }

}