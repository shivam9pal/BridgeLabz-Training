package week02.gcrcodebase.leetcode;

public class SearchInsertPosition {
	 public static int searchInsert(int[] nums, int target) {
	        int strt=0;
	        int end=nums.length-1;
	        int mid=0;
	        while(strt<=end){
	            mid=strt+(end-strt)/2;
	            if(target==nums[mid])return mid;
	            else if(target>nums[mid])strt=mid+1;
	            else{ end=mid-1;}
	        }
	        return strt;
	    }
	 
	 public static void main(String[] args) {
		 int[] nums= {1,3,5,6};
		 int target=5;
		 System.out.println(searchInsert(nums,target));
	 }
}
