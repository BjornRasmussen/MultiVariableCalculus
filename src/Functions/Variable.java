package Functions;

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
    public BigDecimal getValue(VariableValue[] values) {
        for (VariableValue v : values) {
            if (v.getName().equals(_name)) {
                return v.getVarValue().getValue(null);
            }
        }
        throw new RuntimeException("NO VALUE FOUND FOR \"" + _name + "\" IN INPUT VariableValue[]");
    }

    @Override
    public BigDecimal getValue() {
        throw new RuntimeException("NO VALUE ENTERED THROUGH getValue() FOR " + _name);
    }
}
