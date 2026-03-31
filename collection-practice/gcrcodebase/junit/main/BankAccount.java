package JUnit_demo.JUnit;



 class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}


 public class BankAccount {

	    private double balance;

	    public BankAccount(double initialBalance) {
	        this.balance = initialBalance;
	    }

	    public void deposit(double amount) {
	        if (amount <= 0) {
	            throw new IllegalArgumentException("Invalid deposit amount");
	        }
	        balance += amount;
	    }

	    public void withdraw(double amount) throws InsufficientFundsException {
	        if (amount <= 0) {
	            throw new IllegalArgumentException("Invalid withdrawal amount");
	        }
	        if (amount > balance) {
	            throw new InsufficientFundsException("Insufficient funds");
	        }
	        balance -= amount;
	    }

	    public double getBalance() {
	        return balance;
	    }
	}
