package week04.gcrcodebase.iostreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindErrorLines {

    public static void main(String[] args) {

        String filePath = "largefile.txt"; // 500MB+ file

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Case-insensitive check
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

