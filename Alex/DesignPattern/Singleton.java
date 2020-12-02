package DesignPattern;

public class Singleton {
    // dichiaro una variabile di tipo Singleton statica
    private static Singleton instance;

    // creo un costruttore privato cosi' che possono accedervi solo
    // le function della classe
    private Singleton() {
    }

    // instance nella prima esecuzione e' uguale a null
    // mentre in tutte le restanti sara' uguale all'oggetto
    // creato in precedenza, ne viene creato uno solo e mai multipli
    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();

        return instance;
    }

}

/*
 * Scopo Assicurare che una classe abbia una sola istanza e fornire un punto
 * globale di accesso ad essa
 */