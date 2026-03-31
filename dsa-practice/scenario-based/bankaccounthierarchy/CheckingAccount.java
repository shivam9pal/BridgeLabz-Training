package week03.scenariobased.bankaccounthierarchy;

class CheckingAccount extends BankAccount {
	public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    double calculateFee() {
        
        return getBalance() < 1000 ? 1.0 : 0.0;
    }
}
