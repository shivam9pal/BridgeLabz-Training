package week02.scenario.bankingsystem;

class InsufficientBalanceException extends Exception{
	InsufficientBalanceException(String message){
		super(message);
	}
}
