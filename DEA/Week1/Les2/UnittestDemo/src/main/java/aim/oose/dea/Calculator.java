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
            System.out.println("dit kan niet");
        }
        return x / y;
    }
}
