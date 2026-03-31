package week01.leetcode;

class RemovesDuplicate {
    public int removeDuplicate(int[] nums) {
        int i = 0; 
        //Checking repeated Value and leaving it 
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; 
            }
        }

        return i + 1;
    }
    
    public static void main(String[] args) {
        RemovesDuplicate solution = new RemovesDuplicate();
        
        // Test 
        int[] nums1 = {1, 1, 2};
        int result1 = solution.removeDuplicate(nums1);
        System.out.print("After removing duplicates from [1, 1, 2], length: " + result1 + ", Array: ");
        for(int i = 0; i < result1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();
        
        
    }
}
