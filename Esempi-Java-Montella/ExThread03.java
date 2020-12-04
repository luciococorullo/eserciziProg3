public class ExThread03 {
    class HelloRunner extends Thread {
        public void run() {

        }
    }

    public ExThread03(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<60;i++) {
                    System.out.println("Thread:"+i);
                    try {
                        Thread.sleep((int)(Math.random()* 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t = new Thread(r);
        t.start();
        for (int i=0;i<60;i++) {
            System.out.println("Main:"+i);
            try {
                Thread.sleep((int)(Math.random()* 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println("Attendo il thread...");
            t.join();
        } catch (InterruptedException ex) {}
        System.out.println("Finito!");
    }


    public static void main(String[] args) {
        new ExThread03(args);
    }

}
