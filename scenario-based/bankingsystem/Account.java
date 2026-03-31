package week02.scenario.bankingsystem;

import java.util.ArrayList;
import java.util.List;

abstract class Account {
	int accountNumber;
	String acoountHolder;
	double balance;
	List<String> transcetion=new ArrayList<>();
	
	//
	public Account(int accountNumber,String accountHolder,double balance) {
		this.balance=balance;
		this.accountNumber=accountNumber;
		this.acoountHolder=accountHolder;
	}
	
	//withdraw function with synchronized to make thread safe 
	public synchronized void withdraw(double amount)throws InsufficientBalanceException {
		//checking balance availability
		if(amount>balance) {
			throw new InsufficientBalanceException("The account doesnt have enough balance !!");
		}else {
			balance-=amount;
			//adding in the transcetion history
			transcetion.add("Withdrawn: ₹" + amount);
		}
	}
	
	//deposit function with synchronized to make thread safe 
	public synchronized void deposit(double amount) {
		balance+=amount;
		//adding to history
		transcetion.add("Deposited: ₹" + amount);
	}

	
	//get balnce
	public double getBalance() {
		return balance;
	}
	
	public void showTransactions() {
		for(String s:transcetion) {
			System.out.println(s);
		}
	}
	
	
	//now abstract method
	abstract double calculateInterest();
	
}
