package DesignPattern;

public class SigletosTest {
    public static void main(String[] args) {

        // richiamo il metodo statico associato alla classe
        Singleton s = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        if (s == s2) {
            System.out.println("Sono uguali");
        }
    }
}
