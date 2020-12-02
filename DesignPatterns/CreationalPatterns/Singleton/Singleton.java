package Programmazione.DesignPatterns.CreationalPatterns.Singleton;

public class Singleton {

    private Singleton() {
    };

    public Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    Singleton instance;
}
