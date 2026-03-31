package week04.gcrcodebase.exception;

public class InterestCalculator {

    // Method that calculates interest
    static double calculateInterest(double amount, double rate, int years)
            throws IllegalArgumentException {

        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException();
        }

        // Simple Interest = (amount * rate * years) / 100
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {

        try {
            double amount = 10000;
            double rate = 5;
            int years = 2;

            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest: " + interest);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }
}

