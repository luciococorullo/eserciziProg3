package Thread.ProducerConsumer;

public class Producer implements Runnable {
    private SyncStack syncStack;
    private int num; // numero identificativo del producer
    private int items; // numero di oggetti prodotti dal producer
    private static int counter = 1;

    public Producer(SyncStack syncStack, int items) {
        this.syncStack = syncStack;
        this.items = items;
        num = counter++;
    }

    @Override
    public void run() {
        for (int item = 0; item < items; item++) {
            char c = (char) (Math.random() * 26 + 'A');
            syncStack.push(c);
            System.out.println("Producer: " + num + " Item: " + item + "/" + items + " : " + c);
            try {
                Thread.sleep((int) (Math.random() * 500));
            } catch (InterruptedException e) {

            }
        }
    }
}
