package week04.gcrcodebase.annotation.exercise3;

import java.util.ArrayList;

public class Exercise3_SuppressWarnings {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Java");
        list.add("Annotations");
        list.add(100);

        for (Object item : list) {
            System.out.println(item);
        }
    }
}
