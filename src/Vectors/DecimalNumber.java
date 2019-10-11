package Vectors;
/*
 * Wrapper class for BigDecimals.
 * Provides a bunch of useful methods.
 */

import Vectors.arXiv.BigDecimalMath;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class DecimalNumber implements Number {
    public static final Number ZERO = new DecimalNumber("0");
    public static final Number ONE = new DecimalNumber("1");
    public static final Number TWO = new DecimalNumber("2");
    public static final Number TEN = new DecimalNumber("10");
    public static final Number HALF = new DecimalNumber("0.5");
    public static final Number PI = new DecimalNumber("3.14159265358979323846264338327950288419716939937510582097494" +
            "4592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450" +
            "2841027019385211055596446229489549303819644288109756659334461284756482337867831652712019091456485669" +
            "2346034861045432664821339360726024914127372458700660631558817488152092096282925409171536436789259036" +
            "0011330530548820466521384146951941511609433057270365759591953092186117381932611793105118548074462379" +
            "9627495673518857527248912279381830119491298336733624406566430860213949463952247371907021798609437027" +
            "7053921717629317675238467481846766940513200056812714526356082778577134275778960917363717872146844090" +
            "1224953430146549585371050792279689258923542019956112129021960864034418159813629774771309960518707211" +
            "3499999983729780499510597317328160963185950244594553469083026425223082533446850352619311881710100031" +
            "3783875288658753320838142061717766914730359825349042875546873115956286388235378759375195778185778053" +
            "21712268066130019278766111959092164201989");

    private BigDecimal _value;

    // Constructors

    public DecimalNumber (BigDecimal value) {
        _value = value;
    }

    public DecimalNumber(String value) {
        _value = new BigDecimal(value);
    }

    public DecimalNumber (int value) {
        _value = new BigDecimal(value);
    }

    public DecimalNumber (double value) {
        _value = new BigDecimal(value);
    }

    public DecimalNumber (long value) {
        _value = new BigDecimal(value);
    }

    // Methods

    @Override
    public BigDecimal value() {
        return _value;
    }

    @Override
    public double doubleValue() {
        return _value.doubleValue();
    }

    @Override
    public int intValue() {
        return _value.intValue();
    }

    @Override
    public long longValue() {
        return _value.longValue();
    }

    @Override
    public Number add(Number other) {
        return new DecimalNumber(_value.add(other.value()));
    }

    @Override
    public Number subtract(Number other) {
        return new DecimalNumber(_value.subtract(other.value()));
    }

    @Override
    public Number multiply(Number other) {
        return new DecimalNumber(_value.multiply(other.value()));
    }

    @Override
    public Number divide(Number other) {
        return new DecimalNumber(_value.divide(other.value(), RoundingMode.DOWN));
    }

    @Override
    public Number mod(Number modulus) {
        if (modulus.equals(ZERO)) {
            throw new IllegalArgumentException("Mod 0 is undefined.");
        } else if (this.equals(ZERO)) {
            return this;
        }

        BigDecimal myNumber = this.value();
        BigDecimal mod = modulus.abs().value();

        // Initial simplification: should make values that have 1000 digits very easy to operate on.
        BigDecimal timesBiggerThanMod = myNumber.divide(mod, RoundingMode.HALF_UP);
        BigInteger timesBiggerThanModInt = new BigInteger((timesBiggerThanMod.toBigInteger().toString()
                + ".foo").split("\\.")[0]).subtract(new BigInteger("10"));
        myNumber = myNumber.subtract(mod.multiply(new BigDecimal(timesBiggerThanModInt)));


        // Now, find mod.
        while(myNumber.compareTo(mod) > 0) {
            myNumber = myNumber.subtract(mod);
        }

        if (modulus.isNegative()) {
            myNumber = myNumber.subtract(mod);
        }

        return new DecimalNumber(myNumber);
    }

    @Override
    public Number power(Number other) {
        // Returns this^other
        return new DecimalNumber(BigDecimalMath.pow(this.value(), other.value()));
    }

    @Override
    public Number logBase(Number other) {
        // Returns log (base other) of this.
        return new DecimalNumber(BigDecimalMath.log(this.value()).divide(BigDecimalMath.log(other.value()), 1000, RoundingMode.HALF_UP));
    }

    @Override
    public Number ln(Number other) {
        return new DecimalNumber(BigDecimalMath.log(this.value()));
    }

    @Override
    public Number log10(Number other) {
        return logBase(new DecimalNumber("10"));
    }

    @Override
    public Number sin() {
        return new DecimalNumber(BigDecimalMath.sin(this.value()));
    }

    @Override
    public Number cos() {
        return new DecimalNumber(BigDecimalMath.cos(this.value()));
    }

    @Override
    public Number tan() {
        return new DecimalNumber(BigDecimalMath.tan(this.value()));
    }

    @Override
    public Number csc() {
        return new DecimalNumber(BigDecimal.ONE.divide(BigDecimalMath.sin(this.value()), 1000, RoundingMode.HALF_UP));
    }

    @Override
    public Number sec() {
        return new DecimalNumber(BigDecimal.ONE.divide(BigDecimalMath.cos(this.value()), 1000, RoundingMode.HALF_UP));
    }

    @Override
    public Number cot() {
        return new DecimalNumber(BigDecimal.ONE.divide(BigDecimalMath.tan(this.value()), 1000, RoundingMode.HALF_UP));
    }

    @Override
    public Angle arcsin() {
        throw new UnsupportedOperationException("Not yet supported.");
        // TODO: Expand this later to use a taylor series approximation to get within 1000 sig figs of the correct value.
    }

    @Override
    public Angle arccos() {
        throw new UnsupportedOperationException("Not yet supported.");
        // TODO: Expand this later to use a taylor series approximation to get within 1000 sig figs of the correct value.
    }

    @Override
    public Angle arctan() {
        throw new UnsupportedOperationException("Not yet supported.");
        // TODO: Expand this later to use a taylor series approximation to get within 1000 sig figs of the correct value.
    }

    @Override
    public Angle arccsc() {
        throw new UnsupportedOperationException("Not yet supported.");
        // TODO: Expand this later to use a taylor series approximation to get within 1000 sig figs of the correct value.
    }

    @Override
    public Angle arcsec() {
        throw new UnsupportedOperationException("Not yet supported.");
        // TODO: Expand this later to use a taylor series approximation to get within 1000 sig figs of the correct value.
    }

    @Override
    public Angle arccot() {
        throw new UnsupportedOperationException("Not yet supported.");
        // TODO: Expand this later to use a taylor series approximation to get within 1000 sig figs of the correct value.
    }

    @Override
    public String toString() {
        return _value.toString();
    }
}
