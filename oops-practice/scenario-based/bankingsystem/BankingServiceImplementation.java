package week02.scenario.bankingsystem;

public class BankingServiceImplementation implements BankingService{

	@Override
	public void transfer(Account to, Account from, double amount) {
		synchronized(this) {
			try {
				from.withdraw(amount);
				to.deposit(amount);
				
				//adding to the history
				from.transcetion.add("Transferred ₹" + amount + " to " + to.acoountHolder);
                to.transcetion.add("Received ₹" + amount + " from " + from.acoountHolder);
                
                System.out.println("Transfer Successful: ₹" + amount);
			}catch(InsufficientBalanceException e) {
				System.out.println("transfer failed !"+e.getMessage());
			}
		}
		
		
	}

}
