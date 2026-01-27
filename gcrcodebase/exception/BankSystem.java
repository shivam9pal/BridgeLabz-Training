package week04.gcrcodebase.exception;

//Custom Exception
class InsufficientBalanceException extends Exception {
 public InsufficientBalanceException(String message) {
     super(message);
 }
}

class BankAccount {
 private double balance;

 BankAccount(double balance) {
     this.balance = balance;
 }

 // Withdraw method
 void withdraw(double amount) throws InsufficientBalanceException {
     if (amount < 0) {
         throw new IllegalArgumentException("Invalid amount!");
     }

     if (amount > balance) {
         throw new InsufficientBalanceException("Insufficient balance!");
     }

     balance -= amount;
     System.out.println("Withdrawal successful, new balance: " + balance);
 }
}

public class BankSystem {

 public static void main(String[] args) {

     BankAccount account = new BankAccount(5000);

     try {
         account.withdraw(2000);   // change value to test cases

     } catch (InsufficientBalanceException e) {
         System.out.println("Insufficient balance!");

     } catch (IllegalArgumentException e) {
         System.out.println("Invalid amount!");
     }
 }
}

