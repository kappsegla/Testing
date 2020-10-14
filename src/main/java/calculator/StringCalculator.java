package calculator;

public class StringCalculator {
    public int add(String numbers) {
        if(nullOrEmpty(numbers))
            return 0;
        return Integer.parseInt(numbers);
    }

    private boolean nullOrEmpty(String numbers) {
        return numbers == null || numbers.isEmpty();
    }
}
