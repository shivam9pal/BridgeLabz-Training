package week03.gcrcodebase.binarystrinbuilder;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class ConsoleTextReader {
	public static void main(String[] args) {
        String filePath = "file.txt";
        try (
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader consoleReader = new BufferedReader(isr);
            FileWriter writer = new FileWriter(filePath, true) 
        ) {
            System.out.println("Enter text (type 'exit' to stop):");

            String input;
            while ((input = consoleReader.readLine()) != null) {
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.write(input);
                writer.write(System.lineSeparator()); 
                writer.flush(); 
            }

            System.out.println("Input saved to " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
