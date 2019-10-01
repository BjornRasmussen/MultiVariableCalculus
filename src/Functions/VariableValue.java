package Functions;

public class VariableValue {
    String _varName;
    private Value _value;

    public VariableValue(String name, Value value) {
        _varName = name;
        _value = value;
    }

    public String getName() {
        return _varName;
    }

    public Value getVarValue() {
        return _value;
    }
}
