package Functions.Modifiers;
import Functions.*;
import Vectors.DecimalNumber;
import Vectors.Number;

/*
 * Wrapper class for a Function.
 * Doesn't do anything until evaluated, at which point it will evaluate the derivative,
 * aka slope of the inner function at that point.
 */
public class Derivative implements Value {
    private static final Number SMALL_AMOUNT = new DecimalNumber("0.0000000001");

    private Function _function;
    private Variable _ofVariable;

    public Derivative(Function function, Variable ofVariable) {
        _function = function;
        _ofVariable = ofVariable;
    }

    @Override
    public Number getValue(VariableValue[] values) {
        // This is where the difficult stuff lies.
        // We need to take the limit of the function approaching the input location (from input variables)
        System.out.println("Array entered: contains " + values.length + " variable" + (values.length==1 ? "." : "s."));
        System.out.println("First variable is " + values[0]);
        System.out.println("Now, evaluating f at x produces " + _function.getValue(values));
        // Step one: find that variable X (or whatever) in values and increase/decrease it by a bit.  Then, plug in.
        VariableValue[] varSlightlyBigger = new VariableValue[values.length];
        VariableValue[] varSlightlySmaller = new VariableValue[values.length];
        for (int i = 0;  i < varSlightlyBigger.length; i++) {
            varSlightlyBigger[i] = values[i];
            varSlightlySmaller[i] = values[i];
        }
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(_ofVariable)) {
                // This runs if values[i] is the variable that should change a little bit.
                varSlightlyBigger[i] = new VariableValue(values[i].getName(),
                        varSlightlyBigger[i].getVarValue().add(SMALL_AMOUNT));
                varSlightlySmaller[i] = new VariableValue(values[i].getName(),
                        varSlightlyBigger[i].getVarValue().subtract(SMALL_AMOUNT));

            }
        }
        // Derivative from right:
        // dy/dx = [f(x+0.00000001) - f(x)]/0.00000001
        Number derFromRight = _function.getValue(varSlightlyBigger).subtract(_function.getValue(values)).divide(SMALL_AMOUNT);
        Number derFromLeft = _function.getValue(varSlightlySmaller).subtract(_function.getValue(values)).divide(SMALL_AMOUNT
                .multiply(new DecimalNumber(-1)));
        // TODO add checks that ensure the derivative actually exists.
        return derFromLeft;//.add(derFromRight).divide(new DecimalNumber(2));
    }

    @Override
    public Number getValue() {
        throw new UnsupportedOperationException("Cannot take the derivative of a function without variables - by the way, it's just 0.");
    }

    @Override
    public Variable[] getVariables() {
        return _function.getVariables();
    }
}
