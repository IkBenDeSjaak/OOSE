package han.oose.dea;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    private  StringCalculator calculator;

    @BeforeEach
    public void setup() {
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
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void newLineTest() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void multipleDelimiters() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    void overflowTest(){
        assertEquals(2, calculator.add("2,2000"));
    }
}
