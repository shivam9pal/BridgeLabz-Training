package week3.dsa.algorithmruntimeanalysis.datastructures;

public class ArraySearch {
    
    // O(N) - linear search through array
    public static boolean search(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
