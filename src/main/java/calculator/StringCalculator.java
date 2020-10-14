package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String numbers) {
        if (nullOrEmpty(numbers))
            return 0;

        var delimiter = "[,\n]";

        if (usesCustomDelimiter(numbers)) {
            delimiter = getCustomDelimiter(numbers);
            return getSum(numbers.substring(numbers.indexOf('\n') + 1), delimiter);
        }
        return getSum(numbers, delimiter);
    }

    private int getSum(String numbers, String delimiter) {
        checkForNegatives(numbers, delimiter);
        return Arrays.stream(numbers
                .split(String.valueOf(delimiter)))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private void checkForNegatives(String numbers, String delimiter) {
        List<Integer> negatives =
                Arrays.stream(numbers
                        .split(String.valueOf(delimiter)))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .filter(n -> n < 0)
                        .collect(Collectors.toList());

        if (negatives.size() > 0) {
            var message = "negatives not allowed";
            for (var s : negatives) {
                message += "," + s;
            }
            throw new IllegalArgumentException(message);
        }
    }

    private String getCustomDelimiter(String numbers) {
        return String.valueOf(numbers.charAt(2));
    }

    private boolean usesCustomDelimiter(String numbers) {
        return numbers.startsWith("//");
    }

    private boolean nullOrEmpty(String numbers) {
        return numbers == null || numbers.isEmpty();
    }
}
