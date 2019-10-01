package Functions;

import java.math.BigDecimal;

/*
 * Takes in a single variable and spits out a single value when evaluated.
 */

public class Function implements Value {

    private Value _value; // This is the content of the function.

    public Function(Value value) {
        _value = value;
    }

    @Override
    public BigDecimal getValue(VariableValue[] values) {
        return _value.getValue(values);
    }
    public BigDecimal getValue() {
        return _value.getValue();
    }

    public BigDecimal getValue(VariableValue value) {
        VariableValue[] values = new VariableValue[1];
        values[0] = value;
        return _value.getValue(values);
    }
}
