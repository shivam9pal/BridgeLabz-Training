package week01.arrays.level1;

import java.util.Scanner;

public class OddEvenSeparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input number
        System.out.print("Enter a positive number: ");
        int number = scanner.nextInt();
        
        // Check for natural number
        if (number <= 0) {
            System.out.println("Error: Please enter a natural number (positive integer).");
            scanner.close();
            return;
        }
        
        // Create arrays for odd and even numbers
        int[] oddNumbers = new int[number / 2 + 1];
        int[] evenNumbers = new int[number / 2 + 1];
        
        // Index variables for odd and even arrays
        int oddIndex = 0;
        int evenIndex = 0;
        
        // Separate odd and even numbers
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }
        
        // Display odd numbers
        System.out.println("\nOdd numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        
        // Display even numbers
        System.out.println("\n\nEven numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}
