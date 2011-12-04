package foobarqix;

class LineUtils {
    public static String line(int lineNumber, String text) {
        return textAsArrayOfLines(text)[lineNumber - 1];
    }

    public static int numberOfLine(String text) {
        return textAsArrayOfLines(text).length;
    }

    private static String[] textAsArrayOfLines(String text) {
        return text.split(FooBarQix.LINE_SEPARATOR, text.length() + 1);
    }
}
