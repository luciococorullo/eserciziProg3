package Programmazione.Ciaramella.Bank;

class Coin implements Measurable {

    public Coin(double aValue, String aName) {
        value = aValue;
        name = aName;
    }

    // methods to access the value and name

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    // metodo che richiama l'interfaccia measurable.java
    public double getMeasure() {
        return value;
    }

    // instance variables to store the value and name

    private double value;
    private String name;

}
