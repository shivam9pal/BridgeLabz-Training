package week04.gcrcodebase.collections.list;

import java.util.*;

public class FromEnd {

    static String findNthFromEnd(LinkedList<String> list, int n) {
        Iterator<String> first = list.iterator();
        Iterator<String> second = list.iterator();

        // Move first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) {
                return null; 
                // n is larger than list size
            }
            first.next();
        }

       
        String result = null;
        while (first.hasNext()) {
            first.next();
            result = second.next();
        }

       
        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        String output = findNthFromEnd(list, 2);
        System.out.println(output); 
    }
}

