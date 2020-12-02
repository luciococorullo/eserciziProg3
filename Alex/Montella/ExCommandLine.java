package Montella;

import java.util.Properties;

public class ExCommandLine {
    // ExCommandLine opcode op1 op2
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Java ExCommandLine [-Dtype=int|float] opcode op1 op2");
            System.err.println("Perform the operation as specified by opcode.");
            System.exit(-1);
        }
        Properties properties = System.getProperties();

        /*
         * for(String propertyName:properties.stringPropertyNames()){
         * System.out.println(propertyName); }
         */

        String type = properties.getProperty("type");
        System.out.println(type);
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}