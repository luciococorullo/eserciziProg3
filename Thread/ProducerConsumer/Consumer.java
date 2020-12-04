package Thread.ProducerConsumer;

public class Consumer implements Runnable {
    private SyncStack syncStack;
    private int num;
    private int items;
    private static int counter = 1;

    protected Consumer(SyncStack syncStack, int items) {
        this.syncStack = syncStack;
        this.items = items;
        num = counter++;
    }

    @Override
    public void run() {
        for (int item = 0; item < items; item++) {
            char c = syncStack.pop();
            System.out.println("Consumer: " + num + " Item: " + item + "/" + items + ": " + c);
            try {
                Thread.sleep((int) (Math.random() * 500));
            } catch (InterruptedException e) {

            }
        }
    }
}
