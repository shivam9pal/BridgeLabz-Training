package week05.gcrcodebase.json;
import java.io.File;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeFiles {
	public static void main(String[] args) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode n1 = mapper.readTree(new File("file1.json"));
		JsonNode n2 = mapper.readTree(new File("file2.json"));
		
		((ObjectNode) n1).setAll((ObjectNode) n2);
		
		System.out.println(n1.toPrettyString());
	}
}
