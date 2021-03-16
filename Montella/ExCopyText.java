package Montella;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExCopyText {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("java ExCopyText src dst");
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
                        charsRead = fileReader.read(buffer);
                    }
                } catch (IOException ex) {

                }
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                System.exit(-1);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
    }
}
