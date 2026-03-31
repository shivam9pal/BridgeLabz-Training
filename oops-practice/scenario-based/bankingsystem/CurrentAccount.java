package week02.scenario.bankingsystem;

class CurrentAccount extends Account{

	public CurrentAccount(int accountNumber, String accountHolder, double balance) {
		super(accountNumber, accountHolder, balance);
	}

	@Override
	double calculateInterest() {
		return balance*0.01;
	}

}
