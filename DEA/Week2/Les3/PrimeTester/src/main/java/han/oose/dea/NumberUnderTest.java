package han.oose.dea;

public class NumberUnderTest {

    private int number;

    public synchronized int getNumber() {
        return number++;
    }
}