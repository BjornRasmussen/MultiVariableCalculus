package Vectors;

import java.math.BigDecimal;

public class Angle {
    private Number _degrees;

    public Angle(Number degrees) {
        _degrees = degrees;
    }

    public Number getAngleDegrees() {
        return _degrees;
    }

    public Number getAngleRadians() {
        return _degrees.multiply(DecimalNumber.PI).divide(new DecimalNumber(180));
    }

}
