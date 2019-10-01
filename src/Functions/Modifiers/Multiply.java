package Functions.Modifiers;

import Functions.Value;
import Functions.VariableValue;

import java.math.BigDecimal;

public class Multiply implements Modifier {
    Value[] _values;

    public Multiply(Value a, Value b) {
        _values = new Value[2];
        _values[0] = a;
        _values[1] = b;
    }

    public Multiply(Value[] values) {
        _values = values;
    }

    @Override
    public BigDecimal getValue(VariableValue[] values) {
        BigDecimal output = new BigDecimal(1);
        for (Value v : _values) {
            output = output.multiply(v.getValue(values));
        }
        return output;
    }

    @Override
    public BigDecimal getValue() {
        BigDecimal output = new BigDecimal(1);
        for (Value v : _values) {
            output = output.multiply(v.getValue());
        }
        return output;
    }
}
