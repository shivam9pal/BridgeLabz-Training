package week05.gcrcodebase.json;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

class Student {
    public String name;
    public int age;
    public List<String> subjects;

    Student(String name, int age, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }
}

public class StudentJSON {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Student s = new Student(
                "Aryan",
                20,
                Arrays.asList("Math", "Java", "Physics")
        );

        String json = mapper.writeValueAsString(s);

        System.out.println(json);
    }
}

