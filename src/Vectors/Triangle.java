package Vectors;

public class Triangle {
    private Point _p1;
    private Point _p2;
    private Point _p3;

    public Triangle (Point p1, Point p2, Point p3) {
        _p1 = p1;
        _p2 = p2;
        _p3 = p3;
        validate();
    }

    public Triangle(Point[] points) {
        _p1 = points[0];
        _p2 = points[1];
        _p3 = points[2];
        validate();
    }

    public Triangle(Vector u, Vector v) {
        _p1 = new Point(0,0,0);
        _p2 = new Point(u.getX(), u.getY(), u.getZ());
        _p3 = new Point(v.getX(), v.getY(), v.getZ());
        validate();
    }

    public Point[] getPoints() {
        return new Point[]{_p1, _p2, _p3};
    }

    public Number getArea() {
        // Area = "|(p1->p2 x p1->p3)| * 0.5"
        Vector v1 = new Vector(_p1, _p2);
        Vector v2 = new Vector(_p1, _p3);
        Vector crossProduct = v1.crossProduct(v2);
        return crossProduct.magnitude().divide(new DecimalNumber(2));
    }

    public String getAreaString() {
        Vector v1 = new Vector(_p1, _p2);
        Vector v2 = new Vector(_p1, _p3);
        Vector crossProduct = v1.crossProduct(v2);
        return "0.5 * |" + crossProduct + "|";
    }

    public String toString() {
        return "(" + _p1 + "), (" + _p2 + "), (" + _p3 + ")";
    }

    private void validate() {
        // Null points
        if (_p1 == null || _p2 == null || _p3 == null) {
            throw new RuntimeException("A Triangle was created with one or more null points.");
        }

        // Points at same postion
        if (_p1.equals(_p2) || _p1.equals(_p3) || _p2.equals(_p3)) {
            throw new RuntimeException("A Triangle was created with points at the same position.");
        }

        // Colinear points
        if (new Vector(_p1, _p2).isParallelTo(new Vector(_p2, _p3))) {
            throw new RuntimeException("A Triangle was created with three colinear points.");
        }
    }
}
