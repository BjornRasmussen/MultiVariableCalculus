package Functions.Modifiers;

import Functions.Value;
import Functions.VariableValue;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * Stores a/b, where a and b are Values.
 */
public class Divide implements Modifier {
    Value _a;
    Value _b;

    public Divide(Value a, Value b) {
        _a = a;
        _b = b;
    }

    @Override
    public BigDecimal getValue(VariableValue[] values) {
        return _a.getValue(values).divide(_b.getValue(values), 100, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getValue() {
        return _a.getValue().divide(_b.getValue(), 100, RoundingMode.HALF_UP);
    }

}
