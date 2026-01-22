package week04.gcrcodebase.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RotateList {
	static void rotate(List<Integer> list, int k) {
        int n = list.size();
     // in case k is bigger than list size
        k = k % n;  

        for (int i = 0; i < k; i++) {
            int first = list.get(0);   
            list.remove(0);            
            list.add(first);           
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

        rotate(nums, 2);
        System.out.println(nums);  // [30, 40, 50, 10, 20]
    }
}
