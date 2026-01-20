package week3.dsa.algorithmruntimeanalysis.datastructures;

import java.util.TreeSet;

public class TreeSetSearch {
    
    // O(log N) - balanced BST for ordered data
    public static boolean search(TreeSet<Integer> set, int target) {
        return set.contains(target);
    }
    
    public static TreeSet<Integer> createTreeSet(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) {
            set.add(num);
        }
        return set;
    }
}
