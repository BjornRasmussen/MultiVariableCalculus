package Functions;

import java.math.BigDecimal;

/*
 * Stores an integer constant, or basic value, such as 5, 19, -12, 0, or 1023919284812.
 */

public class Constant implements Value {
    BigDecimal _value;

    public Constant(int value) {
        _value = new BigDecimal(value);
    }

    public Constant(BigDecimal value) {
        _value = new BigDecimal(value.toBigInteger()); // Rounds down to integer.

        if (value.compareTo(value) != 0) {
            // input is not an integer.
            throw new RuntimeException("A Constant was created with a non integer value.");
        }
    }

    public BigDecimal getValue(VariableValue[] values /* this is ignored, but needed for compatibility. */) {
        return _value;
    }

    public BigDecimal getValue() {
        return _value;
    }
}
