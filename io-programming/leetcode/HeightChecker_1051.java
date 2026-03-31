package week_5;
import java.util.*;
public class HeightChecker_1051 {
	public int heightChecker(int[] heights) {
		int[] copy = Arrays.copyOf(heights, heights.length);
		Arrays.sort(copy);
		int count = 0;
		for (int i = 0; i < heights.length; i++) {
			if (heights[i] != copy[i]) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		HeightChecker_1051 obj = new HeightChecker_1051();
		int[] heights = { 1, 1, 4, 2, 1, 3 };
		System.out.println(obj.heightChecker(heights));
	}
}
