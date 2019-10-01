package Vectors;
/*
 * Stores a vector.
 * Immutable, so once initialized, the value of a Vector will never change.
 */

import java.math.BigDecimal;

public class Vector {
    private double _x;
    private double _y;
    private double _z;

    private final static double EQUALS_EPSILON = 0.0000001;

    public Vector (double x, double y) {
        _x = x;
        _y = y;
        _z = 0;
    }

    public Vector (double x, double y, double z) {
        _x = x;
        _y = y;
        _z = z;
    }

    // Creates vector from origin to the input point.
    public Vector (Point p) {
        _x = p.getX();
        _y = p.getY();
        _z = p.getZ();
    }

    // Creates vector from the first point to the second point.
    public Vector (Point p1, Point p2) {
        _x = p2.getX() - p1.getX();
        _y = p2.getY() - p1.getY();
        _z = p2.getZ() - p1.getZ();
    }


    // Returns a new vector that is the result of adding this one to the input
    public Vector add(Vector other) {
        return new Vector(_x + other.getX(), _y + other.getY(), _z + other.getZ());
    }

    // Returns a dot product double that represents "this * input"
    // Works in both 2 and 3 dimensions.
    public double dotProduct(Vector other) {
        return (_x*other.getX() + _y*other.getY() + _z * other.getZ());
    }

    // Returns a new vector that is the cross product "this x input"
    public Vector crossProduct(Vector other) {
        Vector crossProduct = new Vector(_y*other.getZ() - _z*other.getY(),
                -1 * (_x*other.getZ() - _z*other.getX()),
                _x*other.getY() - _y*other.getX());
        return crossProduct;
    }

    public boolean isPerpendicularTo(Vector other) {
        return Math.abs(this.dotProduct(other)) < EQUALS_EPSILON;
    }

    public boolean isParallelTo(Vector other) {
        return this.crossProduct(other).equals(new Vector(0,0,0));
    }

    public Vector clone() {
        return new Vector(_x, _y, _z);
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
        return "<" + _x + ", " + _y + ", " + _z + ">";
    }

    public double magnitude() {
        return Math.sqrt(_x*_x + _y*_y + _z*_z);
    }

    public Vector divide(double divisor) {
        return new Vector(_x/divisor, _y/divisor, _z/divisor);
    }

    public Vector multiply(double input) {
        return new Vector(_x*input, _y*input, _z*input);
    }

    public Vector toUnitVector() {
        // Unit vectors with the same direction are
        // "this" / "this.magnitude()"

        return this.divide(this.magnitude());
    }

    public boolean equals(Vector other) {
        return dEquals(_x, other.getX()) &&
                dEquals(_y, other.getY()) &&
                dEquals(_z, other.getZ());
    }

    public Angle angleTo(Vector u) {
        double dotProduct = this.dotProduct(u);
        return new Angle(new BigDecimal((180 / Math.PI) * Math.acos(dotProduct / this.magnitude() / u.magnitude())));
    }

    private static boolean dEquals(double a, double b) {
        return Math.abs(a-b) < EQUALS_EPSILON;
    }
}
