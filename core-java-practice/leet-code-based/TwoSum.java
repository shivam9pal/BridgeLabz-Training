package week01.leetcode;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if( nums[i]+nums[j]==target){
                return new int[]{i,j};
                }
            }
        }
        return  new int[]{};
    }
    
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Two Sum for [2, 7, 11, 15] with target 9: [" + result1[0] + ", " + result1[1] + "]");
        
    }
}
