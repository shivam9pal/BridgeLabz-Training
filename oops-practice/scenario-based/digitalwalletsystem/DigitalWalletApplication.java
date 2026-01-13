package week02.scenario.digitalwalletsystem;

import java.util.*;

public class DigitalWalletApplication {

    private DigitalWalletService walletService;
    private Scanner scanner;
    private int loggedInUserId = -1;

    public DigitalWalletApplication() {
        this.walletService = new DigitalWalletService();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("WELCOME TO DIGITAL WALLET MANAGEMENT SYSTEM");
        System.out.println("=".repeat(100));

        while (true) {
            if (loggedInUserId == -1) {
                mainMenu();
            } else {
                userMenu();
            }
        }
    }

    private void mainMenu() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("MAIN MENU");
        System.out.println("-".repeat(100));
        System.out.println("1. User Login");
        System.out.println("2. Register New User");
        System.out.println("3. Admin Panel");
        System.out.println("4. Exit");
        System.out.println("-".repeat(100));
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                userLogin();
                break;
            case 2:
                registerNewUser();
                break;
            case 3:
                adminPanel();
                break;
            case 4:
                System.out.println("\n✓ Thank you for using Digital Wallet System!");
                System.exit(0);
                break;
            default:
                System.out.println("✗ Invalid choice! Please try again.");
        }
    }

    private void userLogin() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("USER LOGIN");
        System.out.println("-".repeat(100));
        System.out.print("Enter User ID: ");
        int userId = getIntInput();

        User user = walletService.getUser(userId);
        if (user != null && user.getAccountStatus().equals("ACTIVE")) {
            loggedInUserId = userId;
            System.out.println("✓ Login successful! Welcome " + user.getUserName());
        } else {
            System.out.println("✗ Invalid User ID or inactive account!");
        }
    }

    private void registerNewUser() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("REGISTER NEW USER");
        System.out.println("-".repeat(100));

        System.out.print("Enter User ID: ");
        int userId = getIntInput();

        if (walletService.getUser(userId) != null) {
            System.out.println("✗ User ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine().trim();

        try {
            walletService.registerUser(userId, name, email, phone);
            System.out.println("✓ Registration successful! Wallet created.");
        } catch (Exception e) {
            System.out.println("✗ Registration failed: " + e.getMessage());
        }
    }

    private void userMenu() {
        User user = walletService.getUser(loggedInUserId);
        System.out.println("\n" + "-".repeat(100));
        System.out.println("USER MENU - " + user.getUserName());
        System.out.println("-".repeat(100));
        System.out.println("1. View Wallet Balance");
        System.out.println("2. Add Money to Wallet");
        System.out.println("3. Withdraw Money from Wallet");
        System.out.println("4. Transfer to Another Wallet");
        System.out.println("5. View Transaction History");
        System.out.println("6. View Wallet Statistics");
        System.out.println("7. View All Users");
        System.out.println("8. Logout");
        System.out.println("-".repeat(100));
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                viewWalletBalance();
                break;
            case 2:
                addMoneyToWallet();
                break;
            case 3:
                withdrawMoneyFromWallet();
                break;
            case 4:
                transferFunds();
                break;
            case 5:
                viewTransactionHistory();
                break;
            case 6:
                viewWalletStatistics();
                break;
            case 7:
                walletService.displayAllUsers();
                break;
            case 8:
                logout();
                break;
            default:
                System.out.println("✗ Invalid choice! Please try again.");
        }
    }

    private void viewWalletBalance() {
        walletService.displayWalletDetails(loggedInUserId);
    }

    private void addMoneyToWallet() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("ADD MONEY TO WALLET");
        System.out.println("-".repeat(100));

        Wallet wallet = walletService.getUserWallet(loggedInUserId);
        System.out.println("Current Balance: Rs." + String.format("%.2f", wallet.getBalance()));
        System.out.print("Enter amount to add (Rs.): ");

        double amount = getDoubleInput();

        if (amount <= 0) {
            System.out.println("✗ Amount must be greater than 0!");
            return;
        }

        try {
            walletService.addMoneyToWallet(loggedInUserId, amount);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void withdrawMoneyFromWallet() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("WITHDRAW MONEY FROM WALLET");
        System.out.println("-".repeat(100));

        Wallet wallet = walletService.getUserWallet(loggedInUserId);
        System.out.println("Current Balance: Rs." + String.format("%.2f", wallet.getBalance()));
        System.out.print("Enter amount to withdraw (Rs.): ");

        double amount = getDoubleInput();

        if (amount <= 0) {
            System.out.println("✗ Amount must be greater than 0!");
            return;
        }

        try {
            walletService.withdrawMoneyFromWallet(loggedInUserId, amount);
        } catch (InsufficientBalanceException e) {
            System.out.println("✗ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void transferFunds() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("TRANSFER FUNDS");
        System.out.println("-".repeat(100));

        Wallet senderWallet = walletService.getUserWallet(loggedInUserId);
        User senderUser = walletService.getUser(loggedInUserId);
        System.out.println("From: " + senderUser.getUserName());
        System.out.println("Current Balance: Rs." + String.format("%.2f", senderWallet.getBalance()));

        System.out.print("Enter Receiver User ID: ");
        int receiverUserId = getIntInput();

        User receiverUser = walletService.getUser(receiverUserId);
        if (receiverUser == null) {
            System.out.println("✗ Receiver not found!");
            return;
        }

        if (receiverUserId == loggedInUserId) {
            System.out.println("✗ Cannot transfer to yourself!");
            return;
        }

        System.out.println("To: " + receiverUser.getUserName());
        System.out.print("Enter amount to transfer (Rs.): ");

        double amount = getDoubleInput();

        if (amount <= 0) {
            System.out.println("✗ Amount must be greater than 0!");
            return;
        }

        System.out.println("\n" + "-".repeat(100));
        System.out.println("SELECT TRANSFER METHOD");
        System.out.println("-".repeat(100));
        System.out.println("1. Wallet-to-Wallet Transfer (1% fee)");
        System.out.println("2. Bank Transfer (2% + Rs.5 fee)");
        System.out.println("-".repeat(100));
        System.out.print("Select transfer method: ");

        int method = getIntInput();
        TransferService transferService;

        if (method == 1) {
            transferService = new WalletTransfer();
        } else if (method == 2) {
            transferService = new BankTransfer();
        } else {
            System.out.println("✗ Invalid choice!");
            return;
        }

        try {
            walletService.transferBetweenWallets(loggedInUserId, receiverUserId, amount, transferService);
        } catch (InsufficientBalanceException e) {
            System.out.println("✗ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void viewTransactionHistory() {
        walletService.displayTransactionHistory(loggedInUserId);
    }

    private void viewWalletStatistics() {
        walletService.displayWalletStatistics(loggedInUserId);
    }

    private void adminPanel() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("ADMIN PANEL - AUTHENTICATION");
        System.out.println("-".repeat(100));
        System.out.print("Enter Admin Password: ");

        String password = scanner.nextLine().trim();

        if (!password.equals("admin123")) {
            System.out.println("✗ Incorrect password!");
            return;
        }

        boolean adminActive = true;
        while (adminActive) {
            System.out.println("\n" + "-".repeat(100));
            System.out.println("ADMIN PANEL");
            System.out.println("-".repeat(100));
            System.out.println("1. View All Users");
            System.out.println("2. View All Wallets");
            System.out.println("3. View All Transactions");
            System.out.println("4. System Statistics");
            System.out.println("5. Lock User Wallet");
            System.out.println("6. Unlock User Wallet");
            System.out.println("7. Exit Admin Panel");
            System.out.println("-".repeat(100));
            System.out.print("Enter your choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    walletService.displayAllUsers();
                    break;
                case 2:
                    viewAllWallets();
                    break;
                case 3:
                    walletService.displayAllTransactions();
                    break;
                case 4:
                    walletService.displaySystemStatistics();
                    break;
                case 5:
                    lockUserWallet();
                    break;
                case 6:
                    unlockUserWallet();
                    break;
                case 7:
                    adminActive = false;
                    System.out.println("✓ Exited Admin Panel");
                    break;
                default:
                    System.out.println("✗ Invalid choice! Please try again.");
            }
        }
    }

    private void viewAllWallets() {
        System.out.println("\n" + "=".repeat(120));
        System.out.println("ALL WALLETS");
        System.out.println("=".repeat(120));

        Map<Integer, Wallet> wallets = walletService.getAllWallets();
        if (wallets.isEmpty()) {
            System.out.println("No wallets found!");
        } else {
            int count = 1;
            for (Wallet wallet : wallets.values()) {
                System.out.println(count + ". " + wallet);
                count++;
            }
        }
        System.out.println("=".repeat(120));
    }

    private void lockUserWallet() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("LOCK USER WALLET");
        System.out.println("-".repeat(100));
        System.out.print("Enter User ID: ");
        int userId = getIntInput();

        Wallet wallet = walletService.getUserWallet(userId);
        if (wallet == null) {
            System.out.println("✗ User not found!");
            return;
        }

        wallet.setLocked(true);
        System.out.println("✓ Wallet locked successfully!");
    }

    private void unlockUserWallet() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("UNLOCK USER WALLET");
        System.out.println("-".repeat(100));
        System.out.print("Enter User ID: ");
        int userId = getIntInput();

        Wallet wallet = walletService.getUserWallet(userId);
        if (wallet == null) {
            System.out.println("✗ User not found!");
            return;
        }

        wallet.setLocked(false);
        System.out.println("✓ Wallet unlocked successfully!");
    }

    private void logout() {
        System.out.println("\n✓ Logged out successfully!");
        loggedInUserId = -1;
    }

    private int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("✗ Please enter a valid integer!");
            return -1;
        }
    }

    private double getDoubleInput() {
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("✗ Please enter a valid amount!");
            return -1;
        }
    }

    public static void main(String[] args) {
        DigitalWalletApplication app = new DigitalWalletApplication();
        app.start();
    }
}
