package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void callToAddWithEmptyStringReturnsZero()
    {
        assertEquals(0, stringCalculator.add(""));
    }
}
