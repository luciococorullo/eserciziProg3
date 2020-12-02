package Programmazione.DesignPatterns.StructuralPatterns.Adapter;

public class LegacySquare {
    public void draw(int x, int y, int w, int h) {
        System.out.println("square at (" + x + ',' + y + ") with width and height " + w);
    }
}
