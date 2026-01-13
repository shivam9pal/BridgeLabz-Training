package week02.scenario.digitalwalletsystem;

public class BankTransfer implements TransferService {

    @Override
    public void transferFunds(Wallet senderWallet, Wallet receiverWallet, double amount)
            throws InsufficientBalanceException, Exception {

        if (senderWallet == null || receiverWallet == null) {
            throw new Exception("Invalid wallet!");
        }

        double fee = calculateTransactionFee(amount);
        double totalAmount = amount + fee;

        // Deduct from sender
        senderWallet.transferFunds(totalAmount);

        // Add to receiver (only the transfer amount)
        receiverWallet.receiveFunds(amount);

        System.out.println("✓ Bank transfer successful!");
        System.out.println("  Transfer Fee: Rs." + String.format("%.2f", fee));
    }

    @Override
    public String getTransferMethod() {
        return "Bank Transfer";
    }

    @Override
    public double calculateTransactionFee(double amount) {
        // 2% transaction fee for bank transfers + Rs. 5 fixed charge
        return (amount * 0.02) + 5.0;
    }
}
