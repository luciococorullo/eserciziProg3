package Programmazione.Ciaramella.Bank;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
        contatoreTransizioni = 0;
    }

    public void deductFees() {
        if (contatoreTransizioni > numeroTransazioniGratis) {
            double fees = tassaPerTransazione * (contatoreTransizioni - numeroTransazioniGratis);
            super.withDraw(fees);
        }
    }

    public void deposito(double sommaDeposito) {
        contatoreTransizioni += 1;
        super.deposito(sommaDeposito);
    }

    public void withDraw(double prelievoDenaro) {
        contatoreTransizioni += 1;
        super.withDraw(prelievoDenaro);
    }

    private int numeroTransazioniGratis = 3;
    private double tassaPerTransazione = 2.0;
    private int contatoreTransizioni;
}
