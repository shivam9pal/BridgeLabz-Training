package week05.gcrcodebase.json;
import com.fasterxml.jackson.databind.*;

public class FilterUsers {
	public static void main(String[] args) throws Exception {
		String json = "[{\"name\":\"A\",\"age\":20},{\"name\":\"B\",\"age\":30},{\"name\":\"C\",\"age\":40}]";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode array = mapper.readTree(json);
		
		for(JsonNode user : array) {
			if(user.get("age").asInt() > 25) {
				System.out.println(user.get("name").asText());
			}
		}
	}
}
