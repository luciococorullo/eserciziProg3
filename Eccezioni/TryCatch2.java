package Eccezioni;

//secondo metodo che utilizza il try catch, questa volta nel costrutto
//inseriamo soltanto la parte che puo generare errori riuscendo cosi
//ad eseguire parzialmente il programma
public class TryCatch2 {
    public static void main(String[] args) {
        int sum = 0;
        for (String arg : args) {
            try {
                sum += Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                System.err.println("[" + arg + "] is not an integer and it will be not included");
            }
        }
        System.out.println("Sum = " + sum);
    }
}
