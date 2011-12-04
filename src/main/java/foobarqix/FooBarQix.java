package foobarqix;

public class FooBarQix {

    static final String LINE_SEPARATOR = System.getProperty("line.separator");

    // rules of foobarqix as arrays
    static final int[] NUMBERS = {3, 5, 7};
    static final String[] REPLACEMENTS = {"Foo", "Bar", "Qix"};

    static final String[] NUMBERS_AS_TEXT;

    static {
        NUMBERS_AS_TEXT = new String[NUMBERS.length];
        for (int i = 0; i < NUMBERS.length; i++) {
            NUMBERS_AS_TEXT[i] = String.valueOf(NUMBERS[i]);
        }
    }

    public static String oneToAHundred() {
        return computeWithLimits(1, 100);
    }

    public static String computeWithLimits(int lowerLimit, int upperLimit) {
        String output = "";
        for (int i = lowerLimit; i <= upperLimit; i++) {
            output += compute(i) + (i == upperLimit ? "" : LINE_SEPARATOR);
        }
        return output;
    }

    private static String compute(int number) {
        String result = computeDivisionRules(number);
        result += computeContentRules(number);

        if (result.isEmpty()) {
            return String.valueOf(number);
        }
        return result;
    }

    private static String computeDivisionRules(int currentNumber) {
        String result = "";
        for (int i = 0; i < NUMBERS.length; i++) {
            if (currentNumber % NUMBERS[i] == 0) {
                result += REPLACEMENTS[i];
            }
        }
        return result;
    }

    private static String computeContentRules(int number) {
        String numberAsText = String.valueOf(number);
        String numberAsTextReplaced = numberAsText;
        for (int i = 0; i < NUMBERS.length; i++) {
            numberAsTextReplaced = numberAsTextReplaced.replaceAll(NUMBERS_AS_TEXT[i], REPLACEMENTS[i]);
        }
        return removeDigitLeft(numberAsTextReplaced);
    }

    private static String removeDigitLeft(String text) {
        return text.replaceAll("[0-9]*", "");
    }

    public static void main(String[] args) {
        System.out.println(FooBarQix.oneToAHundred());
    }
}
