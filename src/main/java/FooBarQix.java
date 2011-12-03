public class FooBarQix {

    static final String LINE_SEPARATOR = System.getProperty("line.separator");

    static final int THREE = 3;
    static final String THREE_AS_TEXT = String.valueOf(THREE);
    static final String FOO = "Foo";

    static final int FIVE = 5;
    static final String FIVE_AS_TEXT = String.valueOf(FIVE);
    static final String BAR = "Bar";

    static final int SEVEN = 7;
    static final String SEVEN_AS_TEXT = String.valueOf(SEVEN);
    static final String QIX = "Qix";

    static final int OUTPUT_LOWER_LIMIT = 1;
    static final int OUTPUT_UPPER_LIMIT = 100;

    public static String oneToAHundred() {
        String output = "";
        for (int i = OUTPUT_LOWER_LIMIT; i <= OUTPUT_UPPER_LIMIT; i++) {
            output += compute(i) + (i == OUTPUT_UPPER_LIMIT ? "" : LINE_SEPARATOR);
        }
        return output;
    }

    private static String compute(int number) {
        String result = "";
        result += computeDivisionRules(number);
        result += computeContentRules(number);

        if (result.isEmpty()) {
            result = String.valueOf(number);
        }
        return result;
    }

    private static String computeDivisionRules(int number) {
        String result = "";
        if (number % THREE == 0) {
            result += FOO;
        }
        if (number % FIVE == 0) {
            result += BAR;
        }
        if (number % SEVEN == 0) {
            result += QIX;
        }
        return result;
    }

    private static String computeContentRules(int number) {
        String numberAsText = String.valueOf(number);
        String numberAsTextReplaced = numberAsText.replaceAll(THREE_AS_TEXT, FOO);
        numberAsTextReplaced = numberAsTextReplaced.replaceAll(FIVE_AS_TEXT, BAR);
        numberAsTextReplaced = numberAsTextReplaced.replaceAll(SEVEN_AS_TEXT, QIX);
        numberAsTextReplaced = removeDigitLeft(numberAsTextReplaced);
        return numberAsTextReplaced;
    }

    private static String removeDigitLeft(String numberAsTextReplaced) {
        return numberAsTextReplaced.replaceAll("[0-9]*", "");
    }

    public static void main(String[] args) {
        System.out.println(FooBarQix.oneToAHundred());
    }
}
