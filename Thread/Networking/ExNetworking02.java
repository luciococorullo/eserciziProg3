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

public class ExNetworking02 {
    public ExNetworking02(String[] args) {
        Runnable server = () -> {

            class ClientImage implements Runnable {
                private Socket socket;

                public ClientImage(Socket socket) {
                    this.socket = socket;
                }

                public void run() {
                    try {
                        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                        BufferedReader bufferedReader = new BufferedReader(
                                new InputStreamReader(socket.getInputStream()));

                        String line = bufferedReader.readLine();

                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        String out = dtf.format(now);
                        System.out.println(Thread.currentThread().getName() + " -> " + line + ": " + out);
                        printWriter.println(out + "\n");
                        bufferedReader.close();
                        printWriter.close();
                        socket.close();
                    } catch (IOException ioException) {
                        System.out.println(ioException.getMessage());
                    }
                }
            }

            ExecutorService executor = Executors.newWorkStealingPool();
            try {
                ServerSocket serverSocket = new ServerSocket(1972);
                while (true) {
                    System.out.println("Waiting...");
                    Socket socket = serverSocket.accept();
                    System.out.println("Accepted:" + socket.getInetAddress());
                    executor.submit(new ClientImage(socket));

                }

            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
            executor.shutdownNow();
        };

        Runnable client = () -> {
            try {
                Socket socket = new Socket("127.0.0.1", 1972);

                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                printWriter.println(Thread.currentThread().getName() + "\n");
                String line = bufferedReader.readLine();
                System.out.println(line);
                bufferedReader.close();
                printWriter.close();
                socket.close();
            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        };

        ExecutorService executor = Executors.newWorkStealingPool();
        executor.submit(server);
        for (int i = 0; i < 100; i++) {
            executor.submit(client);
        }

        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        executor.shutdownNow();
    }

    public static void main(String[] args) {
        new ExNetworking02(args);
    }
}
