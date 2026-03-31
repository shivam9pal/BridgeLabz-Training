package week05.gcrcodebase.json;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

class Person {
    public String name;
    public int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJson {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        List<Person> list = Arrays.asList(
                new Person("A", 20),
                new Person("B", 30)
        );

        String json = mapper.writeValueAsString(list);

        System.out.println(json);
    }
}
