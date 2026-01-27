package week04.gcrcodebase.iostreams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StudentBinaryFile {

    public static void main(String[] args) {

        String fileName = "students.dat";

        // Writing data to binary file
        try (DataOutputStream dos =
                     new DataOutputStream(new FileOutputStream(fileName))) {

            // Student 1
            dos.writeInt(1);              // roll number
            dos.writeUTF("Alice");        // name
            dos.writeDouble(3.8);         // GPA

            // Student 2
            dos.writeInt(2);
            dos.writeUTF("Bob");
            dos.writeDouble(3.5);

            System.out.println("Student data written to file.");

        } catch (IOException e) {
            System.out.println("Write Error: " + e.getMessage());
        }

        // Reading data from binary file
        try (DataInputStream dis =
                     new DataInputStream(new FileInputStream(fileName))) {

            System.out.println("\nReading student data:");

            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll: " + roll +
                        ", Name: " + name +
                        ", GPA: " + gpa);
            }

        } catch (IOException e) {
            System.out.println("Read Error: " + e.getMessage());
        }
    }
}

