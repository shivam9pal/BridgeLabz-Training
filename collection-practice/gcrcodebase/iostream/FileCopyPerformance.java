package week04.gcrcodebase.iostreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyPerformance {

    static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {
        String source = "bigfile.dat";  
        // e.g., 100MB file
        String normalDest = "copynormal.dat";
        String bufferedDest = "copybuffered.dat";

        copyWithNormalStreams(source, normalDest);
        copyWithBufferedStreams(source, bufferedDest);
    }

    static void copyWithNormalStreams(String src, String dest) {
        long start = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            long end = System.nanoTime();
            System.out.println("Normal Streams Time: " + (end - start) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error (Normal): " + e.getMessage());
        }
    }

    static void copyWithBufferedStreams(String src, String dest) {
        long start = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            long end = System.nanoTime();
            System.out.println("Buffered Streams Time: " + (end - start) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error (Buffered): " + e.getMessage());
        }
    }
}

