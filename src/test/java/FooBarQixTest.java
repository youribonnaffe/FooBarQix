import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FooBarQixTest {
    @Test
    public void testPreConditionsOnNumbers() {
        int[] sortedNumbers = Arrays.copyOf(FooBarQix.NUMBERS, FooBarQix.NUMBERS.length);
        Arrays.sort(sortedNumbers);
        Assert.assertArrayEquals(FooBarQix.NUMBERS, sortedNumbers);
        assertArrayEquals(FooBarQix.NUMBERS_AS_TEXT, sortedNumbers);

        assertEquals(FooBarQix.NUMBERS.length, FooBarQix.NUMBERS_AS_TEXT.length);
        assertEquals(FooBarQix.NUMBERS.length, FooBarQix.REPLACEMENTS.length);
    }

    private void assertArrayEquals(String[] texts, int[] ints) {
        String[] intsAsText = new String[ints.length];
        for (int i = 0; i < ints.length; i++) {
            intsAsText[i] = String.valueOf(ints[i]);
        }
        Assert.assertArrayEquals(texts, intsAsText);
    }

    @Test
    public void testRulesAreRespected() throws Exception {
        String output = FooBarQix.oneToAHundred();
        for (int lineNumber = 1; lineNumber <= 100; lineNumber++) {
            assertDivisionRuleIsRespected(lineNumber, LineUtils.line(lineNumber, output));
            assertContentRuleIsRespected(lineNumber, LineUtils.line(lineNumber, output));
        }
    }

    private void assertDivisionRuleIsRespected(int lineNumber, String line) {
        for (int i = 0; i < FooBarQix.NUMBERS.length; i++) {
            if (lineNumber % FooBarQix.NUMBERS[i] == 0) {
                assertLineContent(lineNumber, line, FooBarQix.REPLACEMENTS[i]);
            }
        }
    }

    private void assertContentRuleIsRespected(int lineNumber, String line) {
        String lineNumberAsText = String.valueOf(lineNumber);
        for (int i = 0; i < FooBarQix.NUMBERS.length; i++) {
            if (lineNumberAsText.contains(FooBarQix.NUMBERS_AS_TEXT[i])) {
                assertLineContent(lineNumber, line, FooBarQix.REPLACEMENTS[i]);
            }
        }
    }

    private void assertLineContent(int lineNumber, String line, String content) {
        assertTrue("line " + lineNumber + " should contain " + content, line.contains(content));
    }
}
