package Vectors;
/*
 * Stores a plane.
 */
public class Plane {
    private Vector _v;
    private Point _p;

    public Plane(Vector normalVector, Point basePoint) {
        _v = normalVector;
        _p = basePoint;
        validate();
    }

    public Plane(Point basePoint, Vector normalVector) {
        _v = normalVector;
        _p = basePoint;
        validate();
    }

    public boolean equals(Plane other) {
        return other.normalVector().isParallelTo(_v) &&
                this.contains(other.basePoint());
    }

    public boolean contains(Point p) {
        // Returns true if the point p lives on this plane.
        Vector u = new Vector(p, _p);
        return u.isPerpendicularTo(_v);
    }

    public boolean contains(Line l) {
        // Returns true if all points on l live on this plane.
        return this.contains(l.basePoint()) &&
                l.directionVector().isPerpendicularTo(_v);
    }

    public Vector normalVector() {
        return _v;
    }

    public Point basePoint() {
        return _p;
    }

    private void validate() {
        if (_p == null) {
            throw new IllegalArgumentException("Null point entered into new plane.");
        }
        if (_v == null) {
            throw new IllegalArgumentException("Null vector entered into new plane.");
        }
        if (_v.equals(Vector.ZERO)) {
            throw new IllegalArgumentException("Zero vectors cannot define direction.");
        }
    }

    public String toString() {
        return "Point: " + _p.toString3D() + ", Normal Vector: " + _v.toString3D();
    }
}
