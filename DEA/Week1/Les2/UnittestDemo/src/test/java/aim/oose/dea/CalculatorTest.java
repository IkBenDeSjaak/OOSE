package aim.oose.dea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup(){
        calculator = new Calculator();
    }

    @Test
    public void multiplyTest(){
        int x = 3;
        int y = 3;
        int expected = 9; // 3 * 3 = 9;

        int result = calculator.multiply(x,y);

        assertEquals(expected,result);
    }

    @Test
    public void addTest(){
        assertEquals(4,calculator.add(2,2));
        assertEquals(10,calculator.add(5,5));

    }

    @Test
    public void subtractTest() {
        assertEquals(7, calculator.subtract(10, 3));
        assertEquals(2, calculator.subtract(10, 7));
    }

    @Test
    public void divideTest(){
        assertEquals(4.5, calculator.divide(18, 4), 0.0001);
    }

    @Test
    public void divideByZeroTest() {
        calculator.divide(100, 0);
    }

}
