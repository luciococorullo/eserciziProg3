/*
definire una classe myPoint che ha due variabili private x e y a ha come metodi
- costruttore 
- get x e get y 
- set x e set y
- restituisce entrambi get x get y
- calcola la distanza tra due punti, prende in input un oggetto di tipo myPoint
- calcolo la distanza tra x e y

*/
package esercitazioneLusho;

public class MyPoint {
    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getXY() {
        int[] arr = { x, y };
        return arr;
    }

    // distanza tra due punti
    public double distanzaTraPunti(int x, int y) {
        double risultatoX = (this.x - x) * (this.x - x);
        double risultatoY = (this.y - y) * (this.y - y);
        return Math.sqrt(risultatoX + risultatoY);
    }

    // distanza dal centro
    public double distanzaTraPunti() {
        double risultatoX = (this.x) * (this.x);
        double risultatoY = (this.y) * (this.y);
        return Math.sqrt(risultatoX + risultatoY);
    }

    public double distanzaTraPunti(MyPoint xy) {
        double risultatoX = (this.x - xy.x) * (this.x - xy.x);
        double risultatoY = (this.y - xy.y) * (this.y - xy.y);
        return Math.sqrt(risultatoX + risultatoY);
    }

    private int x;
    private int y;
}
