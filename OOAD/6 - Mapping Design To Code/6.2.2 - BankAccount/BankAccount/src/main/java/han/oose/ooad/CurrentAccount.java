package han.oose.ooad;

public class CurrentAccount extends Account {
    private double creditLimit;

    CurrentAccount(Bank b, String cust, double credLim) {
        super(b, cust);
    }

    double getCreditLimit() {
        return 0;
    }

    public void setCreditLimit(double credLim) {

    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
    }
}
