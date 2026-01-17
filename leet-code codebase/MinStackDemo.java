package week03.gcrcodebase.leetcode;

import java.util.*;

class MinStackDemo {

    static class MinStack {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> min = new Stack<>();

        void push(int x) {
            st.push(x);
            if (min.isEmpty() || x <= min.peek()) {
                min.push(x);
            }
        }

        void pop() {
            if (st.pop().equals(min.peek())) {
                min.pop();
            }
        }

        int top() {
            return st.peek();
        }

        int getMin() {
            return min.peek();
        }
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(2);
        ms.push(8);

        System.out.println("Min: " + ms.getMin());
        ms.pop();
        ms.pop();
        System.out.println("Min: " + ms.getMin());
    }
}

