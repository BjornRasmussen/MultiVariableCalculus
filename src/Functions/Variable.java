package Functions;

import Vectors.Number;
import Vectors.DecimalNumber;
import java.math.BigDecimal;

public class Variable implements Value {
    private String _name;

    public Variable(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    @Override
    public Number getValue(VariableValue[] values) {
        for (VariableValue v : values) {
            if (v.getName().equals(_name)) {
                return v.getVarValue();
            }
        }
        throw new RuntimeException("NO VALUE FOUND FOR \"" + _name + "\" IN INPUT VariableValue[]");
    }

    @Override
    public Number getValue() {
        throw new UnsupportedOperationException("Cannot call getValue() on a Variable (" + _name + ") without entering a VariableValue[].");
    }

    @Override
    public Variable[] getVariables() {
        return new Variable[] {this};
    }

    public boolean equals(Variable other) {
        // Just checks names.
        return getName().equals(other.getName());
    }

}
