package Bank;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(double rate) {
        super(rate);
        interestRate = rate;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposito(interest);
    }

    private double interestRate;

}