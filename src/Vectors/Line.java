package Vectors;

public class Line {
    private Point _p;
    private Vector _v;

    private static final double EQUALS_EPSILON = 0.0000001;
    // Vectors within this amount of equalness for stuff are considered equal.

    public Line(Point basePoint, Vector direction) {
        _p = basePoint;
        _v = direction;
    }

    public boolean equals(Line other) {
        // To be equal, slopeEquals(other) and intersects(other) must be true.
        return slopeEquals(other) && other.contains(_p);
    }


    public boolean slopeEquals(Line other) {
        Vector otherDirection = other.direction();
        Vector thisDirection = _v.toUnitVector();


        return (thisDirection.equals(otherDirection) ||
                thisDirection.equals(otherDirection.multiply(new DecimalNumber(-1))));
    }

    public boolean contains(Point p) {
        Vector parallel = new Vector(_p, p);
        return parallel.isParallelTo(_v);
    }

//	public boolean intersects(Line other) {
//		// Format is:
//		// thisX = thisPointX + (thisVectorX * T1)
//		// thisY = thisPointY + (thisVectorY * T1)
//		// thisZ = thisPointZ + (thisVectorZ * T1)
//
//		// otherX = otherPointX + (otherVectorX * T2)
//		// otherY = otherPointY + (otherVectorY * T2)
//		// otherZ = otherPointZ + (otherVectorZ * T2)
//
//		// Solve this equation to find T1 and T2
//		// thisPointX + (thisVectorX * T1) = otherPointX + (otherVectorX * T2)
//		// thisPointY + (thisVectorY * T1) = otherPointY + (otherVectorY * T2)
//		// thisPointZ + (thisVectorZ * T1) = otherPointZ + (otherVectorZ * T2)
//
//		// T1 = (otherPointX + (otherVectorX * T2) - thisPointX) / thisVectorX
//		// T1 = (otherPointY + (otherVectorY * T2) - thisPointY) / thisVectorY
//		// T1 = (otherPointZ + (otherVectorZ * T2) - thisPointZ) / thisVectorZ
//
//		// So, if some value of T2 can make all of those equal, then the lines intersect.
//
//		//      (otherPointX + (otherVectorX * T2) - thisPointX) / thisVectorX
//		//    = (otherPointY + (otherVectorY * T2) - thisPointY) / thisVectorY
//		//    = (otherPointZ + (otherVectorZ * T2) - thisPointZ) / thisVectorZ
//
//		//      ((otherPointX - thisPointX)/thisVectorX) + (otherVectorX/thisVectorX)*T2
//		//    = ((otherPointY - thisPointY)/thisVectorY) + (otherVectorY/thisVectorY)*T2
//		//    = ((otherPointZ - thisPointZ)/thisVectorZ) + (otherVectorZ/thisVectorZ)*T2
//
//		// Just find solution for first two.
//		// This could be either
//		// * a number value for T
//		// OR
//		// * any number works for T (plug in T+1; if it works, this is what happened).
//
//		// Then,
//		// if just one answer, plug into 3rd equation.  If this works, the lines intersect.  else, they don't.
//		// If no answers, the lines don't intersect.
//		// if every t works, solve the last two equations {
//		//    If every t works for those two, then the lines are colinear (all points intersect), so return true.
//		//    If there is just one solution, then the lines DO intersect.
//		//    If no Ts work, then the lines DON'T intersect.
//		//
//
//
//		// Program structure:
//		//  Solve the equation
//		//      ((otherPointX - thisPointX)/thisVectorX) + (otherVectorX/thisVectorX)*T2
//		//    = ((otherPointY - thisPointY)/thisVectorY) + (otherVectorY/thisVectorY)*T2
//		//   for T2.
//		// This can produce three outputs: all Ts work, no Ts work, one T works.
//
//		// If (Tdontmatter(line1, line2) {
//		//     If A = 0, all Ts work, else, no Ts work.
//		// Else
//	    //     T = -A/(B+1)
//
//		double A = (((other.point().getY() - this.point().getY()) / this.directionVector().getY()) -
//				((other.point().getX() - this.point().getX()) / this.directionVector().getX())) /
//				(other.directionVector().getX() / this.directionVector().getX()); // FIXME HAS ISSUES
//		double B = other.directionVector().getY() / other.directionVector().getX();
//
//		double C = (((other.point().getZ() - this.point().getZ()) / this.directionVector().getZ()) -
//				((other.point().getY() - this.point().getY()) / this.directionVector().getY())) /
//				(other.directionVector().getY() / this.directionVector().getY());
//		double D = other.directionVector().getZ() / other.directionVector().getY();
//
//		if (dEquals(A, 0) && dEquals(B, 1)) {
//			// The lines are parallel (B == 1)
//			System.out.println("LINE 100");
//			// AND all Ts work (A == 0)
//			// The lines intersect UNLESS comparing the Y & Z results in parallel with no intersect.
//			if (!dEquals(C, 0) && dEquals(D, 1)) {
//				System.out.println("LINE 104");
//				return false;
//			} else {
//				System.out.println("LINE 107");
//				return true;
//			}
//		} else if (!dEquals(A, 0) && dEquals(B, 1)) {
//			System.out.println("LINE 111");
//			// The lines are parallel (B == 1)
//			// AND no Ts work (A != 0)
//			// The lines do not intersect.
//			return false;
//		} else {
//			System.out.println("LINE 117");
//			// The lines are not parallel
//			// T is -A/(B-1)
//			double T2 = -A/(B-1);
//			System.out.println("T2 = " + T2);
//
//			// Now, plug into second equation to ensure that T2 works with that.
//			// If it does, the lines intersect.  Else, they don't.
//
//			//    = ((otherPointY - thisPointY)/thisVectorY) + (otherVectorY/thisVectorY)*T2
//			//    = ((otherPointZ - thisPointZ)/thisVectorZ) + (otherVectorZ/thisVectorZ)*T2
//			double YValue = (((other.point().getY() - this.point().getY()) / this.directionVector().getY()) +
//					(other.directionVector().getY() / this.directionVector().getY()*T2));
//			double ZValue = ((other.point().getZ() - this.point().getZ()) / this.directionVector().getZ()) +
//					(other.directionVector().getZ() / this.directionVector().getZ()*T2);
//			return dEquals(YValue, ZValue);
//		}
//	}

//	public Point getIntersect(Line other) {
//		// If lines are equal, return the base point.
//		if (this.equals(other)) {
//			return _p.clone();
//		}
//
//		// If no intersect exists, return null, else return the point.
//
//
//	}

    public Vector direction() {
        return _v.toUnitVector();
    }

    public Point basePoint() {
        return _p;
    }

    public Vector directionVector() {
        return _v;
    }

}
