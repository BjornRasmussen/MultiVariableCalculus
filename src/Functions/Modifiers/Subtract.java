package Functions.Modifiers;

import Functions.Value;
import Functions.VariableValue;

import java.math.BigDecimal;

/*
 * Stores a-b, where a and b are Values.
 */

public class Subtract implements Modifier {
    Value _a;
    Value _b;

    public Subtract(Value a, Value b) {
        _a = a;
        _b = b;
    }

    @Override
    public BigDecimal getValue(VariableValue[] values) {
        return _a.getValue(values).subtract(_b.getValue(values));
    }

    @Override
    public BigDecimal getValue() {
        return _a.getValue().subtract(_b.getValue());
    }
}
