package week01.method;

import java.util.Scanner;

public class SimpleInterestCalculator {

    // Method to calculate simple interest
    public double calculateInterest(double p, double r, double t) {
        return (p * r * t) / 100;
    }

    public static void main(String[] args) {

        SimpleInterestCalculator sic = new SimpleInterestCalculator();
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.println("Enter Principle, Rate, and Time (separated by spaces):");

        double principle = sc.nextDouble();
        double rate = sc.nextDouble();
        double time = sc.nextDouble();

        sc.close();

        double interest = sic.calculateInterest(principle, rate, time);

        System.out.printf(
            "The Simple Interest is %.2f for Principle %.2f, Rate %.2f%%, and Time %.2f years.",
            interest, principle, rate, time
        );
    }
}
