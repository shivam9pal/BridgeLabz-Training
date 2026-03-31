package week05.gcrcodebase.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicateCSV {

    public static void main(String[] args) {

        String filePath = "students.csv";
        String line;

        Set<String> seenIds = new HashSet<>();
        Set<String> duplicateLines = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];

                if (!seenIds.add(id)) {
                    duplicateLines.add(line);
                }
            }

            System.out.println("Duplicate Records Found:\n");

            for (String dup : duplicateLines) {
                System.out.println(dup);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

