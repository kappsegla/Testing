package calculator;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if(nullOrEmpty(numbers))
            return 0;
        if(usesCustomDelimiter(numbers))
        {
            char customDelimiter = getCustomDelimiter(numbers);
            return Arrays.stream(numbers.substring(numbers.indexOf('\n')+1)
                    .split(String.valueOf(customDelimiter)))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        return Arrays.stream(numbers.split("[,\n]")).mapToInt(Integer::parseInt).sum();
    }

    private char getCustomDelimiter(String numbers) {
        return numbers.charAt(2);
    }

    private boolean usesCustomDelimiter(String numbers) {
        return numbers.startsWith("//");
    }

    private boolean nullOrEmpty(String numbers) {
        return numbers == null || numbers.isEmpty();
    }
}
