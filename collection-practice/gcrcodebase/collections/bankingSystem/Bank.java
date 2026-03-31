package week04.gcrcodebase.collections.bankingSystem;

class Bank {
	public static void main(String[] args) {

        BankingSystem bank = new BankingSystem();

        bank.addAccount(101, 5000);
        bank.addAccount(102, 2000);
        bank.addAccount(103, 8000);

        bank.requestWithdrawal(101, 1000);
        bank.requestWithdrawal(102, 2500);
        bank.requestWithdrawal(103, 3000);

        bank.processWithdrawals();
        bank.displaySortedByBalance();
    }
}
