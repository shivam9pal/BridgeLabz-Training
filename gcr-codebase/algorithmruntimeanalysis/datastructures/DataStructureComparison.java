package week3.dsa.algorithmruntimeanalysis.datastructures;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class DataStructureComparison {
    
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 100000, 1000000};
        
        System.out.println("Data Structure Search Performance Comparison");
        
        for (int size : datasetSizes) {
            compareDataStructures(size);
        }
    }
    
    private static void compareDataStructures(int size) {
        // Generate random dataset
        int[] data = generateRandomArray(size);
        int target = data[new Random().nextInt(size)];
        
        System.out.printf("Dataset Size: %,d\n", size);
        
        // Array Search O(N)
        long startTime = System.nanoTime();
        ArraySearch.search(data, target);
        long arrayTime = System.nanoTime() - startTime;
        System.out.printf("Array Search O(N): %.2fms\n", arrayTime / 1_000_000.0);
        
        // HashSet Search O(1)
        HashSet<Integer> hashSet = HashSetSearch.createHashSet(data);
        startTime = System.nanoTime();
        HashSetSearch.search(hashSet, target);
        long hashSetTime = System.nanoTime() - startTime;
        System.out.printf("HashSet Search O(1): %.2fms\n", hashSetTime / 1_000_000.0);
        
        // TreeSet Search O(log N)
        TreeSet<Integer> treeSet = TreeSetSearch.createTreeSet(data);
        startTime = System.nanoTime();
        TreeSetSearch.search(treeSet, target);
        long treeSetTime = System.nanoTime() - startTime;
        System.out.printf("TreeSet Search O(log N): %.2fms\n\n", treeSetTime / 1_000_000.0);
    }
    
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 10);
        }
        return arr;
    }
}
