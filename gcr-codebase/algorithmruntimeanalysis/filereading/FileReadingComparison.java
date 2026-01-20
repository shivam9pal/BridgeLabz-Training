package week3.dsa.algorithmruntimeanalysis.filereading;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadingComparison {
    
    public static void main(String[] args) {
        int[] fileSizes = {1, 100, 500}; // in MB
        
        System.out.println("File Reading Performance Comparison");
        
        for (int sizeMB : fileSizes) {
            try {
                compareFileReading(sizeMB);
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
    
    private static void compareFileReading(int sizeMB) throws IOException {
        String fileName = "testfile_" + sizeMB + "MB.txt";
        File file = new File(fileName);
        
        // Create test file
        createTestFile(fileName, sizeMB);
        
        System.out.printf("File Size: %dMB\n", sizeMB);
        
        // FileReader
        long fileReaderTime = FileReaderExample.readFile(fileName);
        System.out.printf("FileReader Time: %.2fs\n", fileReaderTime / 1_000_000_000.0);
        
        // InputStreamReader
        long inputStreamReaderTime = InputStreamReaderExample.readFile(fileName);
        System.out.printf("InputStreamReader Time: %.2fs\n\n", inputStreamReaderTime / 1_000_000_000.0);
        
        // Clean up
        file.delete();
    }
    
    private static void createTestFile(String fileName, int sizeMB) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            int charsPerMB = 1024 * 1024;
            String line = "This is a test line for file reading comparison.\n";
            int iterations = (charsPerMB * sizeMB) / line.length();
            
            for (int i = 0; i < iterations; i++) {
                writer.write(line);
            }
        }
    }
}
