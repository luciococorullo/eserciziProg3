package Ciaramella.Purse;

public class PurseTest {
    public static void main(String[] args) {
        Purse salvadenaioDiAlex = new Purse();
        salvadenaioDiAlex.addNickles(3);
        salvadenaioDiAlex.addDimes(2);
        salvadenaioDiAlex.addQuarter(6);
        System.out.println(salvadenaioDiAlex.getTotal());
    }
}
