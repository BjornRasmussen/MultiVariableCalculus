package Functions;

import Vectors.Number;

/*
 * A simple function: contains a value, and can be evaluated.
 */

public class Function implements Value {

    private Value _value; // This is the content of the function.

    public Function(Value value) {
        _value = value;
    }

    @Override
    public Number getValue(VariableValue[] values) {
        return _value.getValue(values);
    }
    public Number getValue() {
        return _value.getValue();
    }

    @Override
    public Variable[] getVariables() {
        return _value.getVariables();
    }

    public Number getValue(VariableValue value) {
        VariableValue[] values = new VariableValue[1];
        values[0] = value;
        return getValue(values);
    }
}
