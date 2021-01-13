package Thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExThread07 {
    public ExThread07(String[] args) {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException ex) {
            }
            return "task1:" + Thread.currentThread().getName();
        }, () -> {
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
            }
            return "task2:" + Thread.currentThread().getName();
        }, () -> {
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException ex) {
            }
            return "task3:" + Thread.currentThread().getName();
        });

        try {
            executor.invokeAll(callables).stream().map(future -> {
                try {
                    return future.get();
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }).forEach(System.out::println);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        executor.shutdownNow();

    }

    public static void main(String[] args) {
        new ExThread07(args);
    }

}
