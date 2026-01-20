package week3.dsa.algorithmruntimeanalysis.searchcomparison;

import java.util.Arrays;

public class BinarySearch {
    
    // O(log N) - requires sorted array
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    // O(N log N) - sorting time
    public static void sort(int[] arr) {
        Arrays.sort(arr);
    }
}
