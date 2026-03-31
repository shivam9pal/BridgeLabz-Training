package week03.gcrcodebase.stackandqueue;

import java.util.Stack;

class SortStackRecursion {
	
	//
	static void sortStack(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			int temp=stack.pop();
			sortStack(stack);
			insertSorted(stack,temp);
		}
	}

	static void insertSorted(Stack<Integer> stack, int element) {
		if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        insertSorted(stack, element);
        stack.push(temp);
	}
	
	public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
