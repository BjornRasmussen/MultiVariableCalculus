package Vectors;
/*
 * Stores a vector.
 * Immutable, so once initialized, the value of a Vector will never change.
 */

import java.math.BigDecimal;

public class Vector {
    private Number _x;
    private Number _y;
    private Number _z;

    public final static Vector ZERO = new Vector(0,0,0);

    private final static double EQUALS_EPSILON = 0.0000001;

    public Vector(Number x, Number y) {
        _x = x;
        _y = y;
        _z = DecimalNumber.ZERO;
    }

    public Vector (double x, double y) {
        this(new DecimalNumber(x), new DecimalNumber(y), DecimalNumber.ZERO);
    }

    public Vector (int x, int y) {
        this(new DecimalNumber(x), new DecimalNumber(y), DecimalNumber.ZERO);

    }

    public Vector (long x, long y) {
        this(new DecimalNumber(x), new DecimalNumber(y), DecimalNumber.ZERO);
    }

    public Vector (String x, String y) {
        this(new DecimalNumber(x), new DecimalNumber(y), DecimalNumber.ZERO);
    }

    public Vector (Number x, Number y, Number z) {
        _x = x;
        _y = y;
        _z = z;
    }

    public Vector (double x, double y, double z) {
        this(new DecimalNumber(x), new DecimalNumber(y), new DecimalNumber(z));
    }

    public Vector (int x, int y, int z) {
        this(new DecimalNumber(x), new DecimalNumber(y), new DecimalNumber(z));
    }

    public Vector (long x, long y, long z) {
        this(new DecimalNumber(x), new DecimalNumber(y), new DecimalNumber(z));
    }

    public Vector (String x, String y, String z) {
        this(new DecimalNumber(x), new DecimalNumber(y), new DecimalNumber(z));
    }

    // Creates vector from origin to the input point.
    public Vector (Point p) {
        _x = p.getX();
        _y = p.getY();
        _z = p.getZ();
    }

    // Creates vector from the first point to the second point.
    public Vector (Point p1, Point p2) {
        _x = p2.getX().subtract(p1.getX());
        _y = p2.getY().subtract(p1.getY());
        _z = p2.getZ().subtract(p1.getZ());
    }


    // Returns a new vector that is the result of adding this one to the input
    public Vector add(Vector other) {
        return new Vector(_x.add(other.getX()), _y.add(other.getY()), _z.add(other.getZ()));
    }

    // Returns a dot product double that represents "this * input"
    // Works in both 2 and 3 dimensions.
    public Number dotProduct(Vector other) {
        return (_x.multiply(other.getX()).add(_y.multiply(other.getY())).add(_z.multiply(other.getZ())));
    }

    // Returns a new vector that is the cross product "this x input"
    public Vector crossProduct(Vector other) {
        Vector crossProduct = new Vector(_y.multiply(other.getZ()).subtract(_z.multiply(other.getY())),
                _x.multiply(other.getZ()).subtract(_z.multiply(other.getX())).multiply(new DecimalNumber(-1)),
                _x.multiply(other.getY()).subtract(_y.multiply(other.getX())));
        return crossProduct;
    }

    public boolean isPerpendicularTo(Vector other) {
        return this.dotProduct(other).abs().isLessThan(new DecimalNumber(EQUALS_EPSILON));
    }

    public boolean isParallelTo(Vector other) {
        return this.crossProduct(other).equals(new Vector(0,0,0));
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

    @Override
    public String toString() {
        return (_z.equals(DecimalNumber.ZERO)) ? ("<" + _x + ", " + _y + ">") : ("<" + _x + ", " + _y + ", " + _z + ">");

    }

    public String toString3D() {
        return "<" + _x + ", " + _y + ", " + _z + ">";
    }

    public Number magnitude() {
        return (_x.multiply(_x).add(_y.multiply(_y)).add(_z.multiply(_z)));
    }

    public Vector divide(Number divisor) {
        return new Vector(_x.divide(divisor), _y.divide(divisor), _z.divide(divisor));
    }

    public Vector multiply(Number multiplier) {
        return new Vector(_x.multiply(multiplier), _y.multiply(multiplier), _z.multiply(multiplier));
    }

    public Vector toUnitVector() {
        // Unit vectors with the same direction are
        // "this" / "this.magnitude()"

        return this.divide(this.magnitude());
    }

    public boolean equals(Vector other) {
        return _x.approximateEquals(other.getX()) &&
                _y.approximateEquals(other.getY()) &&
                _z.approximateEquals(other.getZ());
    }

    public Angle angleTo(Vector u) {
        return dotProduct(u).divide(this.magnitude().multiply(u.magnitude())).arccos();
    }
}
