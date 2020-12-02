package Programmazione.StreamIO;
//NON COMPLETO

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExCopyTextLineByLine {
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
            } catch (IOException e) {
                System.err.println(e.getMessage());
                System.exit(-1);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }

}
