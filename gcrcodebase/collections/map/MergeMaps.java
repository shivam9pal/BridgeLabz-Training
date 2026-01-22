package week04.gcrcodebase.collections.map;

import java.util.*;

public class MergeMaps {

    static Map<String, Integer> merge(Map<String, Integer> map1,
                                      Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();

        // all from map1
        for (String key : map1.keySet()) {
            result.put(key, map1.get(key));
        }

        // merge map2
        for (String key : map2.keySet()) {
            if (result.containsKey(key)) {
                result.put(key, result.get(key) + map2.get(key));
            } else {
                result.put(key, map2.get(key));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> merged = merge(map1, map2);
        System.out.println(merged);  
    }
}

