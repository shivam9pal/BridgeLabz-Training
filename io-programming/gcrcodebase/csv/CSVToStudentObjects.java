package week05.gcrcodebase.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



class Student {
    private String id;
    private String name;
    private int age;
    private int marks;

    public Student(String id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Marks=" + marks +
                '}';
    }
}

class CSVToStudentObjects {

    public static void main(String[] args) {

        String filePath = "students.csv";
        List<Student> students = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);

                Student student = new Student(id, name, age, marks);
                students.add(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print all student objects
        System.out.println("Student List:\n");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

