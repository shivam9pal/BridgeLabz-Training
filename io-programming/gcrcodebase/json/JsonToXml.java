package week05.gcrcodebase.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXml {

    public static void main(String[] args) throws Exception {

        String json = "{\"name\":\"Aryan\",\"age\":22,\"city\":\"Delhi\"}";

        ObjectMapper jsonMapper = new ObjectMapper();
        Object obj = jsonMapper.readValue(json, Object.class);

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(obj);

        System.out.println(xml);
    }
}
