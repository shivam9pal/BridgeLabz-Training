package week04.gcrcodebase.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class ReverseList {
	 // reverse for ArrayList
    public static <T> void reverseArrayList(ArrayList<T> list) {
    	int left =0;
    	int right=list.size()-1;
    	
    	while(left<right) {
    		T temp=list.get(left);
    		list.set(left, list.get(right));
    		list.set(right, temp);
    		
    		left++;
    		right--;
    		}
    }

    // reverse for LinkedList
    public static <T> void reverseLinkedList(LinkedList<T> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        reverseArrayList(arrayList);
        reverseLinkedList(linkedList);

        System.out.println("Reversed ArrayList: " + arrayList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
