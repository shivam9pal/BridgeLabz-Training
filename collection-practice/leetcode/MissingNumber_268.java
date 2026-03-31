package week_4;

public class MissingNumber_268 {
	public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
        }
        int actualSum = (nums.length * (nums.length + 1))/2;
        int result = (actualSum - sum);
        return result;
    }
	public static void main(String[] args) {
		MissingNumber_268 obj = new MissingNumber_268();
		int[] nums = {3,0,1};
		System.out.println(obj.missingNumber(nums));
	}
}
