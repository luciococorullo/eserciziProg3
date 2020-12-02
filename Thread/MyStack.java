package Programmazione.Thread;

public class MyStack {

    // TODO aggiungere le ultime slide
    private int index = 0;
    private char[] data = new char[6];

    public synchronized void push(char c) {
        data[index] = c;
        index++;
    }

    public synchronized char pop() {
        index--;
        return data[index];
    }
}
