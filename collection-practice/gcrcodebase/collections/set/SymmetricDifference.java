package week04.gcrcodebase.collections.set;

import java.util.*;

public class SymmetricDifference {

    static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        // union
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);

        // intersection
        Set<Integer> common = new HashSet<>(set1);
        common.retainAll(set2);

        // remove common elements from union
        result.removeAll(common);

        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> output = symmetricDifference(set1, set2);
        System.out.println(output); 
    }
}

