package ClosestPair;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Random;


/**
 * Created by GinoLee on 2017/2/12.
 */
public class ClosestPair {
    // private variable
    public Point2D point1;
    public Point2D point2;
    public double minDistance = Double.POSITIVE_INFINITY;

    public ClosestPair(Point2D[] points) {
        int size = points.length;
        // sort by x-coordinate
        Point2D[] sortByX = new Point2D[size];
        for (int i = 0; i < size; i++) {
            sortByX[i] = points[i];
        }
        Arrays.sort(sortByX, new XComparator());

        Point2D[] sortByY = new Point2D[size];
        for (int i = 0; i < size; i++) {
            sortByY[i] = sortByX[i];
        }

//        Arrays.sort(sortByY, new YComparator());
        // help array to store all the points within the distance 2d and sorted by y-coordinate
        Point2D[] help = new Point2D[size];
        divideAndConquer(sortByX, sortByY, help, 0, size - 1);
    }

    // divide and conquer algorithm for closest pair
    private double divideAndConquer(Point2D[] sortByX, Point2D[] sortByY, Point2D[] help, int left, int right) {
        /**
         * base case
         */
        if (right <= left) {
            return Double.POSITIVE_INFINITY;
        }
        /**
         * recursion part
         */
        int mid = (left + right) / 2;
        Point2D midPoint = sortByX[mid];
        // the distance
        double d1 = divideAndConquer(sortByX, sortByY, help, left, mid);
        double d2 = divideAndConquer(sortByX, sortByY, help, mid + 1, right);
        double d = Math.min(d1, d2);

        // merge back so that pointsByY[lo..hi] are sorted by y-coordinate
        merge(sortByY, help, left, mid, right);

        // extract the points within the strips of the minimum distance 2d.
        // All the element in front of help array is the extracted points
        int m = 0;
        for (int i = left; i <= right; i++) {
            double currentD = Math.abs(sortByY[i].getX() - midPoint.getX());
            if (currentD < d) {
                help[m] = sortByY[i];
                m++;
            }
        }
        // calculate the distance between the left side and right side
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; (j < m) && (help[j].getY() - help[i].getY()) < d; j++) {
                double currentD = help[j].distance(help[i]);
                if (currentD < d) {
                    d = currentD;
                    if (d < minDistance) {
                        minDistance = d;
                        point1 = help[i];
                        point2 = help[j];
                    }
                }
            }
        }
        return d;
    }

    private static void merge(Point2D[] sortByY, Point2D[] help, int left, int mid, int right) {
        // make copy of array sortByY
        for (int i = left; i <= right; i++) {
            help[i] = sortByY[i];
        }
        // merge
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (help[i].getY() < help[j].getY()) {
                sortByY[k] = help[i];
                if (i < mid) {
                    i++;
                } else {
                    help[i] = new Point2D.Double(0, Double.POSITIVE_INFINITY);
                }
            } else if (help[i].getY() > help[j].getY()){
                sortByY[k] = help[j];
                if (j < right) {
                    j++;
                } else {
                    help[j] = new Point2D.Double(0, Double.POSITIVE_INFINITY);
                }
            } else {        // they are equal
                sortByY[k] = help[i];
                k++;
                sortByY[k] = help[j];
                if (i < mid) {
                    i++;
                } else {
                    help[i] = new Point2D.Double(0, Double.POSITIVE_INFINITY);
                }
                if (j < right) {
                    j++;
                } else {
                    help[j] = new Point2D.Double(0, Double.POSITIVE_INFINITY);
                }
            }
        }
    }

    private static double bruteForce(Point2D[] points) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double cur = points[i].distance(points[j]);
                min = Math.min(min, cur);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        // randomly create the points
        int n = 10000;
        Point2D points[] = new Point2D.Double[n];
        Random ran = new Random();

        for (int i = 0; i < n; i++) {
            int scaling = 100;
            double x = scaling * ran.nextDouble();
            double y = scaling * ran.nextDouble();
            points[i] = new Point2D.Double(x, y);
        }

        // divide and conquer
        System.out.println("Solution given by divide & conquer");
        long startTime1 = System.currentTimeMillis();
        ClosestPair cp = new ClosestPair(points);
        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1 - startTime1);
//        System.out.println(cp.minDistance + "\n" + cp.point1.toString() + "\n" + cp.point2.toString());
        System.out.println(cp.minDistance);
        System.out.println("Solution given by bruteforce");
        long startTime2 = System.currentTimeMillis();
        System.out.println(bruteForce(points));
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime2 - startTime2);
    }
}
