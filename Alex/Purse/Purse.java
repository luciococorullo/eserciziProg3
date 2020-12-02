package Purse;

public class Purse {
    // costruttore pubblico
    public Purse() {
        nickles = 0;
        dimes = 0;
        quarters = 0;
    }

    public void addNickles(int count) {

        nickles = nickles + count;

    }

    public void addDimes(int count) {
        dimes = dimes + count;
    }

    public void addQuarter(int count) {
        quarters = quarters + count;
    }

    // metodo che serve per calcolare l'ammontare del salvadenaio
    public double getTotal() {
        return nickles * NICKEL_VALUE + dimes * DIME_VALUE + quarters * QUARTER_VALUE;
    }

    private static final double NICKEL_VALUE = 0.05;
    private static final double DIME_VALUE = 0.1;
    private static final double QUARTER_VALUE = 0.25;
    private int nickles;
    private int dimes;
    private int quarters;
}
