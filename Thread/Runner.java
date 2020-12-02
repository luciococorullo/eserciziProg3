package Thread;

public class Runner implements Runnable {
    boolean timeToQuit = false;
    int j;

    public void run() {
        while (!timeToQuit) {
            System.out.println("Hello thread " + j++);

            if (j == 5) {
                stopRunning();
            }

            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                System.err.println("Errore nello sleep");
            }
        }
    }

    public void stopRunning() {
        timeToQuit = true;
    }
}
