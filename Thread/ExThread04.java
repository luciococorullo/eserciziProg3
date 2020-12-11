public class ExThread04 {


    public ExThread04(String[] args) {
        Runnable runnable = () -> {
            for (int i=0;i<60;i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
                try {
                    Thread.sleep((int)(Math.random()* 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i=0;i< 100; i++) {
            new Thread(runnable).start();
        }
        System.out.println(Thread.currentThread().getName()+":--------------------------->Ended");
    }

    public static void main(String[] args) {
        new ExThread04(args);
    }


}

