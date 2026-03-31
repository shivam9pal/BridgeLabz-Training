package week02.scenario.digitalwalletsystem;

public class WalletTransfer implements TransferService {

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

        // Add to receiver (only the transfer amount, fee is kept by system)
        receiverWallet.receiveFunds(amount);

        System.out.println("✓ Wallet-to-Wallet transfer successful!");
        System.out.println("  Transfer Fee: Rs." + String.format("%.2f", fee));
    }

    @Override
    public String getTransferMethod() {
        return "Wallet-to-Wallet";
    }

    @Override
    public double calculateTransactionFee(double amount) {
        // 1% transaction fee for wallet transfers
        return Math.max(amount * 0.01, 1.0); // Minimum Rs. 1
    }
}
