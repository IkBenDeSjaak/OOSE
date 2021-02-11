package han.oose.dea;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberUnderTestTest {

    @Test
    void OneCallReturnsZero() {
        // Arrange
        NumberUnderTest nut = new NumberUnderTest();

        // Act
        int result = nut.getNumber();

        // Assert
        assertEquals(0, result);
    }

    @Test
    void FourCallsReturnsZeroThroughThree() {
        // Arrange
        NumberUnderTest nut = new NumberUnderTest();

        // Act
        int result1 = nut.getNumber();
        int result2 = nut.getNumber();
        int result3 = nut.getNumber();
        int result4 = nut.getNumber();

        // Assert
        assertEquals(0, result1);
        assertEquals(1, result2);
        assertEquals(2, result3);
        assertEquals(3, result4);
    }
}