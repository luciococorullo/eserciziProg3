package DesignPatterns.StructuralPatterns.Adapter;

public class Square implements Shape {
    private LegacySquare adaptee = new LegacySquare();

    public void draw(int x1, int y1, int x2, int y2) {
        adaptee.draw(x1, x1, x1, x1);
    }
}
