package Vectors;

import java.math.BigDecimal;

public interface Number {

    // Getters:
    BigDecimal value();
    double doubleValue();
    int intValue();
    long longValue();

    // Logic operations
    default boolean isGreaterThan(Number other) {
        return value().compareTo(other.value()) > 0;
    }

    default boolean isGreaterOrEqualTo(Number other) {
        return value().compareTo(other.value()) >= 0;
    }

    default boolean isLessThan(Number other) {
        return !isGreaterOrEqualTo(other);
    }

    default boolean isLessThanOrEqualTo(Number other) {
        return !isGreaterThan(other);
    }

    default boolean equals(Number other) {
        return value().equals(other.value());
    }

    default boolean approximateEquals(Number other) {
        return subtract(other).abs().isLessThan(new DecimalNumber(0.0000001));
    }

    default boolean isNegative() {
        return isLessThan(DecimalNumber.ZERO);
    }

    default boolean isPositive() {
        return isGreaterThan(DecimalNumber.ZERO);
    }

    default boolean isZero() {
        return this.equals(DecimalNumber.ZERO);
    }

    // Basic immutable math operations.
    Number add(Number other);
    Number subtract(Number other);
    Number multiply(Number other);
    Number divide(Number other);

    //// ADVANCED ALGEBRA ////

    // Mod: returns this%other
    Number mod(Number other);

    // Power: returns this to the power of other.
    Number power(Number other);

    // Log: returns log base (other) of this.
    Number logBase(Number other);

    // Ln: returns the natural log of this.
    Number ln(Number other);

    // Log: returns log base 10 of this number.
    Number log10(Number other);

    // Abs: returns the size of this number
    default Number abs() {
        if (value().equals(BigDecimal.ZERO)) {
            return new DecimalNumber(0);
        }
        return value().compareTo(BigDecimal.ZERO) > 0 ? this : this.multiply(new DecimalNumber(-1));
    }

    //// ADVANCED TRIG ////

    // Trig: returns the sine, cos, etc of this function (assuming that it's in DEGREES!!, not radians).
    Number sin();
    Number cos();
    Number tan();
    Number csc();
    Number sec();
    Number cot();

    // Inverse trig
    Angle arcsin();
    Angle arccos();
    Angle arctan();
    Angle arccsc();
    Angle arcsec();
    Angle arccot();


}
