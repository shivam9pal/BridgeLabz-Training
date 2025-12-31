package week02.gcrCodebase.constructor;

class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    // methods for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}

// Subclass
public class SavingsAccount extends BankAccount {

    void showAccountDetails() {
    	// public
        System.out.println("Account No: " + accountNumber); 
        // protected
        System.out.println("Holder: " + accountHolder);   
     // private via method
        System.out.println("Balance: " + getBalance());     
    }

    public static void main(String[] args) {
        SavingsAccount s = new SavingsAccount();
        s.accountNumber = 12345;
        s.accountHolder = "Rohan";
        s.setBalance(25000);

        s.showAccountDetails();
    }
}

