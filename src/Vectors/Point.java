package Vectors;
/*
 * This can store the location of a point in 2 or 3 dimensions.
 */

import java.math.BigDecimal;

public class Point {
    private Number _x;
    private Number _y;
    private Number _z;

    public Point(Number x, Number y) {
        _x = x;
        _y = y;
        _z = DecimalNumber.ZERO;
    }

    public Point(double x, double y) {
        _x = new DecimalNumber(new BigDecimal(x));
        _y = new DecimalNumber(new BigDecimal(y));
    }

    public Point(Number x, Number y, Number z) {
        _x = x;
        _y = y;
        _z = z;
    }

    public Point(double x, double y, double z) {
        _x = new DecimalNumber(new BigDecimal(x));
        _y = new DecimalNumber(new BigDecimal(y));
        _z = new DecimalNumber(new BigDecimal(z));
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
        return (_z.equals(DecimalNumber.ZERO)) ? (_x + ", " + _y) : (_x + ", " + _y + ", " + _z);
    }

    public boolean equals(Point other) {
        return _x.approximateEquals(other.getX()) &&
                _y.approximateEquals(other.getY()) &&
                _z.approximateEquals(other.getZ());
    }
}
