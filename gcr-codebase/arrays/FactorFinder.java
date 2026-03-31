package week01.arrays.level1;

import java.util.Scanner;

public class FactorFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input number
        System.out.print("Enter a number to find its factors: ");
        int number = scanner.nextInt();
        
        // Initialize variables
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;
        
        // Find factors
        System.out.println("\nFinding factors of " + number + "...");
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // Check if array needs to be expanded
                if (index == maxFactor) {
                    // Double the array size
                    maxFactor = maxFactor * 2;
                    int[] temp = new int[maxFactor];
                    
                    // Copy elements to temp array
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }
                    
                    // Assign temp array to factors
                    factors = temp;
                }
                
                // Add factor to array
                factors[index] = i;
                index++;
            }
        }
        
        // Display factors
        System.out.println("\nFactors of " + number + ":");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}
