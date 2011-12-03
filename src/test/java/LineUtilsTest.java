import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineUtilsTest {

    @Test
    public void testOneLine() throws Exception {
        String oneLine = "one line";
        assertEquals(oneLine, LineUtils.line(1, oneLine));
        assertEquals(1, LineUtils.numberOfLine(oneLine));
    }

    @Test
    public void testEmptyLine() throws Exception {
        String emptyLine = "";
        assertEquals(emptyLine, LineUtils.line(1, emptyLine));
        assertEquals(1, LineUtils.numberOfLine(emptyLine));
    }

    @Test
    public void testEmptyLines() throws Exception {
        String emptyLines = FooBarQix.LINE_SEPARATOR;
        assertEquals("", LineUtils.line(1, emptyLines));
        assertEquals("", LineUtils.line(2, emptyLines));
        assertEquals(2, LineUtils.numberOfLine(emptyLines));
    }

    @Test
    public void testTwoLines() throws Exception {
        String twoLines = "first line" + FooBarQix.LINE_SEPARATOR + "second line";
        assertEquals("first line", LineUtils.line(1, twoLines));
        assertEquals("second line", LineUtils.line(2, twoLines));
        assertEquals(2, LineUtils.numberOfLine(twoLines));
    }

    @Test
    public void testTwoLinesSecondOneIsEmpty() throws Exception {
        String twoLines = "first line" + FooBarQix.LINE_SEPARATOR;
        assertEquals("first line", LineUtils.line(1, twoLines));
        assertEquals("", LineUtils.line(2, twoLines));
        assertEquals(2, LineUtils.numberOfLine(twoLines));
    }
}
