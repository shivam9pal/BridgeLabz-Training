package week08.gcrcodebase.bankingsystem;

import java.time.LocalDateTime;

class Transaction implements Runnable{
	private final BankAccount account;
	
	private final String customerName;
	
	private final int amount;
	
	public Transaction(BankAccount account, String customerName, int amount) {
		this.account=account;
		this.customerName=customerName;
		this.amount=amount;
	}
	
	public void run() {
		System.out.println("[" + Thread.currentThread().getName() +
                "] State before processing: " +
                Thread.currentThread().getState());

        System.out.println("[" + customerName +
                "] Attempting to withdraw " + amount);
        boolean success=account.withdraw(amount);
        
        if (success) {
            System.out.println("Transaction successful: " +
                    customerName +
                    ", Amount: " + amount +
                    ", Balance: " + account.getBalance() +
                    ", Time: " + LocalDateTime.now());
        } else {
            System.out.println("Transaction failed: " +
                    customerName +
                    ", Amount: " + amount +
                    ", Balance: " + account.getBalance() +
                    ", Time: " + LocalDateTime.now());
        }
	}
}
