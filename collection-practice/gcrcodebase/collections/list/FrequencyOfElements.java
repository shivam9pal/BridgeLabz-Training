package week04.gcrcodebase.collections.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FrequencyOfElements {
	//
	static Map<String, Integer> findFrequency(List<String> list) {
		//to store 
        Map<String, Integer> map = new HashMap<>();

        for (String item : list) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> result = findFrequency(words);
        System.out.println(result);
    }
}
