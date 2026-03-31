package week02.gcrcodebase.leetcode;

public class SingleNumber {
	public static int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                
                if(i==j){
                    continue;
                }
                if(nums[i]==nums[j]){
                    continue;
                }else{
                    count++;
                }
            }
            if(nums.length-1==count){
                result=nums[i];
                break;
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums= {2,2,1};
		System.out.println(singleNumber(nums));
	}
}
