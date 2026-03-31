package week02.scenario.bankingsystem;


//transcetion 
interface BankingService {
	void transfer(Account to,Account from,double amount);
}
