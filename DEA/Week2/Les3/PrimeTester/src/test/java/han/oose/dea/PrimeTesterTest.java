package han.oose.dea;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class PrimeTesterTest {
    private NumberUnderTest nut = new NumberUnderTest();
    private ByteArrayOutputStream ba = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(ba));
    }

    @Test
    void PrimesTo3Returns2and3() {
        // Arrange
        PrimeTester pt = new PrimeTester(nut, 3);

        // Act
        pt.run();

        // Assert
        String output = new String(ba.toByteArray());
        Assertions.assertTrue(output.contains(" found a prime number: 2")
                && output.contains(" found a prime number: 3"));
    }

    @Test
    void PrimesTo37ThrowsException() {
        // Arrange
        PrimeTester pt = new PrimeTester(nut, 37);

        // Act & Assert
        Assertions.assertThrows(OuchIFoundThirtySevenAndHenceMustDieException.class, () -> pt.startTesting());
    }

    @Test
    void PrimesTo37ContainsExceptionText() {
        // Arrange
        PrimeTester pt = new PrimeTester(nut, 37);

        // Act
        pt.run();

        // Assert
        String output = new String(ba.toByteArray());
        Assertions.assertTrue(output.contains(" found Thirty Seven and must die."));
    }
}
