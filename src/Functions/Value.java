package Functions;

/*
 * A value, such as 5, Pi, x, 0, f(x), or anything else that can be treated as a value.
 */

import java.util.ArrayList;
import java.util.List;

import Vectors.Number;

public interface Value {
    Number getValue(VariableValue[] values);
    Number getValue(); // For situations where no variables are present.
    Variable[] getVariables();

    default Variable[] conflateVariables(Variable[][] input) {
        List<Variable> output = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                // If this variable has not been seen before, add it to output.
                boolean alreadyAdded = false;
                for (int k = 0; k < output.size(); k++) {
                    if (output.get(k).getName().equals(input[i][j].getName())) {
                        alreadyAdded = true;
                        break;
                    }
                }
                if (!alreadyAdded) {
                    output.add(input[i][j]);
                }
            }
        }
        return (Variable[]) output.toArray();
    }

    default Variable[] extractVariables(Value[] values) {
        Variable[][] vars = new Variable[values.length][];
        for (int i = 0; i < values.length; i++) {
            vars[i] = values[i].getVariables();
        }
        return conflateVariables(vars);
    }
}
