package week05.gcrcodebase.json;

import com.fasterxml.jackson.databind.*;

public class FilterJson {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        String json = "[{\"name\":\"A\",\"age\":20},{\"name\":\"B\",\"age\":30},{\"name\":\"C\",\"age\":40}]";

        JsonNode array = mapper.readTree(json);

        for (JsonNode person : array) {
            if (person.get("age").asInt() > 25) {
                System.out.println(person.get("name").asText());
            }
        }
    }
}
