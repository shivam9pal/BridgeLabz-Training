package week08.gcrcodebase.bankingsystem;

class BankAccount {
	private int balance=10000;
	
	public int getBalance() {
		return balance;
	}
	
	public boolean withdraw(int amount) {
		if(amount<=balance) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			
			balance-=amount;
			return true;
		}
		return false;
	}
}
