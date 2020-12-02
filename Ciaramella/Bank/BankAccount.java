package Ciaramella.Bank;

public class BankAccount implements Measurable {
    // costruttore
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // metodo 1
    public void deposito(double ammount) {
        this.balance = this.balance + ammount;
    }

    // metodo 2
    public void withDraw(double ammount) {
        this.balance = this.balance - ammount;
    }

    // metodo 3
    public Double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object other) {
        BankAccount Temp = (BankAccount) other;
        if (this.balance == Temp.getBalance())
            return true;
        else
            return false;

        // return super.equals(Object);
    }

    // metodo che richiama l'interfaccia measurable.java
    public double getMeasure() {
        return balance;
    }

    public static void main(String[] args) {

        BankAccount A = new BankAccount(10);
        BankAccount B = new BankAccount(20);
        if (A.equals(B)) {
            System.out.println("I conti sono uguali");
        } else {
            System.out.println("I conti sono diversi");
        }
    }

    private Double balance;
}
