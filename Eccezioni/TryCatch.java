package Programmazione.Eccezioni;

//prima soluzione con il costrutto try-catch
public class TryCatch {
    public static void main(String[] args) {

        try {
            int sum = 0;
            for (String arg : args) {
                sum += Integer.parseInt(arg);
            }
            System.out.println("Sum = " + sum);
        } catch (NumberFormatException e) {
            System.err.println("One of the arguments is not an integer");
        }
    }
}
