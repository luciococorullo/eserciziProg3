import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ExSerializeDate {
    public static void main(String[] args) throws IOException  {
        Date dateNow = new Date();

        FileOutputStream fileOutputStream = new FileOutputStream("date.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(dateNow);
    }
}
