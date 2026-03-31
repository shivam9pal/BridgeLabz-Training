package week01.arrays.level2;

import java.util.Scanner;

public class LargestDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take user input for number
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        
        // Define array to store digits
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        
        // Create index variable
        int index = 0;
        
        // Extract digits from the number
        long tempNumber = Math.abs(number); 
        while (tempNumber != 0) {
            digits[index] = (int)(tempNumber % 10);
            tempNumber = tempNumber / 10;
            index++;
            
            // If index equals maxDigit, break from loop
            if (index == maxDigit) {
                System.out.println("Warning: Number has more than " + maxDigit + " digits. Only first " + maxDigit + " digits will be considered.");
                break;
            }
        }
        
        // Variables to store largest and second largest
        int largest = 0;
        int secondLargest = 0;
        
        // Find largest and second largest
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        
        // Display results
        System.out.println("\nDigits in the number:");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i] + " ");
        }
        System.out.println("\n\nLargest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
        
        scanner.close();
    }
}
