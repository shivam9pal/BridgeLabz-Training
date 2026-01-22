package week04.gcrcodebase.collections.queue;

import java.util.*;

class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push element onto stack
    void push(int x) {
        
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        
        q1.add(x);

        // Move everything back to q1
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    // Pop element from stack
    int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.remove();
    }

    // Get top element
    int top() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.peek();
    }
}

public class StackUsingQueue {
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop()); 
        System.out.println(stack.top()); 
    }
}
