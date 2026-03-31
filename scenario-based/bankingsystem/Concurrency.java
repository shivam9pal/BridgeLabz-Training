package week02.scenario.bankingsystem;

class Concurrency extends Thread {
	//
	BankingService service;
	Account to;
	Account from; 
	double amount;
	//
	public Concurrency(BankingService service,Account to,Account from,double amount ) {
		this.service=service;
		this.to=to;
		this.from=from;
		this.amount=amount;
	}
	
	@Override
	public void run() {
		service.transfer(to, from, amount);//running the transfer method under synchronization
	}
}
