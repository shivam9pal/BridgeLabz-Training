package week05.gcrcodebase.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;



class Student {
    public int id;
    public String name;
    public int age;
    public int marks;
}

class CsvToJson {

    public static void main(String[] args) throws Exception {

        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {

            br.readLine(); // skip header
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                Student s = new Student();
                s.id = Integer.parseInt(data[0]);
                s.name = data[1];
                s.age = Integer.parseInt(data[2]);
                s.marks = Integer.parseInt(data[3]);

                students.add(s);
            }
        }

        // Write JSON
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(new File("students_from_csv.json"), students);

        System.out.println("CSV converted to JSON successfully.");
    }
}

