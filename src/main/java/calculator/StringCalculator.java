package calculator;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if(nullOrEmpty(numbers))
            return 0;
        if( numbers.startsWith("//"))
        {
            var customDelimiter = numbers.charAt(2);
            return Arrays.stream(numbers.substring(numbers.indexOf('\n')+1)
                    .split(String.valueOf(customDelimiter)))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        return Arrays.stream(numbers.split("[,\n]")).mapToInt(Integer::parseInt).sum();
    }

    private boolean nullOrEmpty(String numbers) {
        return numbers == null || numbers.isEmpty();
    }
}
