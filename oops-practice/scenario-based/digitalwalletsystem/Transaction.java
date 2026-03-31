package week02.scenario.digitalwalletsystem;

public class Transaction {

    private int transactionId;
    private int fromWalletId;
    private int toWalletId;
    private double amount;
    private String transactionType; // ADD_MONEY, WITHDRAW, TRANSFER, RECEIVE
    private String transactionStatus; // SUCCESS, FAILED, PENDING
    private String timestamp;
    private String description;
    private String transferMethod; // BANK, WALLET

    public Transaction(int transactionId, int fromWalletId, int toWalletId, double amount,
            String type, String method, String description) {
        this.transactionId = transactionId;
        this.fromWalletId = fromWalletId;
        this.toWalletId = toWalletId;
        this.amount = amount;
        this.transactionType = type;
        this.transferMethod = method;
        this.description = description;
        this.transactionStatus = "SUCCESS";
        this.timestamp = new java.time.LocalDateTime.now().toString();
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getFromWalletId() {
        return fromWalletId;
    }

    public int getToWalletId() {
        return toWalletId;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String status) {
        this.transactionStatus = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    public String getTransferMethod() {
        return transferMethod;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId
                + " | From Wallet: " + fromWalletId
                + " | To Wallet: " + toWalletId
                + " | Amount: Rs." + String.format("%.2f", amount)
                + " | Type: " + transactionType
                + " | Method: " + transferMethod
                + " | Status: " + transactionStatus
                + " | Time: " + timestamp;
    }
}
