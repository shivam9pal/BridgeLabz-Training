package week02.scenario.digitalwalletsystem;

import java.util.*;

public class DigitalWalletService {

    private Map<Integer, User> users;
    private Map<Integer, Wallet> wallets;
    private Map<Integer, Transaction> transactions;
    private int walletIdCounter = 1001;
    private int transactionIdCounter = 4001;

    public DigitalWalletService() {
        this.users = new HashMap<>();
        this.wallets = new HashMap<>();
        this.transactions = new HashMap<>();
        initializeData();
    }

    private void initializeData() {
        // Initialize sample users and wallets
        registerUser(301, "Amit Kumar", "amit@example.com", "9876543210");
        registerUser(302, "Priya Singh", "priya@example.com", "9876543211");
        registerUser(303, "Rahul Patel", "rahul@example.com", "9876543212");
        registerUser(304, "Sneha Sharma", "sneha@example.com", "9876543213");

        // Add initial balance to wallets
        try {
            wallets.get(1001).addMoney(5000);
            wallets.get(1002).addMoney(10000);
            wallets.get(1003).addMoney(7500);
            wallets.get(1004).addMoney(15000);
        } catch (Exception e) {
            System.out.println("Error initializing wallets: " + e.getMessage());
        }
    }

    // ====== USER MANAGEMENT ======
    public void registerUser(int userId, String userName, String email, String phoneNumber) {
        User user = new User(userId, userName, email, phoneNumber);
        users.put(userId, user);

        // Create wallet for user
        Wallet wallet = new Wallet(walletIdCounter++, userId);
        wallets.put(wallet.getWalletId(), wallet);

        System.out.println("✓ User and wallet created successfully!");
    }

    public User getUser(int userId) {
        return users.get(userId);
    }

    public Wallet getUserWallet(int userId) {
        for (Wallet wallet : wallets.values()) {
            if (wallet.getUserId() == userId) {
                return wallet;
            }
        }
        return null;
    }

    public Wallet getWallet(int walletId) {
        return wallets.get(walletId);
    }

    public void displayAllUsers() {
        System.out.println("\n" + "=".repeat(120));
        System.out.println("ALL REGISTERED USERS");
        System.out.println("=".repeat(120));
        if (users.isEmpty()) {
            System.out.println("No users registered!");
        } else {
            int count = 1;
            for (User user : users.values()) {
                System.out.println(count + ". " + user);
                count++;
            }
        }
        System.out.println("=".repeat(120));
    }

    // ====== WALLET MANAGEMENT ======
    public void addMoneyToWallet(int userId, double amount) throws Exception {
        Wallet wallet = getUserWallet(userId);
        if (wallet == null) {
            throw new Exception("User not found!");
        }

        wallet.addMoney(amount);

        Transaction transaction = new Transaction(
                transactionIdCounter++,
                wallet.getWalletId(),
                wallet.getWalletId(),
                amount,
                "ADD_MONEY",
                "BANK",
                "Money added to wallet"
        );
        transactions.put(transaction.getTransactionId(), transaction);

        System.out.println("✓ Money added successfully!");
        System.out.println("  New Balance: Rs." + String.format("%.2f", wallet.getBalance()));
    }

    public void withdrawMoneyFromWallet(int userId, double amount) throws InsufficientBalanceException, Exception {
        Wallet wallet = getUserWallet(userId);
        if (wallet == null) {
            throw new Exception("User not found!");
        }

        wallet.withdrawMoney(amount);

        Transaction transaction = new Transaction(
                transactionIdCounter++,
                wallet.getWalletId(),
                wallet.getWalletId(),
                amount,
                "WITHDRAW",
                "BANK",
                "Money withdrawn from wallet"
        );
        transactions.put(transaction.getTransactionId(), transaction);

        System.out.println("✓ Money withdrawn successfully!");
        System.out.println("  Remaining Balance: Rs." + String.format("%.2f", wallet.getBalance()));
    }

    public void displayWalletDetails(int userId) {
        Wallet wallet = getUserWallet(userId);
        if (wallet != null) {
            User user = getUser(userId);
            System.out.println("\n" + "=".repeat(100));
            System.out.println("WALLET DETAILS");
            System.out.println("=".repeat(100));
            System.out.println(wallet);
            System.out.println("-".repeat(100));
            System.out.println("Account Holder: " + user.getUserName());
            System.out.println("Total Money Added: Rs." + String.format("%.2f", wallet.getTotalMoneyAdded()));
            System.out.println("Total Money Spent: Rs." + String.format("%.2f", wallet.getTotalMoneySpent()));
            System.out.println("Last Transaction: " + wallet.getLastTransactionDate());
            System.out.println("=".repeat(100));
        } else {
            System.out.println("✗ Wallet not found!");
        }
    }

    // ====== TRANSFER OPERATIONS ======
    public void transferBetweenWallets(int senderUserId, int receiverUserId, double amount,
            TransferService transferService) throws InsufficientBalanceException, Exception {
        Wallet senderWallet = getUserWallet(senderUserId);
        Wallet receiverWallet = getUserWallet(receiverUserId);

        if (senderWallet == null) {
            throw new Exception("Sender wallet not found!");
        }
        if (receiverWallet == null) {
            throw new Exception("Receiver wallet not found!");
        }
        if (senderWallet.isLocked()) {
            throw new Exception("Sender wallet is locked!");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0!");
        }

        User sender = getUser(senderUserId);
        User receiver = getUser(receiverUserId);

        System.out.println("\n" + "-".repeat(100));
        System.out.println("TRANSFER DETAILS");
        System.out.println("-".repeat(100));
        System.out.println("From: " + sender.getUserName());
        System.out.println("To: " + receiver.getUserName());
        System.out.println("Amount: Rs." + String.format("%.2f", amount));
        System.out.println("Method: " + transferService.getTransferMethod());
        System.out.println("Fee: Rs." + String.format("%.2f", transferService.calculateTransactionFee(amount)));
        System.out.println("-".repeat(100));

        transferService.transferFunds(senderWallet, receiverWallet, amount);

        Transaction transaction = new Transaction(
                transactionIdCounter++,
                senderWallet.getWalletId(),
                receiverWallet.getWalletId(),
                amount,
                "TRANSFER",
                transferService.getTransferMethod(),
                "Transfer from " + sender.getUserName() + " to " + receiver.getUserName()
        );
        transactions.put(transaction.getTransactionId(), transaction);
    }

    // ====== TRANSACTION HISTORY ======
    public void displayTransactionHistory(int userId) {
        Wallet wallet = getUserWallet(userId);
        if (wallet == null) {
            System.out.println("✗ User not found!");
            return;
        }

        System.out.println("\n" + "=".repeat(140));
        System.out.println("TRANSACTION HISTORY - " + getUser(userId).getUserName());
        System.out.println("=".repeat(140));

        boolean found = false;
        for (Transaction txn : transactions.values()) {
            if (txn.getFromWalletId() == wallet.getWalletId() || txn.getToWalletId() == wallet.getWalletId()) {
                System.out.println(txn);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No transactions found!");
        }
        System.out.println("=".repeat(140));
    }

    public void displayAllTransactions() {
        System.out.println("\n" + "=".repeat(140));
        System.out.println("ALL TRANSACTIONS");
        System.out.println("=".repeat(140));

        if (transactions.isEmpty()) {
            System.out.println("No transactions recorded!");
        } else {
            for (Transaction transaction : transactions.values()) {
                System.out.println(transaction);
            }
        }
        System.out.println("=".repeat(140));
    }

    // ====== WALLET STATISTICS ======
    public void displayWalletStatistics(int userId) {
        Wallet wallet = getUserWallet(userId);
        if (wallet == null) {
            System.out.println("✗ User not found!");
            return;
        }

        User user = getUser(userId);
        System.out.println("\n" + "=".repeat(100));
        System.out.println("WALLET STATISTICS - " + user.getUserName());
        System.out.println("=".repeat(100));
        System.out.println("Current Balance: Rs." + String.format("%.2f", wallet.getBalance()));
        System.out.println("Total Money Added: Rs." + String.format("%.2f", wallet.getTotalMoneyAdded()));
        System.out.println("Total Money Spent: Rs." + String.format("%.2f", wallet.getTotalMoneySpent()));
        System.out.println("Net Wallet Value: Rs." + String.format("%.2f",
                wallet.getTotalMoneyAdded() - wallet.getTotalMoneySpent()));
        System.out.println("Total Transactions: " + wallet.getTotalTransactions());
        System.out.println("Wallet Type: " + wallet.getWalletType());
        System.out.println("=".repeat(100));
    }

    public void displaySystemStatistics() {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("SYSTEM STATISTICS");
        System.out.println("=".repeat(100));

        double totalSystemBalance = 0;
        double totalTransactionVolume = 0;

        for (Wallet wallet : wallets.values()) {
            totalSystemBalance += wallet.getBalance();
            totalTransactionVolume += wallet.getTotalMoneyAdded();
        }

        System.out.println("Total Active Users: " + users.size());
        System.out.println("Total Active Wallets: " + wallets.size());
        System.out.println("Total System Balance: Rs." + String.format("%.2f", totalSystemBalance));
        System.out.println("Total Transaction Volume: Rs." + String.format("%.2f", totalTransactionVolume));
        System.out.println("Total Transactions: " + transactions.size());
        System.out.println("=".repeat(100));
    }

    public Map<Integer, User> getAllUsers() {
        return users;
    }

    public Map<Integer, Wallet> getAllWallets() {
        return wallets;
    }

    public Map<Integer, Transaction> getAllTransactions() {
        return transactions;
    }
}
