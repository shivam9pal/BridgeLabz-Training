package week01.leetcode;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int right=0;
        int left=0;
        int index=0;
        int[] result=new int[m+n];
        while(left<m && right<n){
            if(nums1[left]<=nums2[right]){
               result[index++]=nums1[left++];
            }
            else{
                result[index++]=nums2[right++];
            }
        }
        while(left<m){
            result[index++]=nums1[left++];
        }
        while(right<n){
            result[index++]=nums2[right++];
        }
        
        for (int i=0;i<(n+m);i++){
            if(i<m){
                nums1[i]=result[i];
            }else{
                nums1[i]=result[i];
            }
        }
        
    }
    
    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();
        
      
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.print("Merged array 1: ");
        for(int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();
        
    }

}
