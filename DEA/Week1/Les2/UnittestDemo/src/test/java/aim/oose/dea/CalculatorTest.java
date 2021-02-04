package aim.oose.dea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void multiplyTest() {
        //arrange (setup)
        int x = 3;
        int y = 3;
        int expected = 9; // 3 * 3 = 9;

        //act (test)
        int result = calculator.multiply(x, y);

        //assert (verify)
        assertEquals(expected, result);
    }

    @Test
    public void addTest() {
        assertEquals(4, calculator.add(2, 2));
        assertEquals(10, calculator.add(5, 5));

    }

    @Test
    public void subtractTest() {
        assertEquals(7, calculator.subtract(10, 3));
        assertEquals(3, calculator.subtract(10, 7));
    }

    @Test
    public void divideTest() {
        assertEquals(0.33333333f, calculator.divide(1, 3), 0.00001f);
    }

    @Test
    public void divideByZeroTest() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(100, 0)
        );
    }

}
