package han.oose.dea;

import org.apache.commons.math3.primes.Primes;

public class PrimeTester implements Runnable {

    NumberUnderTest numberUnderTest;
    int highestNumberToTest;

    public PrimeTester(NumberUnderTest numberUnderTest, int highestNumberToTest) {
        this.numberUnderTest = numberUnderTest;
        this.highestNumberToTest = highestNumberToTest;
    }

    public void startTesting() throws OuchIFoundThirtySevenAndHenceMustDieException {

        while (true) {

            var number = numberUnderTest.getNumber();

            if (number > highestNumberToTest){
                break;
            }

            if (number == 37) {
                throw new OuchIFoundThirtySevenAndHenceMustDieException(Thread.currentThread().getId()
                        + " found Thirty Seven and must die.");
            }

            boolean isPrime = Primes.isPrime(number);

            if (isPrime) {
                System.out.println(Thread.currentThread().getId() + " found a prime number: " + number);
            }
        }
    }

    @Override
    public void run() {
        try {
            startTesting();
        } catch (OuchIFoundThirtySevenAndHenceMustDieException e) {
            System.out.println(e.getMessage());
        }
    }
}
