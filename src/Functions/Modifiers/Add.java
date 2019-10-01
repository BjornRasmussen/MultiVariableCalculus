package Functions.Modifiers;

import Functions.Value;
import Functions.VariableValue;

import java.math.BigDecimal;
/*
 * Stores two Values, and returns the values of the two added together when getValue is called.
 */
public class Add implements Modifier {
    Value[] _values;

    public Add(Value a, Value b) {
        _values = new Value[2];
        _values[0] = a;
        _values[1] = b;
    }

    public Add(Value a, Value b, Value c) {
        _values = new Value[3];
        _values[0] = a;
        _values[1] = b;
        _values[2] = c;
    }

    public Add(Value a, Value b, Value c, Value d) {
        _values = new Value[4];
        _values[0] = a;
        _values[1] = b;
        _values[2] = c;
        _values[3] = d;
    }

    public Add(Value[] values) {
        _values = values;
    }

    @Override
    public BigDecimal getValue(VariableValue[] values) {
        BigDecimal output = new BigDecimal(0);
        for (Value v : _values) {
            output = output.add(v.getValue(values));
        }
        return output;
    }

    @Override
    public BigDecimal getValue() {
        BigDecimal output = new BigDecimal(0);
        for (Value v : _values) {
            output = output.add(v.getValue());
        }
        return output;
    }
}
