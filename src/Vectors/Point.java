package Vectors;
/*
 * This can store the location of a point in 2 or 3 dimensions.
 */

public class Point {
    private static final double EQUALS_EPSILON = 0.0000001;
    private double _x;
    private double _y;
    private double _z;

    public Point(double x, double y) {
        _x = x;
        _y = y;
    }

    public Point(double x, double y, double z) {
        _x = x;
        _y = y;
        _z = z;
    }


    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;
    }

    public double getZ() {
        return _z;
    }

    public String toString() {
        return (_z == 0) ? (_x + ", " + _y) : (_x + ", " + _y + ", " + _z);
    }

    public boolean equals(Point other) {
        return ((Math.abs(_x - other.getX()) < EQUALS_EPSILON) &&
                (Math.abs(_y - other.getY()) < EQUALS_EPSILON) &&
                (Math.abs(_z - other.getZ()) < EQUALS_EPSILON));
    }
}
