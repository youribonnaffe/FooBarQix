package foobarqix;

import org.junit.Assert;
import org.junit.Test;

import static foobarqix.LineUtils.*;
import static org.junit.Assert.*;

public class LineUtilsTest {

    @Test
    public void testOneLine() throws Exception {
        String oneLine = "one line";
        assertEquals(oneLine, line(1, oneLine));
        assertEquals(1, numberOfLine(oneLine));
    }

    @Test
    public void testEmptyLine() throws Exception {
        String emptyLine = "";
        assertEquals(emptyLine, line(1, emptyLine));
        assertEquals(1, numberOfLine(emptyLine));
    }

    @Test
    public void testEmptyLines() throws Exception {
        String emptyLines = FooBarQix.LINE_SEPARATOR;
        assertEquals("", line(1, emptyLines));
        assertEquals("", line(2, emptyLines));
        assertEquals(2, numberOfLine(emptyLines));
    }

    @Test
    public void testTwoLines() throws Exception {
        String twoLines = "first line" + FooBarQix.LINE_SEPARATOR + "second line";
        assertEquals("first line", line(1, twoLines));
        assertEquals("second line", line(2, twoLines));
        assertEquals(2, numberOfLine(twoLines));
    }

    @Test
    public void testTwoLinesSecondOneIsEmpty() throws Exception {
        String twoLines = "first line" + FooBarQix.LINE_SEPARATOR;
        assertEquals("first line", line(1, twoLines));
        assertEquals("", line(2, twoLines));
        assertEquals(2, numberOfLine(twoLines));
    }
}
