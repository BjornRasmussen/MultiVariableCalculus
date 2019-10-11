package Functions;

import Vectors.Number;

public class VariableValue {
    String _varName;
    private Number _value;

    public VariableValue(String name, Number value) {
        _varName = name;
        _value = value;
    }

    public String getName() {
        return _varName;
    }

    public Number getVarValue() {
        return _value;
    }

    public String toString() {
        return _varName + ", which equals " + _value;
    }
}
