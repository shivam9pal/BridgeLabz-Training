package week3.dsa.algorithmruntimeanalysis.searchcomparison;

public class LinearSearch {
    
    // O(N) - scans each element until target is found
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
