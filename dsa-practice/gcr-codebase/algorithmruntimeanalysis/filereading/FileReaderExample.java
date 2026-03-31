package week3.dsa.algorithmruntimeanalysis.filereading;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    
    // Character stream - reads character by character, slower for binary files
    public static long readFile(String filePath) throws IOException {
        long startTime = System.nanoTime();
        
        try (FileReader reader = new FileReader(filePath)) {
            while (reader.read() != -1) {
                // Read character by character
            }
        }
        
        return System.nanoTime() - startTime;
    }
}
