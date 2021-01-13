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

public class ExNetworking03 {
    public ExNetworking03(String[] args) {

        ExecutorService executor = Executors.newWorkStealingPool();

        class ClientImage implements Runnable {
            private Socket socket;

            public ClientImage(Socket socket) {
                this.socket = socket;
            }

            public void run() {
                try {
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    String line = bufferedReader.readLine();
                    if (line.startsWith("avada kedavra")) {
                        executor.shutdownNow();
                    }
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
        ;

        try {
            ServerSocket serverSocket = new ServerSocket(1972);
            while (true) {
                System.out.println("Waiting...");
                Socket socket = serverSocket.accept();
                System.out.println("Accepted:" + socket.getInetAddress());
                executor.submit(new ClientImage(socket));
                serverSocket.close();
            }
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
        executor.shutdownNow();
    }

    public static void main(String[] args) {
        new ExNetworking03(args);
    }
}
