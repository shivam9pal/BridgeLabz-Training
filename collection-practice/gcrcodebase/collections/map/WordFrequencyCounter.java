package week04.gcrcodebase.collections.map;

import java.util.HashMap;
import java.util.Map;

class WordFrequencyCounter {
	public static Map<String,Integer> countWords(String str){
		Map<String,Integer> result=new HashMap<>();
		
		str=str.toLowerCase().replaceAll("[^a-z ]", "");
		
		String[] words=str.split("\\s+");
		
		for(String s:words) {
			if(result.containsKey(s)) {
				result.put(s , result.get(s)+1);
			}else {
				result.put(s, 1);
			}
		}
		
		return result;
	}
	
	
	 public static void main(String[] args) {
	        String input = "Hello world, hello Java!";

	        Map<String, Integer> result = countWords(input);
	        System.out.println(result);  
	    }
}
