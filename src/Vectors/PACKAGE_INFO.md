# Vectors
This folder contains classes that represent 3D vectors and relevant methods related to vectors.

## 📐 `Angle.java` 

`Immutable`  
Angle provides a simple way to store an angle without having to 
worry about whether that angle is in degrees or radians. 

* Constructors

    * `public Angle(BigDecimal degrees)`  
    Initializes the angle with the given number of degrees.
    
* Methods
    
    * `getAngleDegrees()`  
    Returns the angle in degrees.
    * `getAngleRadians()`  
    Returns the angle in radians.
    
## ↔ `Line.java`

`Immutable`  
Line provides a simple way to store a line.
It stores a start point (`Point.java`) and a direction Vector (`Vector.java`).
The line represented by the object is the line that is parallel to the direction vector and passes through the start point.

* Constructors

    * `public Line(Point basePoint, Vector direction)`  
    Starts the line with the base point and direction entered.
    
* Methods

    * `public boolean equals(Line other)`  
    Returns true if every point on this line is also on the other line.
    
    * `public boolean slopeEquals(Line other)`  
    Returns true if the direction vector of this line is _parallel_ to the direction vector of the other line.
    
    * `public boolean contains(Point p)`  
    Returns true if the point p is on this line.
    
    * `public Vector direction()`  
    Returns a unit vector representing the direction of the line.
    
    * `public Line clone()`  
    Returns a copy of this line, but at a new place in memory.
    
    * `public Point basePoint()`  
    Returns the base point of the line, aka some arbitrary point on the line.
    
    * `public Vector directionVector()`  
    Returns a copy of the direction vector of this line, not necessarily a unit vector.
    
## 🔷 `Plane.java` 

`Immutable`  
Provides a simple way to store a plane in 3D space.
The plane is represented by 
a vector (`Vector.java`) and a point (`Point.java`).
The point represents an arbitrary point on the plane,
and the vector represents the normal vector of the plane,
which is perpendicular to every line contained on the plane.

* Constructors
    
    * `public Plane(Vector normalVector, Point basePoint)`  
    Sets the normal vector and base point accordingly.
    
    * `public Plane(Point basePoint, Vector normalVector)`  
    Same as above - sets the normal vector and base point accordingly.
    
* Methods
    
    * `public Plane clone()`  
    Returns a copy of the plane, but in a new place in memory.
    
    * `public boolean equals(Plane other)`  
    Returns true if every point on this plane is also on the other plane.
    
    * `public boolean contains(Point p)`  
    Returns true if the point p is part of this plane.
    
    * `public boolean contains(Line l)`  
    Returns true if every point on the line is contained in the plane.  
    
    * `public Vector normalVector()`  
    Returns a copy of the normal vector of the plane.
    
    * `public Point basePoint()`  
    Returns a copy of the base point of the plane.
    
## 📌 `Point.java`
    
`Immutable`  
A point represents a point in 3D space using X, Y, and Z coordinates.

* Constructors
    
    * `public Point(double x, double y)`  
    Initializes the point with the x and y coordinates entered, and assumes a z value of `0.0`.

    * `public Point(double x, double y, double z)`  
    Initializes the point with the x, y, and z coordinates entered.
    
* Methods
    
    * `public double getX()`  
    Returns the x coordinate of the point.
    
    * `public double getY()`  
    Returns the y coordinate of the point.
    
    * `public double getZ()`  
    Returns the z coordinate of the point.
    
    * `public boolean equals(Point other)`
    Returns true if the x, y, and z coordinates of the
    two points are practically equal to each other.

## 🔺 `Triangle.java`  

`Immutable`  
This class provides a simple way to store a triangle in 3D space.
This class encapsulates three points (`Point.java`) to store the triangle.


* Constructors
    
    * `public Triangle (Point p1, Point p2, Point p3)`  
    Initializes the Triangle with the three points entered.
    These points must form a valid triangle.
    
    * `public Triangle (Point[] points)`  
    Initializes the Triangle with the first three
    points in the input array.
    These points must form a valid triangle.
    
    * `public Triangle (Vector u, Vector v)`
    Initializes the Triangle with the two vectors entered.
    This is done by placing the first point at `(0,0,0)`,
    placing the second point at `u`, and the third at `v`.  
    Useful when you don't care about where the triangle is located,
    only about the dimensions of the triangle.
    
* Methods
    
    * `public Point[] getPoints()`  
    Returns an array of length 3 that contains the
    three points of the triangle.
    
    * `public double getArea()`  
    Returns the area of the triangle.
    
    * `public String getAreaString()`  
    Returns a String of the format `"0.5 * |" + 2*getArea() + "|"`  
    Useful for easier printing of the process of which the triangle's area
    was found.
    
    * `public String toString()`  
    Returns a String that is a 
    human readable text version of the triangle.
    
    * `public Triangle clone()`  
    Returns a copy of the triangle at a new place in memory.
    
## ↗ `Vector.java`

`Immutable`  
This class provides a way to store a vector.
It encapsulates an `X`, `Y`, and `Z` that represent the change in position of the vector.

* Constructors

    * `public Vector(double x, double y)`  
    Initializes the vector with the `X` and `Y` values entered.
    The `Z` value of the vector is initialized to `0.0`.
    
    * `public Vector(double x, double y, double z)`  
    Initializes the vector with the `X`, `Y`, and `Z` values entered.
    
    * `public Vector (Point p)`  
    Initializes the vector with the `X`, `Y`, and `Z` values of `p`.
    This vector represents the position vector
    that starts at the origin and terminates at `p`.
    
    * `public Vector (Point p1, Point p2)`
    Initializes the vector to the vector
    that starts at `p1` and ends at `p2`.
    For example, an input of  `p1 = (0,0,1)`, `(p2 = 1,-1,2)`
    would initialize the vector to `<1, -1, 1>`.
    
* Methods
    
    `public Vector add(Vector other)`  
    Returns the result of adding this vector to `other`.
    
    `public double dotProduct(Vector other)`  
    Returns the
    [dot product](https://en.wikipedia.org/wiki/Dot_product)
    of this vector and `other`.
    
    `public Vector crossProduct(Vector other)`  
    Returns the
    [cross product](https://en.wikipedia.org/wiki/Cross_product)
    of this vector and `other`.
    
    `public boolean isPerpendicularTo(Vector other)`  
    Returns true if this vector is perpendicular to `other`.
    This is true when the dot product is `0`,
    and indicates that the angle between this vector and `other` is 90 degrees.
    
    `public boolean isParallelTo(Vector other)`  
    Returns true if this vector is parallel to `other`.
    This is true when the cross product of this vector and `other`
    is the zero vector,
    meaning that the angle between this vector and `other` is 0 degrees.
    
    `public Vector clone()`  
    Returns a copy of this vector at a new place in memory.
    
    `public double getX()`  
    Returns the X component of this vector.
    
    `public double getY()`  
    Returns the Y component of this vector.
    
    `public double getZ()`  
    Returns the Z component of this vector.
    
    `public String toString()`  
    Returns a human readable representation of this vector.
    
    `public double magnitude()`  
    Returns the magnitude of this vector.
    
    `public Vector divide(double divisor)`  
    Returns the result of dividing this vector by `divisor`.
    This new vector has the same direction as the original vector,
    but the length has been divided by `divisor`.
    
    `public Vector multiply(double input)`  
    Returns the result of multiplying this vector by `input`.
    This new vector has the same direction as the original vector,
    but the length has been multiplied by `input`.
    
    `public Vector toUnitVector()`  
    Returns the unit vector with the same direction as this vector.
    
    `public boolean equals(Vector other)`  
    Returns `true` if this vector is practically equal to `other`, 
    that is, the `X`, `Y`, and `Z` values of this and `other` are
    practically the same.
    
    `public Angle angleTo(Vector other)`
    Returns the angle between this vector and `other`.
    
 
    
