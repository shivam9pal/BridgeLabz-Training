package week04.gcrcodebase.collections.queue;

import java.util.*;

public class ReverseQueue {

    static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        // remove front element
        int front = queue.remove();

        // reverse remaining queue
        reverseQueue(queue);

        // add the removed element at the end
        queue.add(front);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);

        reverseQueue(q);
        System.out.println(q);  
    }
}

