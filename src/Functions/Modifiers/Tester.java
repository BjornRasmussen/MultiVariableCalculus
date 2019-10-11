package Functions.Modifiers;

import Functions.Constant;
import Functions.Function;
import Functions.Variable;
import Functions.VariableValue;
import Vectors.DecimalNumber;

public class Tester {
    public static void main(String[] args) {
        Variable x = new Variable("x");
        Function f = new Function(new Add(new Constant(5), new Multiply(x, new Constant(14))));
        Derivative dfdx = new Derivative(f, x);
        VariableValue[] xValue = new VariableValue[1];
        xValue[0] = new VariableValue("x", new DecimalNumber(11));
        System.out.println(dfdx.getValue(xValue));
    }
}
