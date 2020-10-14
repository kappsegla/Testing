package calculator;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if(nullOrEmpty(numbers))
            return 0;
        return Arrays.stream(numbers.split("[,\n]")).mapToInt(Integer::parseInt).sum();
    }

    private boolean nullOrEmpty(String numbers) {
        return numbers == null || numbers.isEmpty();
    }
}
