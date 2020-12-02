package Ciaramella.Lezione2;

public class GreeterTest {
    public static void main(String[] args) {
        // con new chiamo il "costruttore" greeter che ha come input due stringhe!!!
        Greeter worldGreeter = new Greeter(" Alessandro ", "Dauria");
        System.out.println(worldGreeter.sayHello());
    }
}