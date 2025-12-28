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
}
