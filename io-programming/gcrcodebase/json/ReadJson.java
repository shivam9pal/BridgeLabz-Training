package week05.gcrcodebase.json;
import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson {
	public static void main(String[] args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode node = mapper.readTree(new File("user.json"));
		
		String name = node.get("name").asText();
		String email = node.get("email").asText();
		
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
	}
}
