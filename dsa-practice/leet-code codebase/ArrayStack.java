package week03.gcrcodebase.leetcode;

class ArrayStack {

    static class Stack {
        int[] arr = new int[5];
        int top = -1;

        void push(int x) {
            if (top == arr.length - 1) {
                System.out.println("Stack Overflow");
                return;
            }
            arr[++top] = x;
        }

        int pop() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return arr[top--];
        }

        int peek() {
            return (top == -1) ? -1 : arr[top];
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}

