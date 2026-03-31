package week06.gcrcodebase.functionalinterface;

class BackgroundJobExecution {
	public static void main(String[] args) {
		System.out.println("Main thread is running...!");
		
		Runnable thread1=()->{
			System.out.println("Thread 1 is perfoming some operation..!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Task completed by thread 1");
		};
		
		Runnable thread2=()->{
			System.out.println("Thread 2 is running ..!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			System.out.println("Task completed by thread 2");
		};
		
		
		
		
		//now making thread object
		Thread t1=new Thread(thread1);
		Thread t2=new Thread(thread2);
		t1.start();
		t2.start();
		System.out.println("Main method finished...!");
	}
}
