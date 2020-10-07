import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }


    @Test
        //@DisplayName("Add method, two values as input returns sum of values.")
    void addWithTwoValuesReturnsSumOfValues() {
        //Arrange
        //var calculator = new Calculator();
        var a = 1;
        var b = 1;
        //Act
        var sum = calculator.add(a, b);
        //Assert
        assertEquals(2, sum);
    }

    @Test
    void divideValueAWithValueBReturnsQuotient() {
        var quotient = calculator.divide(10, 2);
        assertEquals(5.0, quotient, "It looks like the division method on Calculator doesn't work as expected.");
    }

    @Test
    void divideValueWithZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
    }


}