package aim.oose.dea;

public class Calculator {
    public int multiply(int x, int y) {
        return x * y;
    }

    public int add(int x, int y) {
        return x + y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public float divide(float x, float y) {
        if(y == 0) {
            throw new IllegalArgumentException("delen door 0 is flauwekul");
        }
        return x / y;
    }
}
