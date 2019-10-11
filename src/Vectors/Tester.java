package Vectors;

import Vectors.arXiv.BigDecimalMath;
import java.math.BigDecimal;

public class Tester {

    public static void main(String[] args) {
        Vector v = new Vector(5, 8, 1);
        Vector u = new Vector(100293, 10299, 84881);
        System.out.println(u.crossProduct(v));
        System.out.println(u.dotProduct(v));
        Plane plane = new Plane(new Point(0, 0, 0), new Vector(0,0,1));
        System.out.println(plane);
        Plane plane2 = new Plane(new Point("-123329839849832984879879898982349832432987498987329874983249832984984.90", "192017829343243475987234234998982398498982983987423.0"), new Vector("0", "0", "19832432987329874989898239847329874987329874987989832"));
        System.out.println(plane.equals(plane2));
    }
}
