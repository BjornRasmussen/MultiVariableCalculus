package Vectors;

import java.math.BigDecimal;

public class Angle {
    private static final BigDecimal PI = new BigDecimal("3.14159265358979323");
    BigDecimal _degrees;

    public Angle(BigDecimal degrees) {
        _degrees = degrees;
    }

    public BigDecimal getAngleDegrees() {
        return _degrees;
    }

    public BigDecimal getAngleRadians() {
        return _degrees.multiply(PI).divide(new BigDecimal(180));
    }
}
