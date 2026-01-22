package week04.gcrcodebase.collections.set;

import java.util.*;

public class SetToSortedList {

    static List<Integer> convertAndSort(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set); 
        // convert Set to List
        Collections.sort(list);                    
        // sort in ascending order
        return list;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        List<Integer> sortedList = convertAndSort(set);
        System.out.println(sortedList);  	
    }
}

