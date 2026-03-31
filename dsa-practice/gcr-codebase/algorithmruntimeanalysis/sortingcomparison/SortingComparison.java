package week3.dsa.algorithmruntimeanalysis.sortingcomparison;

import java.util.Random;

public class SortingComparison {
    
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        
        System.out.println("Sorting Algorithm Performance Comparison");
        
        for (int size : datasetSizes) {
            compareSortingPerformance(size);
        }
    }
    
    private static void compareSortingPerformance(int size) {
        int[] originalData = generateRandomArray(size);
        
        System.out.printf("Dataset Size: %,d\n", size);
        
        // Bubble Sort (skip for very large datasets)
        if (size <= 10000) {
            int[] data1 = originalData.clone();
            long startTime = System.nanoTime();
            BubbleSort.sort(data1);
            long bubbleTime = System.nanoTime() - startTime;
            System.out.printf("Bubble Sort: %.2fms\n", bubbleTime / 1_000_000.0);
        } else {
            System.out.println("Bubble Sort: Unfeasible (>1hr)");
        }
        
        // Merge Sort
        int[] data2 = originalData.clone();
        long startTime = System.nanoTime();
        MergeSort.sort(data2);
        long mergeTime = System.nanoTime() - startTime;
        System.out.printf("Merge Sort: %.2fms\n", mergeTime / 1_000_000.0);
        
        // Quick Sort
        int[] data3 = originalData.clone();
        startTime = System.nanoTime();
        QuickSort.sort(data3);
        long quickTime = System.nanoTime() - startTime;
        System.out.printf("Quick Sort: %.2fms\n\n", quickTime / 1_000_000.0);
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
