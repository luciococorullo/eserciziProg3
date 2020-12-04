import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

public class ExDeserializeDemo {
    public static void main(String[] args) throws IOException {
        Date date = null;

        FileInputStream fileInputStream = new FileInputStream("date.ser");

        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        try {
            date = (Date)objectInputStream.readObject();
            System.out.println(date);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());

        }
    }
}
