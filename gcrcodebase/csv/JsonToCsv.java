package week05.gcrcodebase.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jdk.internal.org.objectweb.asm.TypeReference;


 class Student {
    public int id;
    public String name;
    public int age;
    public int marks;
}

public class JsonToCsv {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        // Read JSON file into List<Student>
        List<Student> students = mapper.readValue(
                new File("students.json"),
                new TypeReference<List<Student>>() {}
        );

        // Write to CSV
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("students.csv"))) {
            bw.write("ID,Name,Age,Marks");
            bw.newLine();

            for (Student s : students) {
                bw.write(s.id + "," + s.name + "," + s.age + "," + s.marks);
                bw.newLine();
            }
        }

        System.out.println("JSON converted to CSV successfully.");
    }
}

