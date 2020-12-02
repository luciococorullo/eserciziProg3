package Programmazione.Ciaramella.Bank;

public class DataSet {
    public DataSet() {
        sum = 0;

    }

    // con measurable indico un dato generico che puo' essere sia bankaccount o coin
    public void add(Measurable x) {
        sum = sum + x.getMeasure();
    }

    public double getSum() {
        return sum;
    }

    private double sum;
}
