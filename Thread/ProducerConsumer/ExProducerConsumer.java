import java.util.Vector;

public class ExProducerConsumer {
    public static void main(String[] args) {
        SyncStack syncStack = new SyncStack(512);
        Vector<Producer> producers = new Vector<Producer>();
        Vector<Consumer> consumers = new Vector<Consumer>();

        producers.add(new Producer(syncStack, 64));
        producers.add(new Producer(syncStack, 256));
        producers.add(new Producer(syncStack, 512));

        consumers.add(new Consumer(syncStack, 32));
        consumers.add(new Consumer(syncStack, 32));
        consumers.add(new Consumer(syncStack, 128));
        consumers.add(new Consumer(syncStack, 128));
        consumers.add(new Consumer(syncStack, 256));
        consumers.add(new Consumer(syncStack, 256));

        for (Producer producer : producers) {
            new Thread(producer).start();
        }

        for (Consumer consumer : consumers) {
            new Thread(consumer).start();
        }
    }
}
