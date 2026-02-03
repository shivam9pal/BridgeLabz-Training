package week05.gcrcodebase.json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        String json = "{\"name\":\"Test\",\"age\":25}";

        try {
            mapper.readTree(json);
            System.out.println("Valid JSON");
        } catch (Exception e) {
            System.out.println("Invalid JSON");
        }
    }
}
