package week02.gcrcodebase.leetcode;

import java.util.HashSet;

public class ContainDuplicate {
	public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num))
                return true;
            seen.add(num);
        }
        return false;
    }

	public static void main(String[] args) {
		int[] num= {1,1,1,3,3,4,3,2,4,2};
		boolean result=containsDuplicate(num);
		System.out.println(result);
	}

}
