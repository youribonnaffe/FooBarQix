import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FooBarQixTest {

    @Test
    public void testDivisionRule() throws Exception {
        String output = FooBarQix.oneToAHundred();
        for (int lineNumber = FooBarQix.OUTPUT_LOWER_LIMIT; lineNumber <= FooBarQix.OUTPUT_UPPER_LIMIT; lineNumber++) {
            assertDivisionRuleIsRespected(lineNumber, LineUtils.line(lineNumber, output));
            assertContentRuleIsRespected(lineNumber, LineUtils.line(lineNumber, output));
        }
    }

    private void assertDivisionRuleIsRespected(int lineNumber, String line) {
        if (lineNumber % FooBarQix.THREE == 0) {
            assertLineContent(lineNumber, line, FooBarQix.FOO);
        }
        if (lineNumber % FooBarQix.FIVE == 0) {
            assertLineContent(lineNumber, line, FooBarQix.BAR);
        }
        if (lineNumber % FooBarQix.SEVEN == 0) {
            assertLineContent(lineNumber, line, FooBarQix.QIX);
        }
    }

    private void assertContentRuleIsRespected(int lineNumber, String line) {
        String lineNumberAsText = String.valueOf(lineNumber);
        if (lineNumberAsText.contains(FooBarQix.THREE_AS_TEXT)) {
            assertLineContent(lineNumber, line, FooBarQix.FOO);
        }
        if (lineNumberAsText.contains(FooBarQix.FIVE_AS_TEXT)) {
            assertLineContent(lineNumber, line, FooBarQix.BAR);
        }
        if (lineNumberAsText.contains(FooBarQix.SEVEN_AS_TEXT)) {
            assertLineContent(lineNumber, line, FooBarQix.QIX);
        }
    }

    private void assertLineContent(int lineNumber, String line, String content) {
        assertTrue("line " + lineNumber + " should contain " + content, line.contains(content));
    }
}
