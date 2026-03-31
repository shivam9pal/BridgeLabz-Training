package week04.gcrcodebase.collections.bankingSystem;

import java.util.*;

class BankingSystem {

    // AccountNumber  Balance
    private Map<Integer, Double> accounts = new HashMap<>();

    // Queue for withdrawal requests (AccountNumber, Amount)
    private Queue<WithdrawalRequest> queue = new LinkedList<>();

    // Add a new account
    void addAccount(int accNo, double balance) {
        accounts.put(accNo, balance);
    }

    // Add withdrawal request to queue
    void requestWithdrawal(int accNo, double amount) {
        queue.add(new WithdrawalRequest(accNo, amount));
    }

    // Process withdrawal requests
    void processWithdrawals() {
        System.out.println("\nProcessing Withdrawals:");
        while (!queue.isEmpty()) {
            WithdrawalRequest req = queue.remove();

            double balance = accounts.getOrDefault(req.accountNumber, 0.0);

            if (balance >= req.amount) {
                accounts.put(req.accountNumber, balance - req.amount);
                System.out.println("Withdrawn " + req.amount +
                        " from Account " + req.accountNumber);
            } else {
                System.out.println("Insufficient balance for Account " +
                        req.accountNumber);
            }
        }
    }

    // Display accounts sorted by balance
    void displaySortedByBalance() {
        System.out.println("\nAccounts Sorted by Balance:");

        // Balance -> List of Accounts
        TreeMap<Double, List<Integer>> sorted = new TreeMap<>();

        for (int acc : accounts.keySet()) {
            double bal = accounts.get(acc);
            sorted.putIfAbsent(bal, new ArrayList<>());
            sorted.get(bal).add(acc);
        }

        for (double bal : sorted.keySet()) {
            for (int acc : sorted.get(bal)) {
                System.out.println("Account " + acc + " = $" + bal);
            }
        }
    }

    // Helper class
    static class WithdrawalRequest {
        int accountNumber;
        double amount;

        WithdrawalRequest(int accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }
}