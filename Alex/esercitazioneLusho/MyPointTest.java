package esercitazioneLusho;

public class MyPointTest {
    public static void main(String[] args) {
        MyPoint a = new MyPoint();
        MyPoint b = new MyPoint();

        a.setX(5);
        a.setY(9);

        b.setX(7);
        b.setY(4);

        System.out.println(a.getX());
        System.out.println(a.getY());

        System.out.println(b.getX());
        System.out.println(b.getY());

        System.out.print(a.distanzaTraPunti(b));

        System.out.println("Punto a: " + a.getXY()[0] + "," + a.getXY()[1]);
    }
}
