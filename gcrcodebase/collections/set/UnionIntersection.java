package week04.gcrcodebase.collections.set;

import java.util.*;

public class UnionIntersection {

    static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);   
        // adds all elements of set2
        return result;
    }

    static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2); 
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> uni = union(set1, set2);
        Set<Integer> inter = intersection(set1, set2);

        System.out.println("Union: " + uni);         
        System.out.println("Intersection: " + inter);
}

