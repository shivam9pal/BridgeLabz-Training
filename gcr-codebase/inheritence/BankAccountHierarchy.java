package week02.gcrcodebase.inheritence;

// Superclass
class BankAccount {
    int accountNumber;
    double balance;
    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayAccountType() {
        System.out.println("Bank Account");
    }
}

//  subclass
class SavingsAccount extends BankAccount {
    double interestRate;
    SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    void displayAccountType() {
        System.out.println("Savings Account -> Account Number: " + accountNumber + ", Balance: " + balance + ", Interest Rate: " + interestRate + "%");
    }
}

// CheckingAccount subclass
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(int accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    void displayAccountType() {
        System.out.println("Checking Account -> Account Number: " + accountNumber + ", Balance: " + balance + ", Withdrawal Limit: " + withdrawalLimit);
    }
}

// subclass
class FixedDepositAccount extends BankAccount {
    int tenureInMonths;

    FixedDepositAccount(int accountNumber, double balance, int tenureInMonths) {
        super(accountNumber, balance);
        this.tenureInMonths = tenureInMonths;
    }

    @Override
    void displayAccountType() {
        System.out.println("Fixed Deposit Account -> Account Number: " + accountNumber + ", Balance: " + balance + ", Tenure: " + tenureInMonths + " months");
    }
}


public class BankAccountHierarchy {

    public static void main(String[] args) {
        BankAccount a1 = new SavingsAccount(1001, 50000, 4.5);
        BankAccount a2 = new CheckingAccount(1002, 30000, 10000);
        BankAccount a3 = new FixedDepositAccount(1003, 200000, 24);

        a1.displayAccountType();
        a2.displayAccountType();
        a3.displayAccountType();
    }
}
