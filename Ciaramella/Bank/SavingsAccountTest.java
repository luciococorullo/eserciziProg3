package Programmazione.Ciaramella.Bank;

public class SavingsAccountTest {
    public static void main(String[] args) {
        SavingsAccount mio_account = new SavingsAccount(2);
        mio_account.deposito(1000);
        System.out.println("il saldo senza interessi e'" + mio_account.getBalance());
        mio_account.addInterest();
        System.out.println("il saldo con interessi");

    }
}
