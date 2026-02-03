package week05.gcrcodebase.json;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

class Record {
    public int id;
    public String name;

    Record(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class JsonReport {

    public static void main(String[] args) throws Exception {

        List<Record> records = Arrays.asList(
                new Record(1, "User1"),
                new Record(2, "User2")
        );

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(records);

        System.out.println(json);
    }
}
