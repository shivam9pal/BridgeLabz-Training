package week3.dsa.algorithmruntimeanalysis.datastructures;

import java.util.HashSet;

public class HashSetSearch {
    
    // O(1) - uses hashing for constant time lookup
    public static boolean search(HashSet<Integer> set, int target) {
        return set.contains(target);
    }
    
    public static HashSet<Integer> createHashSet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        return set;
    }
}
