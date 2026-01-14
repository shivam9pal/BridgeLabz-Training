package week03.gcrcodebase.stackandqueue;

import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence {
	static int longestSequence(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println("Longest Consecutive Sequence Length: "
                + longestSequence(nums));
    }
}
