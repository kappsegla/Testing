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

    @Test
    public void stringWithOneNumberReturnsThatNumber(){
        assertEquals(1,stringCalculator.add("1"));
    }

    @Test
    public void nullReferenceReturnsZeroWithoutCrashing(){
        assertEquals(0, stringCalculator.add(null));
    }

    @Test
    public void stringWithTwoNumbersWithCommaSeparatorReturnsSumOfNumbers(){
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void stringWithManyNumbersWithCommaSeparatorReturnsSumOfNumbers(){
        assertEquals(15, stringCalculator.add("1,2,3,4,5"));
    }
    @Test
    public void acceptingBothNewLineAndCommaAsSeparators(){
        assertEquals(6,stringCalculator.add("1\n2,3"));
    }



}
