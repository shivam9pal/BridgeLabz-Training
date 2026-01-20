package week3.dsa.algorithmruntimeanalysis.searchcomparison;

import java.util.Random;

public class SearchComparison {
    
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        
        System.out.println("Search Algorithm Performance Comparison");
        
        for (int size : datasetSizes) {
            compareSearchPerformance(size);
        }
    }
    
    private static void compareSearchPerformance(int size) {
        // Generate random dataset
        int[] data = generateRandomArray(size);
        int target = data[new Random().nextInt(size)];
        
        // Linear Search
        long startTime = System.nanoTime();
        LinearSearch.search(data, target);
        long linearTime = System.nanoTime() - startTime;
        
        // Binary Search (including sorting time)
        int[] sortedData = data.clone();
        startTime = System.nanoTime();
        BinarySearch.sort(sortedData);
        BinarySearch.search(sortedData, target);
        long binaryTime = System.nanoTime() - startTime;
        
        System.out.printf("Dataset Size: %,d\n", size);
        System.out.printf("Linear Search: %.2fms\n", linearTime / 1_000_000.0);
        System.out.printf("Binary Search (with sorting): %.2fms\n\n", binaryTime / 1_000_000.0);
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
