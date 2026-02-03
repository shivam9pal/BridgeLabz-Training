package week05.gcrcodebase.json;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJson {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        String json1 = "{\"name\":\"Aryan\"}";
        String json2 = "{\"age\":22}";

        JsonNode node1 = mapper.readTree(json1);
        JsonNode node2 = mapper.readTree(json2);

        ((ObjectNode) node1).setAll((ObjectNode) node2);

        System.out.println(node1.toPrettyString());
    }
}
