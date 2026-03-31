package week02.scenario.ecommerceplatform;

public class WalletPayment implements Payment {

    private String walletId;
    private double balance;

    public WalletPayment(String walletId, double initialBalance) {
        this.walletId = walletId;
        this.balance = initialBalance;
    }

    @Override
    public boolean processPayment(double amount) throws PaymentFailedException {
        // Validate wallet balance
        if (balance < amount) {
            throw new PaymentFailedException("Insufficient wallet balance! Available: Rs." + String.format("%.2f", balance));
        }

        // Process payment
        System.out.println("Processing wallet payment of Rs." + String.format("%.2f", amount) + " from wallet: " + walletId);
        balance -= amount;
        System.out.println("✓ Wallet payment successful! Remaining balance: Rs." + String.format("%.2f", balance));
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Digital Wallet";
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        balance += amount;
    }
}
