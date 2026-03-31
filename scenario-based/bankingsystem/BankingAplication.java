package week02.scenario.bankingsystem;

public class BankingAplication {

	public static void main(String[] args)  {
		
		//Creating account 
		Account account1=new SavingAccount(101, "Shivam", 5000);
		Account account2 = new CurrentAccount(102, "Amit", 3000);
		
		//crating object of banking service implementation to use transfer 
		BankingService service = new BankingServiceImplementation();
		//now creating to thread to process concurrent transection
		
		Thread t1=new Concurrency(service,account1,account2,1000);
		Thread t2=new Concurrency(service,account1,account2,2000);
		
		//now starting 
		t1.start();
		t2.start();
		
		try {
			 t1.join();
	         t2.join();
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		account1.deposit(10000);
		account2.withdraw(2000);
		
		
		//balance check
		System.out.println(account1.acoountHolder + ": ₹" + account1.getBalance());
		System.out.println(account2.acoountHolder + ": ₹" + account2.getBalance());
		
		//Calculation
        System.out.println("Interest:");
        System.out.println("Savings Interest: ₹" + account1.calculateInterest());
        System.out.println("Current Interest: ₹" + account2.calculateInterest());
        
     // Transaction History
        System.out.println();
        account1.showTransactions();
        System.out.println();
        account2.showTransactions();
		

	}

}
