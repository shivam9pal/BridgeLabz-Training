package week05.gcrcodebase.json;

import com.fasterxml.jackson.databind.ObjectMapper;

class Test {
    public String name = "Working!";
}

public class TestJackson {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(new Test()));
    }
}
