import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    //@DisplayName("Add method, two values as input returns sum of values.")
    void addWithTwoValuesReturnsSumOfValues() {
        var sum = Calculator.add(1,1);
        assertEquals(2,sum);
    }

    @Test
    void divideValueAWithValueBReturnsQuotient() {
        var quotient = Calculator.divide(10,2);
        assertEquals(5.0, quotient,"It looks like the division method on Calculator doesn't work as expected.");
    }





}