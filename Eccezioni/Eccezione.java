package Programmazione.Eccezioni;

//primo codice che causa errori se riceve un input diverso da un intero
public class Eccezione {
    public static void main(String[] args) {
        int sum = 0;
        for (String arg : args) {
            sum += Integer.parseInt(arg);
        }
        System.out.println("Sum = " + sum);
    }
}