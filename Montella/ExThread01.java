package Montella;

public class ExThread01 {

    class HelloRunner extends Thread {
        public void run() {
            for (int i = 0; i < 60; i++) {
                System.out.println(getName() + ":" + i);
                try {
                    Thread.sleep((int) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ExThread01(String[] args) {
        HelloRunner t1 = new HelloRunner();
        t1.setName("Runner 1");

        HelloRunner t2 = new HelloRunner();
        t2.setName("Runner 2");

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new ExThread01(args);
    }

}
