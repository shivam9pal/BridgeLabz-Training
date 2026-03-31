package week02.scenario.digitalwalletsystem;

public class Wallet {

    private int walletId;
    private int userId;
    private double balance;
    private String walletType; // Premium, Standard, Basic
    private double totalMoneyAdded;
    private double totalMoneySpent;
    private int totalTransactions;
    private String lastTransactionDate;
    private boolean isLocked;

    public Wallet(int walletId, int userId) {
        this.walletId = walletId;
        this.userId = userId;
        this.balance = 0.0;
        this.walletType = "Standard";
        this.totalMoneyAdded = 0.0;
        this.totalMoneySpent = 0.0;
        this.totalTransactions = 0;
        this.lastTransactionDate = "None";
        this.isLocked = false;
    }

    public int getWalletId() {
        return walletId;
    }

    public int getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getWalletType() {
        return walletType;
    }

    public void setWalletType(String type) {
        this.walletType = type;
    }

    public double getTotalMoneyAdded() {
        return totalMoneyAdded;
    }

    public double getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public String getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(String date) {
        this.lastTransactionDate = date;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        this.isLocked = locked;
    }

    public void addMoney(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0!");
        }
        this.balance += amount;
        this.totalMoneyAdded += amount;
        this.totalTransactions++;
        this.lastTransactionDate = new java.time.LocalDateTime.now().toString();
    }

    public void withdrawMoney(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance! Available: Rs."
                    + String.format("%.2f", balance)
                    + ", Requested: Rs." + String.format("%.2f", amount));
        }
        this.balance -= amount;
        this.totalMoneySpent += amount;
        this.totalTransactions++;
        this.lastTransactionDate = new java.time.LocalDateTime.now().toString();
    }

    public void transferFunds(double amount) throws InsufficientBalanceException {
        withdrawMoney(amount);
    }

    public void receiveFunds(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0!");
        }
        this.balance += amount;
        this.totalTransactions++;
        this.lastTransactionDate = new java.time.LocalDateTime.now().toString();
    }

    @Override
    public String toString() {
        return "Wallet ID: " + walletId
                + " | User ID: " + userId
                + " | Balance: Rs." + String.format("%.2f", balance)
                + " | Type: " + walletType
                + " | Status: " + (isLocked ? "LOCKED" : "ACTIVE")
                + " | Total Transactions: " + totalTransactions;
    }
}
