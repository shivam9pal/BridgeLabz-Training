package week01.arrays.level1;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input number
        System.out.print("Enter a positive number: ");
        int number = scanner.nextInt();
        
        // Check for positive integer
        if (number <= 0) {
            System.out.println("Error: Please enter a positive integer.");
            scanner.close();
            return;
        }
        
        // Create String array to save results
        String[] results = new String[number + 1];
        
        // Loop from 0 to number and apply FizzBuzz logic
        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0 && i != 0) {
                results[i] = "FizzBuzz";
            } else if (i % 3 == 0 && i != 0) {
                results[i] = "Fizz";
            } else if (i % 5 == 0 && i != 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(i);
            }
        }
        
        // Display results
        System.out.println("\nFizzBuzz Results:");
        for (int i = 0; i <= number; i++) {
            System.out.println("Position " + i + " = " + results[i]);
        }
        
        scanner.close();
    }
}
