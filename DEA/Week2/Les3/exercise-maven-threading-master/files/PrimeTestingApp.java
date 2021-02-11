package ???;

public class PrimeTestingApp {

    private static final int HIGHEST_NUMBER_TO_TEST = 300;

    public static void main(String[] args) {
        var app = new PrimeTestingApp();
        app.startTesting();
    }

    private void startTesting() {
        var numberUnderTest = new NumberUnderTest();

        var tester = new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST);

        tester.startTesting();
    }
}
