package week02.gcrcodebase.leetcode;

public class MissingNumber {
	public static  int missingNumber(int[] nums) {
        int res = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            res += i - nums[i];
        }
        
        return res;       
    }
	
	public static void main(String[] args) {
		int[] nums= {3,0,1};
		int result=missingNumber(nums);
		System.out.println(result);
	}
}
