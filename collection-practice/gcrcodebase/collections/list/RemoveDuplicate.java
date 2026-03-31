package week04.gcrcodebase.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RemoveDuplicate {
	static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : list) {
            if (!seen.contains(num)) {
                seen.add(num);
                result.add(num);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 1, 2, 2, 3, 4);

        List<Integer> output = removeDuplicates(nums);
        System.out.println(output);  
    }
}
