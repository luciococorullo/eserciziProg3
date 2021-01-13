package Thread;

import java.util.concurrent.*;

public class ExThread06 {

    // definisco una classe per il risultato
    class Result {
        int x;
        int y;

        Result(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Callable<Result> task = () -> {
        try {
            TimeUnit.SECONDS.sleep(5);
            return new Result(3, 2);
        } catch (InterruptedException e) {
            throw new IllegalStateException("task interrupted", e);
        }
    };

    public ExThread06(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        // variabiile legata al thread che la genera
        Future<Result> futureResult = executor.submit(task);

        // posso controllare se il thread chiamante é terminato
        while (!futureResult.isDone()) {
            try {
                System.out.println("Waiting...");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
            }
        }

        try {
            Result result = futureResult.get();
            System.out.println(result.x + ";" + result.y);
        } catch (InterruptedException ex1) {
        } catch (ExecutionException ex2) {
        }

        Future<Integer> future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        try {
            future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException ex1) {
        } catch (ExecutionException ex2) {
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        executor.shutdownNow();

    }

    public static void main(String[] args) {
        new ExThread06(args);
    }

}
