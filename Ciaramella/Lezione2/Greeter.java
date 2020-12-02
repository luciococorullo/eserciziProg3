package Ciaramella.Lezione2;

public class Greeter {
    // costruttore, deve avere lo stesso nome della classe generale.
    public Greeter(String aName, String aSurname) {
        name = aName;
        cognome = aSurname;
    }

    // metodo che printa il messaggio
    public String sayHello() {
        // concateno le stringhe con "+"
        String message = "Hello " + name + cognome + "!";
        return message;
    }

    // variabile istanza, incapsulamento = in genere quando abbiamo l'incapsulamento
    // e' sempre "private"
    private String name, cognome;

}

/*
 * Come e' costituita una classe?
 * 
 * 
 * specificatoreDiAccesso class NomeClasse { costruttori -->
 * "hanno lo stesso nome della classe" metodi -->
 * "sono di tipo  SET = vanno a settare le informazioni e GET = vanno a prendere le informazioni"
 * campo ( variabili istanziate ) --> "gli attributi che sono nascosti " }
 * 
 * 
 * Come e' costituito un costruttore?
 * 
 * specificatoreDiAccesso class NomeClasse{ specificatoreDiAccesso
 * NomeClasse(tipoParametro nomeParametro, ...){ corpo del costruttore } }
 * 
 */