package week02.gcrcodebase.leetcode;

public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
        int n=nums.length;
        int cn=0;
        int[] copy=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]!=val){
                nums[cn]=nums[i];
                cn++;
            }
            
        }
        return cn;   
    }

	public static void main(String[] args) {
		
		int[]nums = {3,2,2,3};
		int val=2;
		
		System.out.println(removeElement(nums,val));
		
	}

}
