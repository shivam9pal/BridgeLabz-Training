package week_4;
import java.util.*;
public class IntersectionofTwoArrays_349 {
	public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }

        return result;
    }
	public static void main(String[] args) {
		IntersectionofTwoArrays_349 obj = new IntersectionofTwoArrays_349();
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		int[] result = obj.intersection(nums1, nums2);
		System.out.println(Arrays.toString(result));
	}
}
