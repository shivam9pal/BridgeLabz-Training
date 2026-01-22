package week04.gcrcodebase.collections.map;

import java.util.*;

public class InvertMap {

    static <K, V> Map<V, List<K>> invert(Map<K, V> map) {
        Map<V, List<K>> result = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            
            if (!result.containsKey(value)) {
                result.put(value, new ArrayList<>());
            }

           
            result.get(value).add(key);
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 1);
        input.put("B", 2);
        input.put("C", 1);

        Map<Integer, List<String>> output = invert(input);
        System.out.println(output);  
    }
}

