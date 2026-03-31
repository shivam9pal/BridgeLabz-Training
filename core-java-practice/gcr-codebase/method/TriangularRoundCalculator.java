package week01.method;

import java.util.Scanner;

public class TriangularRoundCalculator {

    // Method to calculate number of rounds to complete 5 km
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;

        double totalDistance = 5000;

        // Number of rounds
        return totalDistance / perimeter;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input for sides of the triangle
        System.out.print("Enter side 1 (in meters): ");
        double side1 = sc.nextDouble();

        System.out.print("Enter side 2 (in meters): ");
        double side2 = sc.nextDouble();

        System.out.print("Enter side 3 (in meters): ");
        double side3 = sc.nextDouble();

        sc.close();

        // calling method
        double rounds = calculateRounds(side1, side2, side3);

        // Display result
        System.out.printf(
            "The athlete must complete %.2f rounds to finish a 5 km run.%n",
            rounds
        );
    }
}
