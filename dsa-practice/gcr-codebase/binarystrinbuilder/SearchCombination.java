package week03.gcrcodebase.binarystrinbuilder;

import java.util.*;

class SearchCombination {

    // Linear Search approach for first missing positive
    static int firstMissingPositive(int[] arr) {
        int n = arr.length;

        // Step 1: Mark numbers in range [1, n]
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }

        // Step 2: Find first index where value != index + 1
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // Binary Search for target index (array must be sorted)
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

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

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 4;

        // Copy for missing positive logic
        int[] copy = nums.clone();
        int missing = firstMissingPositive(copy);
        System.out.println("First Missing Positive: " + missing);

        // Sort for Binary Search
        Arrays.sort(nums);
        int index = binarySearch(nums, target);

        System.out.println("Sorted Array: " + Arrays.toString(nums));
        System.out.println("Index of " + target + ": " + index);
    }
}

