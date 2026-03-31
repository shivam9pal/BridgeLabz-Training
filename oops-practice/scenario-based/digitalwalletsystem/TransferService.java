package week02.scenario.digitalwalletsystem;

public interface TransferService {

    void transferFunds(Wallet senderWallet, Wallet receiverWallet, double amount) throws InsufficientBalanceException, Exception;

    String getTransferMethod();

    double calculateTransactionFee(double amount);
}
