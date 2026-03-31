package week03.scenariobased.bankaccounthierarchy;

class SavingAccount extends BankAccount {

	public SavingAccount(String accountNumber, double balance) {
		super(accountNumber, balance);
		
	}
	
	 @Override
	    double calculateFee() {
	        
	        return getBalance() * 0.005;
	    }
}
