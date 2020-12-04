package Eccezioni;

public class ServerTimedOutException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int port;

    public ServerTimedOutException(String message, int port) {
        super(message);
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void connectMe(String name) throws ServerTimedOutException {
        boolean success = false;
        int portToConnect = 80;

        // success = open(name,portToConnect); manca libreria che contiene open

        if (!success) {
            throw new ServerTimedOutException("Non é stato possibile connettersi", portToConnect);
        }
    }

}
