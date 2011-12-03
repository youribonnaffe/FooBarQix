import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class FooBarQixAcceptanceTest {

    @Test
    public void outputExample() {
        String output = FooBarQix.oneToAHundred();
        assertTrue(output.startsWith("1" + FooBarQix.LINE_SEPARATOR +
            "2" + FooBarQix.LINE_SEPARATOR +
            "FooFoo" + FooBarQix.LINE_SEPARATOR +
            "4" + FooBarQix.LINE_SEPARATOR +
            "BarBar" + FooBarQix.LINE_SEPARATOR +
            "Foo" + FooBarQix.LINE_SEPARATOR +
            "QixQix" + FooBarQix.LINE_SEPARATOR +
            "8" + FooBarQix.LINE_SEPARATOR +
            "Foo" + FooBarQix.LINE_SEPARATOR +
            "Bar"));
    }

    @Test
    public void oneLineExamples() {
        String output = FooBarQix.oneToAHundred();

        assertEquals("FooBar", LineUtils.line(51, output));
        assertEquals("BarFoo", LineUtils.line(53, output));
        assertEquals("FooQix", LineUtils.line(21, output));
        assertEquals("Foo", LineUtils.line(13, output));
        assertEquals("FooBarBar", LineUtils.line(15, output));
        assertEquals("FooFooFoo", LineUtils.line(33, output));
    }

    @Test
    public void oneNumberPerLineWithAHundredLines() {
        String output = FooBarQix.oneToAHundred();
        assertEquals(100, LineUtils.numberOfLine(output));
    }


}
