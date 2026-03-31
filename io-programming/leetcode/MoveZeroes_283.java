package week_5;
public class MoveZeroes_283 {
	public void moveZeroes(int[] nums) {
		int index = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				int temp = nums[index];
				nums[index] = nums[i];
				nums[i] = temp;
				index++;
			}
		}
	}
	public static void main(String[] args) {
		MoveZeroes_283 obj = new MoveZeroes_283();
		int[] nums = {0, 1, 0, 3, 12};
		obj.moveZeroes(nums);
		for(int i =0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
