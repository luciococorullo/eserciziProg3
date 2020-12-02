package Thread;

public class ThreadTester {
  public static void main(String args[]) {
    // dichiaro le istanze runnable da utilizzare nella dichiarazione dei thread
    HelloRunner r = new HelloRunner();
    Runner run = new Runner();

    // dichiaro due thread utilizzando le istanze runnable dichiarate
    // precedentemente
    Thread t = new Thread(r);
    Thread runnThread = new Thread(run);

    // starto l'esecuzione dei thread
    t.start();
    runnThread.start();

    // utilizzo il metodo join

    try {
      t.join();
    } catch (InterruptedException e) {
      System.err.println("Interrupted exception on join");
    }

    try {
      System.out.println("yooooo " + t.getState());
      t.wait();
    } catch (Exception e) {
      System.out.println("Interrupted exception on wait");
    }
  }
}

class HelloRunner implements Runnable {
  int i;

  public void run() {
    i = 0;
    while (true) {
      System.out.println("Hello " + i++);
      if (i == 5) {
        break;
      }
    }
  }

}
