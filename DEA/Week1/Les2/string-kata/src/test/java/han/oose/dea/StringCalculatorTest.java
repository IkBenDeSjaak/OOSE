package han.oose.dea;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    private static StringCalculator calculator;

    @BeforeAll
    public static void init() {
        calculator = new StringCalculator();
    }

    @Test
    public void emptyStringTest() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void singeNumberTest() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void multipleNumbersTest() {
        assertEquals(4, calculator.add("1,4"));
    }

//    @Test
//    public void delimiterTest() {
//        a
//    }
}
