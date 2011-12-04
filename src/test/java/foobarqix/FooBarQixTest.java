package foobarqix;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static foobarqix.FooBarQix.*;
import static foobarqix.LineUtils.line;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FooBarQixTest {
    @Test
    public void testPreConditionsOnNumbers() {
        int[] sortedNumbers = Arrays.copyOf(NUMBERS, NUMBERS.length);
        Arrays.sort(sortedNumbers);
        Assert.assertArrayEquals(NUMBERS, sortedNumbers);
        assertArrayEquals(NUMBERS_AS_TEXT, sortedNumbers);

        assertEquals(NUMBERS.length, NUMBERS_AS_TEXT.length);
        assertEquals(NUMBERS.length, REPLACEMENTS.length);
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
        String output = oneToAHundred();
        for (int lineNumber = 1; lineNumber <= 100; lineNumber++) {
            assertDivisionRuleIsRespected(lineNumber, line(lineNumber, output));
            assertContentRuleIsRespected(lineNumber, line(lineNumber, output));
        }
    }

    private void assertDivisionRuleIsRespected(int lineNumber, String line) {
        for (int i = 0; i < NUMBERS.length; i++) {
            if (lineNumber % NUMBERS[i] == 0) {
                assertLineContent(lineNumber, line, REPLACEMENTS[i]);
            }
        }
    }

    private void assertContentRuleIsRespected(int lineNumber, String line) {
        String lineNumberAsText = String.valueOf(lineNumber);
        for (int i = 0; i < NUMBERS.length; i++) {
            if (lineNumberAsText.contains(NUMBERS_AS_TEXT[i])) {
                assertLineContent(lineNumber, line, REPLACEMENTS[i]);
            }
        }
    }

    private void assertLineContent(int lineNumber, String line, String content) {
        assertTrue("line " + lineNumber + " should contain " + content, line.contains(content));
    }
}
