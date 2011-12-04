package foobarqix;

import org.junit.Test;

import static foobarqix.FooBarQix.LINE_SEPARATOR;
import static foobarqix.FooBarQix.oneToAHundred;
import static foobarqix.LineUtils.line;
import static foobarqix.LineUtils.numberOfLine;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FooBarQixAcceptanceTest {

    @Test
    public void outputExample() {
        String output = oneToAHundred();
        assertTrue(output.startsWith("1" + LINE_SEPARATOR +
            "2" + LINE_SEPARATOR +
            "FooFoo" + LINE_SEPARATOR +
            "4" + LINE_SEPARATOR +
            "BarBar" + LINE_SEPARATOR +
            "Foo" + LINE_SEPARATOR +
            "QixQix" + LINE_SEPARATOR +
            "8" + LINE_SEPARATOR +
            "Foo" + LINE_SEPARATOR +
            "Bar"));
    }

    @Test
    public void oneLineExamples() {
        String output = oneToAHundred();

        assertEquals("FooBar", line(51, output));
        assertEquals("BarFoo", line(53, output));
        assertEquals("FooQix", line(21, output));
        assertEquals("Foo", line(13, output));
        assertEquals("FooBarBar", line(15, output));
        assertEquals("FooFooFoo", line(33, output));
    }

    @Test
    public void developerExamples() {
        String output = oneToAHundred();

        assertEquals("FooQixFoo", line(63, output));
        assertEquals("QixQixQix", line(77, output));
    }

    @Test
    public void oneNumberPerLineWithAHundredLines() {
        String output = oneToAHundred();
        assertEquals(100, numberOfLine(output));
    }
}
