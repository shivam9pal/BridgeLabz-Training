package week05.gcrcodebase.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LargeCSVReader {

    private static final int CHUNK_SIZE = 100;

    public static void main(String[] args) {

        String filePath = "largefile.csv";
        String line;
        int totalProcessed = 0;

        List<String> buffer = new ArrayList<>(CHUNK_SIZE);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header if present
            br.readLine();

            while ((line = br.readLine()) != null) {
                buffer.add(line);

                if (buffer.size() == CHUNK_SIZE) {
                    processChunk(buffer);
                    totalProcessed += buffer.size();
                    System.out.println("Processed records: " + totalProcessed);
                    buffer.clear();  // free memory
                }
            }

            // Process remaining lines
            if (!buffer.isEmpty()) {
                processChunk(buffer);
                totalProcessed += buffer.size();
                System.out.println("Processed records: " + totalProcessed);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Simulate processing of each chunk
    private static void processChunk(List<String> chunk) {
        for (String record : chunk) {
            
        }
    }
}


