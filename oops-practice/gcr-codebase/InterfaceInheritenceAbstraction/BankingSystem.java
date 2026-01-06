package week02.gcrcodebase.abstractinterface;

import java.util.ArrayList;
import java.util.List;

//interface
interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    // constructor
    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    // getters 
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getHolderName() {
        return holderName;
    }
    public double getBalance() {
        return balance;
    }

    // deposit method 
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // withdraw method 
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // abstract method
    public abstract double calculateInterest();

    // display details
    public void displayDetails() {
        System.out.printf("Account No   : %s%n", accountNumber);
        System.out.printf("Holder Name  : %s%n", holderName);
        System.out.printf("Balance      : %.2f%n", balance);
    }
}

class SavingsAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.04; 

    SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Applied: " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5; 
    }
}
class CurrentAccount extends BankAccount implements Loanable {

    private static final double INTEREST_RATE = 0.01; 

    CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Applied: " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 3; 
    }
}

public class BankingSystem {

	public static void main(String[] args) {
		List<BankAccount> accounts = new ArrayList<>();

        BankAccount acc1 =new SavingsAccount("SB101", "Shivam", 50000);

        BankAccount acc2 =new CurrentAccount("CA202", "Rahul", 80000);

        accounts.add(acc1);
        accounts.add(acc2);

        for (BankAccount acc : accounts) {

            acc.displayDetails();

            double interest = acc.calculateInterest();
            System.out.printf("Interest     : %.2f%n", interest);

            if (acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                System.out.printf("Loan Eligible: %.2f%n",
                        loan.calculateLoanEligibility());
            }

            System.out.println();
        }

	}

}
