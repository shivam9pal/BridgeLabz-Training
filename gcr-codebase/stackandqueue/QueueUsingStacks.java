package week03.gcrcodebase.stackandqueue;

import java.util.Stack;

class QueueUsingStacks {
	Stack<Integer> s1=new Stack<>();
	Stack<Integer> s2=new Stack<>();
	
	//enque operation
	void enque(int x) {
		s1.push(x);
		System.out.printf("Enqued :%d\n",x);
	}
	
	//dequeue operation
	int dequeue() {
		if(s2.isEmpty()) {
			if(s1.isEmpty()) {
				throw new RuntimeException("Queue is Empty");
			}
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	
	
	public static void main(String[] args) {
		QueueUsingStacks q=new QueueUsingStacks();
		q.enque(10);
        q.enque(20);
        q.enque(30);

        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());

        q.enque(40);

        System.out.println("Dequeued: " + q.dequeue());
	}
}
