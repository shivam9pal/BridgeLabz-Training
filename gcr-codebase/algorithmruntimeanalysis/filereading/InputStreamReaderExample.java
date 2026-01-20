package week3.dsa.algorithmruntimeanalysis.filereading;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderExample {
    
    // Byte stream - reads bytes and converts to characters, more efficient
    public static long readFile(String filePath) throws IOException {
        long startTime = System.nanoTime();
        
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            while (reader.read() != -1) {
                // Read and convert bytes to characters
            }
        }
        
        return System.nanoTime() - startTime;
    }
}
