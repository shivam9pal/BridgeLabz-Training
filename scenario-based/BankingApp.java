package week02.scenario;


class BankAccount {
    private String accountNumber;
    private double balance;

    // constructor
    BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    // deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Amount deposited: " + amount);
    }

    // withdraw method 
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance. Overdraft not allowed.");
            return;
        }
        balance -= amount;
        System.out.println("Amount withdrawn: " + amount);
    }

    // check balance
    public void checkBalance() {
        System.out.printf("Current Balance: %.2f%n", balance);
    }
}

public class BankingApp {

	public static void main(String[] args) {
		BankAccount account = new BankAccount("ACC101", 5000);

        account.checkBalance();
        account.deposit(2000);
        account.withdraw(1000);
        account.withdraw(7000); // overdraft case
        account.checkBalance();

	}

}
