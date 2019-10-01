package Functions;

/*
 * A value, such as 5, Pi, x, 0, f(x), or anything else that can be treated as a value.
 */

import java.math.BigDecimal;

public interface Value {
    BigDecimal getValue(VariableValue[] values);
    BigDecimal getValue(); // For situations where no variables are present.
}
