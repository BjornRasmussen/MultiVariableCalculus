package Functions.Modifiers;

import Functions.Value;
import Functions.Variable;
import Functions.VariableValue;

import java.math.RoundingMode;
import Vectors.Number;
import Vectors.DecimalNumber;

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
    public Number getValue(VariableValue[] values) {
        return _a.getValue(values).divide(_b.getValue(values));
    }

    @Override
    public Number getValue() {
        return _a.getValue().divide(_b.getValue());
    }

    @Override
    public Variable[] getVariables() {
        return extractVariables(new Value[] {_a, _b});
    }
}
