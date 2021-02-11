package han.oose.dea;

import java.util.ArrayList;
import java.util.List;

public class PrimeTestingApp {

    private static final int HIGHEST_NUMBER_TO_TEST = 2000;

    public static void main(String[] args) {
        var app = new PrimeTestingApp();
        app.startTesting();
    }

    private void startTesting() {
        var numberUnderTest = new NumberUnderTest();
        int threadAmount = 4;

        List<PrimeTester> testers = new ArrayList<PrimeTester>();

        for(int i = 0; i < threadAmount; i++) {
            testers.add(new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST));
        }

        for (PrimeTester tester : testers) {
            new Thread(tester).start();
        }
    }
}