package Thread.WorkFlow;

public class ExWorkFlow {

    public static void main(String[] args) {

        Node nodeA = new Node("A", "/bin/ls");
        Node nodeB = new Node("B", "/bin/hostname");
        Node nodeC = new Node("C", "/bin/ps");
        Node nodeD = new Node("D", "hello");

        // ciascun nodo quale nodo deve attendere per cui possa funzionare
        // nodo a viene eseguito
        // nodo b c contemporaneamente
        // nodo d solo dopo
        nodeB.add(nodeA);
        nodeC.add(nodeA);
        nodeD.add(nodeB);
        nodeD.add(nodeC);

        nodeA.start();
        nodeB.start();
        nodeC.start();
        nodeD.start();

    }

}
