public class ExThread02 {

    class HelloRunner implements Runnable {

        private String name;

        public HelloRunner(String name) {
            this.name = name;
        }

        public void run() {
            for (int i=0;i<60;i++) {
                System.out.println(name+":"+i);
                try {
                    Thread.sleep((int)(Math.random()* 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ExThread02(String[] args) {
        HelloRunner r1 = new HelloRunner("Runner 1");
        HelloRunner r2 = new HelloRunner("Runner 2");

        new Thread(r1).start();
        new Thread(r2).start();

    }

    public static void main(String[] args) {
        new ExThread02(args);
    }
}
