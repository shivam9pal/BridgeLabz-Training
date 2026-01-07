package week02.scenario.bankingsystem;

class SavingAccount extends Account {

	public SavingAccount(int accountNumber, String accountHolder, double balance) {
		super(accountNumber, accountHolder, balance);
		
	}

	@Override
	double calculateInterest() {
		return balance*0.9;
	}

}
