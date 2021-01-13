package Thread.Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExNetworking01 {

    public ExNetworking01(String[] args) {
        Runnable server = () -> {
            try {
                ServerSocket serverSocket = new ServerSocket(1972);
                while (true) {
                    System.out.println("Waiting...");
                    Socket socket = serverSocket.accept();
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String out = dtf.format(now);
                    System.out.println("Serving: " + out);
                    printWriter.println(out);
                    printWriter.close();
                    socket.close();

                }
            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        };

        Runnable client = () -> {
            try {
                Socket socket = new Socket("127.0.0.1", 1972);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(bufferedReader.readLine());
                bufferedReader.close();
                socket.close();
            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        };

        ExecutorService executor = Executors.newWorkStealingPool();
        executor.submit(server);
        for (int i = 0; i < 10; i++) {
            executor.submit(client);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        executor.shutdownNow();
    }

    public static void main(String[] args) {
        new ExNetworking01(args);
    }
}
