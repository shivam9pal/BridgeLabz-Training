package week02.gcrCodebase.classObject;

public class BankAccount {
	private String accountHolder;
    private int accountNumber;
    private double balance;
    //Deposit function
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
    //Withdrwal function
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdraw amount is : " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    //Balnance info
    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.balance = 700;
       
        acc.displayBalance();
        acc.deposit(200);
        acc.displayBalance();
        acc.withdraw(100);
        acc.displayBalance();
        acc.withdraw(1000);
    }

}
