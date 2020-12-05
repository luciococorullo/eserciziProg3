package Thread.WorkFlow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Node extends Thread { // node struttura dati sia produttore che consumatore quindi deve attendere i
                                   // thread
    private Vector<Node> prev = new Vector<Node>();
    private String command;

    // costruttore
    public Node(String name, String command) {
        setName(name);
        this.command = command;
    }

    // creamo dipendenza con node
    public void add(Node node) {
        prev.add(node);
    }

    @Override
    public void run() {
        System.out.println(getName() + ":Attendo");
        for (Node node : prev) {
            try {
                node.join();
            } catch (InterruptedException e) {
                System.out.println("Eseguo:" + getName() + ":Interrotto");
                return;
            }
        }
        System.out.println("Eseguo:" + getName() + ":Eseguo -->" + command);
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(command);
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
            BufferedReader bufferedReader = new BufferedReader((inputStreamReader));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(getName() + "->" + line);
            }
        } catch (IOException e) {
            System.out.println("Eseguo:" + getName() + ":Eseguo -->" + e.getMessage());
        }
        try {
            Thread.sleep((int) (Math.random() * 500));
            System.out.println("Eseguo:" + getName() + ":Finito");
        } catch (InterruptedException e) {
            System.out.println("Eseguo:" + getName() + ":Interrotto");

        }
        System.out.println("Eseguo:" + getName() + ":Finito");

    }

}
