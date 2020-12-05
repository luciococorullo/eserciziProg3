package Thread.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

public class SyncStack {

    private List<Character> buffer;

    public SyncStack(int maxSize) {
        buffer = new ArrayList<Character>(512);
    }

    public synchronized char pop() {
        // char c;

        while (buffer.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {

            }
        }
        return buffer.remove(buffer.size() - 1);
    }

    public synchronized void push(Character c) {
        buffer.add(c);
        this.notify();
    }

}
