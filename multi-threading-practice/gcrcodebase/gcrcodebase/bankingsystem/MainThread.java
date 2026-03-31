package week08.gcrcodebase.bankingsystem;

class MainThread {
	public static void main(String[] args) {
		BankAccount account=new BankAccount();
		
		Thread t1=new Thread(new Transaction(account, "Customer-1", 3000),
                		"ATM-Thread-1"
					);
		Thread t2=new Thread(new Transaction(account, "Customer-2", 3000),
				"ATM-Thread-1"
				);
		Thread t3=new Thread(new Transaction(account, "Customer-3", 3000),
				"ATM-Thread-1"
				);
		Thread t4=new Thread(new Transaction(account, "Customer-4", 3000),
				"ATM-Thread-1"
				);
		
		 	System.out.println("Thread states before start:");
	        System.out.println(t1.getName() + ": " + t1.getState());
	        System.out.println(t2.getName() + ": " + t2.getState());
	        System.out.println(t3.getName() + ": " + t3.getState());
	        System.out.println(t4.getName() + ": " + t4.getState());
	        
	        t1.start();
	        t2.start();
	        t3.start();
	        t4.start();
	        
	}
}
