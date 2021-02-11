package oose.dea.bankdemo;

public class ParallelStorten implements Runnable {
    private Bank bank;
    private int amount;

    public ParallelStorten(Bank bank, int amount) {
        this.bank = bank;
        this.amount = amount;
    }

    @Override
    public void run() {
        bank.stort(amount);
    }
}
