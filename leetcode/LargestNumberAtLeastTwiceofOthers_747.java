package week_5;

public class LargestNumberAtLeastTwiceofOthers_747 {
	public int dominantIndex(int[] nums) {
		int max = -1;
		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
				index = i;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (i != index && nums[i] * 2 > max) {
				return -1;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		LargestNumberAtLeastTwiceofOthers_747 obj = new LargestNumberAtLeastTwiceofOthers_747();
		int[] nums = { 3, 6, 1, 0 };
		System.out.println(obj.dominantIndex(nums)); 
	}
}
