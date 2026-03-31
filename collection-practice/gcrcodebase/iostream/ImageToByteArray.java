package week04.gcrcodebase.iostreams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class ImageToByteArray {

    public static void main(String[] args) {

        String inputImage = "input.jpg";
        String outputImage = "output.jpg";

        try {
            //Read image into byte array using streams
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            try (FileInputStream fis = new FileInputStream(inputImage)) {
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = fis.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesRead);
                }
            }

            byte[] imageBytes = baos.toByteArray();

            //Write byte array back to a new image
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(outputImage)) {

                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

            //Verify both files are identical
            byte[] original = Files.readAllBytes(new File(inputImage).toPath());
            byte[] copied = Files.readAllBytes(new File(outputImage).toPath());

            if (Arrays.equals(original, copied)) {
                System.out.println("Success: The new image is identical to the original.");
            } else {
                System.out.println("The files are different.");
            }

        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}

