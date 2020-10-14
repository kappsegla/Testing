package triangle;

import java.util.Arrays;
import java.util.stream.Stream;

public class Triangle {

    double[] sides;

    public Triangle(double a, double b, double c) {
        sides = new double[]{a, b, c};
    }

    public Triangle(double[] s) {
        sides = new double[s.length];
        System.arraycopy(s, 0, sides, 0, s.length);
    }

    public Triangle(Point a, Point b, Point c) {
        sides = new double[3];
        sides[0] = Math.sqrt(getPow(b.x, a.x) + getPow(b.y, a.y));
        sides[1] = Math.sqrt(getPow(b.x, c.x) + getPow(b.y, c.y));
        sides[2] = Math.sqrt(getPow(c.x, a.x) + getPow(c.y, a.y));
    }

    private double getPow(int x, int x2) {
        return Math.pow((double) (x - x2), 2.0);
    }

    public Triangle(Point[] s) {
        this(s[0],s[1],s[2]);
//        sides = new double[s.length];
//        sides[0] = Math.sqrt(Math.pow((double) (s[1].x - s[0].x), 2.0) + Math.pow((double) (s[1].y - s[0].y), 2.0));
//        sides[1] = Math.sqrt(Math.pow((double) (s[1].x - s[2].x), 2.0) + Math.pow((double) (s[1].y - s[2].y), 2.0));
//        sides[2] = Math.sqrt(Math.pow((double) (s[2].x - s[0].x), 2.0) + Math.pow((double) (s[2].y - s[0].y), 2.0));
    }

    private int uniqueSides() {
        return (int) Arrays.stream(sides).distinct().count();
    }

    public boolean isScalene() {
        return uniqueSides() == 3;
    }

    public boolean isEquilateral() {
        return uniqueSides() == 1;
    }

    public boolean isIsosceles() {
        return uniqueSides() == 2;
    }
}