package StreamIO;

//PRENDE DUE FILE COME INPUT E COPIA IL PRIMO NEL SECONDO
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExCopyText {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Java ExCopyText src dst");
            System.err.println("Copy text file src to dst");
            System.exit(-1);
        }

        String srcFileName = args[0];
        String dstFileName = args[1];

        try {
            FileReader fileReader = new FileReader(srcFileName);

            try {
                FileWriter fileWriter = new FileWriter(dstFileName);

                char[] buffer = new char[128];
                int charsRead;

                try {
                    charsRead = fileReader.read(buffer);
                    while (charsRead != -1) {
                        fileWriter.write(buffer, 0, charsRead);
                    }
                } catch (IOException e) {

                }
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
                System.exit(-1);
            }
            fileReader.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }
}
