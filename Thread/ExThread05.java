import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExThread05 {


    public ExThread05(String[] args) {

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

        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i=0;i< 100; i++) {
            executorService.submit(runnable);
        }

        try {
            TimeUnit.SECONDS.sleep(90);
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException interruptedException) {
            System.err.println(interruptedException.getMessage());
        } finally {
            executorService.shutdownNow();
        }
        System.out.println(Thread.currentThread().getName()+":--------------------------->Ended");
    }

    public static void main(String[] args) {
        new ExThread05(args);
    }


}

