import java.io.*;

public class ExCopyTextLineByLine {
    public static void main(String[] args) {
        if (args.length!=2) {
            System.err.println("java ExCopyText src dst");
            System.err.println("Copy text file src to dst");
            System.exit(-1);
        }

        String srcFileName=args[0];
        String dstFileName=args[1];

        try {
            FileReader fileReader = new FileReader(srcFileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            try {
                FileWriter fileWriter = new FileWriter(dstFileName);

                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                String line;

                try {
                    line = bufferedReader.readLine();
                    while (line != null) {
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                        line = bufferedReader.readLine();
                    }
                } catch (IOException ex) {

                }

                bufferedWriter.flush();
                bufferedWriter.close();

                fileWriter.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                System.exit(-1);
            }
            bufferedReader.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
    }
}
