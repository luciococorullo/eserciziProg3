package Programmazione.Ciaramella.Bank;

public class DataSetTest {
    public static void main(String[] args) {
        DataSet bankData = new DataSet();
        DataSet coinData = new DataSet();

        bankData.add(new BankAccount(0));
        bankData.add(new BankAccount(100));
        bankData.add(new BankAccount(2000));

        System.out.println("valore inerente a bankAccount =" + bankData.getSum());

        coinData.add(new BankAccount(0));
        coinData.add(new BankAccount(100));
        coinData.add(new BankAccount(2000));

        System.out.println("valore inerente a coin =" + coinData.getSum());
    }

}
