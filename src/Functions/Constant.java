package Functions;

import Vectors.Number;
import Vectors.DecimalNumber;
/*
 * Stores a Number (constant), or basic value, such as 5, 19.5, -12, 0, or 1023919284812.
 */

public class Constant implements Value {
    Number _value;

    public Constant(int value) {
        _value = new DecimalNumber(value);
    }

    public Constant(String value) {
        _value = new DecimalNumber(value);
    }

    public Constant(Number value) {
        _value = value;
    }

    @Override
    public Number getValue(VariableValue[] values /* this is ignored, but needed for compatibility. */) {
        return _value;
    }

    @Override
    public Number getValue() {
        return _value;
    }

    @Override
    public Variable[] getVariables() {
        return new Variable[0];
    }
}
