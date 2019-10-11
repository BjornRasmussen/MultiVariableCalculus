package Functions.Modifiers;

import Functions.Value;
import Functions.Variable;
import Functions.VariableValue;
import Vectors.Number;

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
    public Number getValue(VariableValue[] values) {
        return _a.getValue(values).subtract(_b.getValue(values));
    }

    @Override
    public Number getValue() {
        return _a.getValue().subtract(_b.getValue());
    }

    @Override
    public Variable[] getVariables() {
        return extractVariables(new Value[] { _a, _b});
    }
}
