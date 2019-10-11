package Functions.Modifiers;

import Functions.Value;
import Functions.Variable;
import Functions.VariableValue;

import Vectors.Number;
import Vectors.DecimalNumber;

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
    public Number getValue(VariableValue[] values) {
        Number output = DecimalNumber.ONE;
        for (Value v : _values) {
            output = output.multiply(v.getValue(values));
        }
        return output;
    }

    @Override
    public Number getValue() {
        Number output = DecimalNumber.ONE;
        for (Value v : _values) {
            output = output.multiply(v.getValue());
        }
        return output;
    }

    @Override
    public Variable[] getVariables() {
        return extractVariables(_values);
    }
}
