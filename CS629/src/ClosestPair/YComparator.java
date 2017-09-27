package ClosestPair;

/**
 * Created by GinoLee on 2017/2/12.
 */

import java.awt.geom.Point2D;
import java.util.Comparator;

public class YComparator implements Comparator<Point2D> {

    public int compare(Point2D a, Point2D b) {
        if (a.getY() == b.getY())
            return 0;
        if  (a.getY() > b.getY())
            return 1;
        else
            return -1;
    }

}