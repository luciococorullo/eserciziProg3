package Bank;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount harryChecking = new BankAccount(0);
        CheckingAccount lushocheck = new CheckingAccount(0);
        harryChecking.deposito(200);
        harryChecking.withDraw(500);
        // Checking account
        lushocheck.deposito(5);
        lushocheck.withDraw(2);

        System.out.println(harryChecking.getBalance());
        System.out.print(lushocheck.getBalance());

        
    }

}
