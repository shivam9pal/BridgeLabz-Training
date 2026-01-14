package week03.gcrcodebase.stackandqueue;

import java.util.HashSet;
import java.util.Set;

class PairWithGivenSum {
	static boolean hasPair(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(target - num)) {
                System.out.println("Pair found: " + num + " + " + (target - num));
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;

        if (!hasPair(arr, target)) {
            System.out.println("No pair found");
        }
    }
}
