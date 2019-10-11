package Vectors;
/*
 * This can store the location of a point in 2 or 3 dimensions.
 */

import java.math.BigDecimal;

public class Point {
    private Number _x;
    private Number _y;
    private Number _z;

    public Point (Number x, Number y) {
        _x = x;
        _y = y;
        _z = DecimalNumber.ZERO;
    }

    public Point (double x, double y) {
        this(new DecimalNumber(x), new DecimalNumber(y), DecimalNumber.ZERO);
    }

    public Point (int x, int y) {
        this(new DecimalNumber(x), new DecimalNumber(y), DecimalNumber.ZERO);

    }

    public Point (long x, long y) {
        this(new DecimalNumber(x), new DecimalNumber(y), DecimalNumber.ZERO);
    }

    public Point (String x, String y) {
        this(new DecimalNumber(x), new DecimalNumber(y), DecimalNumber.ZERO);
    }

    public Point (Number x, Number y, Number z) {
        _x = x;
        _y = y;
        _z = z;
    }

    public Point (double x, double y, double z) {
        this(new DecimalNumber(x), new DecimalNumber(y), new DecimalNumber(z));
    }

    public Point (int x, int y, int z) {
        this(new DecimalNumber(x), new DecimalNumber(y), new DecimalNumber(z));
    }

    public Point (long x, long y, long z) {
        this(new DecimalNumber(x), new DecimalNumber(y), new DecimalNumber(z));
    }

    public Point (String x, String y, String z) {
        this(new DecimalNumber(x), new DecimalNumber(y), new DecimalNumber(z));
    }

    public Number getX() {
        return _x;
    }

    public Number getY() {
        return _y;
    }

    public Number getZ() {
        return _z;
    }

    public String toString() {
        return (_z.equals(DecimalNumber.ZERO)) ? ("(" + _x + ", " + _y + ")") : ("(" + _x + ", " + _y + ", " + _z + ")");
    }

    public String toString3D() {
        return "(" + _x + ", " + _y + ", " + _z + ")";
    }

    public boolean equals(Point other) {
        return _x.approximateEquals(other.getX()) &&
                _y.approximateEquals(other.getY()) &&
                _z.approximateEquals(other.getZ());
    }
}
