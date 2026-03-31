package week01.flowControl.level1;

import java.util.Scanner;

public class NaturalSumForCompare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        
        // Check if it's a natural number
        if (n <= 0) {
            System.out.println("The number " + n + " is not a natural number");
        } else {
            // Calculate using formula
            int formulaSum = n * (n + 1) / 2;
            
            // Calculate using for loop
            int loopSum = 0;
            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }
            
            // Display results
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using for loop: " + loopSum);
            
            // Compare results
            if (formulaSum == loopSum) {
                System.out.println("Both computations are correct!");
            } else {
                System.out.println("Results do not match!");
            }
        }
        
        scanner.close();
    }
}
