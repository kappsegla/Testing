package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void callToAddWithEmptyStringReturnsZero() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void stringWithOneNumberReturnsThatNumber() {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void nullReferenceReturnsZeroWithoutCrashing() {
        assertEquals(0, stringCalculator.add(null));
    }

    @Test
    public void stringWithTwoNumbersWithCommaDelimiterReturnsSumOfNumbers() {
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void stringWithManyNumbersWithCommaDelimiterReturnsSumOfNumbers() {
        assertEquals(15, stringCalculator.add("1,2,3,4,5"));
    }

    @Test
    public void acceptingBothNewLineAndCommaAsDelimiter() {
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void customDelimiter() {
        assertEquals(6, stringCalculator.add("//;\n1;2;3"));
    }

    @Test
    public void negativeValuesThrowsException(){
        Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class,
                () -> stringCalculator.add("-1,2,-3,4,5") );
        assertEquals("negatives not allowed,-1,-3", exceptionThatWasThrown.getMessage());
    }

    @Test
    public void numbersBiggerThan1000ShouldBeIgnored(){
        assertEquals(2, stringCalculator.add("2,1001"));
    }


}
