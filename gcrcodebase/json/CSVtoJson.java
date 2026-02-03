package week05.gcrcodebase.json;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.*;
public class CSVtoJson {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("data.csv"));
		String line;
		List<Map<String, String>> list = new ArrayList<>();
		
		String[] headers = br.readLine().split(",");
		
		while((line = br.readLine()) != null) {
			String[] values = line.split(",");
			Map<String, String> map = new HashMap<>();
			
			for(int i = 0; i < headers.length; i++) {
				map.put(headers[i], values[i]);
			}
			list.add(map);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(list));
		br.close();
	}
}
